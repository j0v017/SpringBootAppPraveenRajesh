package com.wells.qart.eAuction.exception;

import static com.wells.qart.eAuction.testutils.TestUtils.currentTest;
import static com.wells.qart.eAuction.testutils.TestUtils.exceptionTestFile;
import static com.wells.qart.eAuction.testutils.TestUtils.testReport;
import static com.wells.qart.eAuction.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wells.qart.eAuction.controller.InterestsRestController;
import com.wells.qart.eAuction.dto.InterestsDto;
import com.wells.qart.eAuction.exceptions.InterestsNotFoundException;
import com.wells.qart.eAuction.model.exception.ExceptionResponse;
import com.wells.qart.eAuction.service.InterestsService;
import com.wells.qart.eAuction.testutils.MasterData;

@WebMvcTest(InterestsRestController.class)
@AutoConfigureMockMvc
public class InterestsExceptionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private InterestsService interestsService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCreateInterestsInvalidDataException() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		InterestsDto savedInterestsDto = MasterData.getInterestsDto();
		savedInterestsDto.setUserId(1L);

		interestsDto.setInterestedIn("Ab");

		when(this.interestsService.createInterest(interestsDto)).thenReturn(savedInterestsDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/interests")
				.content(MasterData.asJsonString(interestsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}

	@Test
	public void testInterestUpdateInvalidDataException() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		InterestsDto savedInterestsDto = MasterData.getInterestsDto();
		savedInterestsDto.setUserId(1L);

		interestsDto.setInterestedIn("Ab");

		when(this.interestsService.updateInterest(interestsDto)).thenReturn(savedInterestsDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/interests")
				.content(MasterData.asJsonString(interestsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}

	@Test
	public void testDeleteInterestInterestNotFoundException() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse("Interest with Id - 2 not Found!",
				System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());

		when(this.interestsService.deleteInterest(2L))
				.thenThrow(new InterestsNotFoundException("Interest with Id - 2 not Found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/interests/2")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);

	}

}

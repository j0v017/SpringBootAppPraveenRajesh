package com.wells.qart.eAuction.functional;

import static com.wells.qart.eAuction.testutils.TestUtils.businessTestFile;
import static com.wells.qart.eAuction.testutils.TestUtils.currentTest;
import static com.wells.qart.eAuction.testutils.TestUtils.testReport;
import static com.wells.qart.eAuction.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wells.qart.eAuction.controller.InterestsRestController;
import com.wells.qart.eAuction.dto.InterestsDto;
import com.wells.qart.eAuction.service.InterestsService;
import com.wells.qart.eAuction.testutils.MasterData;

@WebMvcTest(InterestsRestController.class)
@AutoConfigureMockMvc
public class InterestsRestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private InterestsService interestsService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCreateInterest() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		InterestsDto savedInterestsDto = MasterData.getInterestsDto();
		savedInterestsDto.setInterestId(1L);

		when(this.interestsService.createInterest(interestsDto)).thenReturn(savedInterestsDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/interests")
				.content(MasterData.asJsonString(interestsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedInterestsDto))
						? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testCreateInterestsIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		InterestsDto interestsDto = MasterData.getInterestsDto();
		InterestsDto savedInterestsDto = MasterData.getInterestsDto();
		savedInterestsDto.setInterestId(1L);
		when(interestsService.createInterest(interestsDto)).then(new Answer<InterestsDto>() {

			@Override
			public InterestsDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedInterestsDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/interests")
				.content(MasterData.asJsonString(interestsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testDeleteInterest() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		interestsDto.setInterestId(1L);
		when(this.interestsService.deleteInterest(1L)).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/interests/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(MasterData.asJsonString(interestsDto));
		System.out.println(result.getResponse().getContentAsString());
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(true)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testDeleteInterestIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		InterestsDto interestsDto = MasterData.getInterestsDto();
		interestsDto.setInterestId(1L);
		when(this.interestsService.deleteInterest(1L)).then(new Answer<Boolean>() {

			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return true;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/interests/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);
	}

	@Test
	public void testUpdateInterest() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		InterestsDto savedInterestsDto = MasterData.getInterestsDto();
		savedInterestsDto.setInterestId(1L);

		when(this.interestsService.updateInterest(interestsDto)).thenReturn(savedInterestsDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/interests")
				.content(MasterData.asJsonString(interestsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedInterestsDto))
						? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testUpdateInterestIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		InterestsDto interestsDto = MasterData.getInterestsDto();
		InterestsDto savedInterestsDto = MasterData.getInterestsDto();
		savedInterestsDto.setInterestId(1L);
		when(interestsService.updateInterest(interestsDto)).then(new Answer<InterestsDto>() {

			@Override
			public InterestsDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedInterestsDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/interests")
				.content(MasterData.asJsonString(interestsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testGetInterestsByInterestId() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();

		when(this.interestsService.getById(1L)).thenReturn(interestsDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interests/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(interestsDto)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetInterestsByIdIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		InterestsDto interestsDto = MasterData.getInterestsDto();
		when(this.interestsService.getById(1L)).then(new Answer<InterestsDto>() {

			@Override
			public InterestsDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return interestsDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interests/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testGetAllInterestsByUserId() throws Exception {
		List<InterestsDto> interestsDtos = MasterData.getInterestsDtoList();

		when(this.interestsService.getInterestsByUserId(1L)).thenReturn(interestsDtos);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interests/by-user-id/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(interestsDtos))
						? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetAllInterestsByUserIdIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<InterestsDto> interestsDtos = MasterData.getInterestsDtoList();
		when(this.interestsService.getInterestsByUserId(1L)).then(new Answer<List<InterestsDto>>() {

			@Override
			public List<InterestsDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return interestsDtos;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/interests/by-user-id/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

}

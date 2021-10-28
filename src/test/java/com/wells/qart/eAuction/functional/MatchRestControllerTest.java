package com.wells.qart.eAuction.functional;

import static com.wells.qart.eAuction.testutils.TestUtils.businessTestFile;
import static com.wells.qart.eAuction.testutils.TestUtils.currentTest;
import static com.wells.qart.eAuction.testutils.TestUtils.testReport;
import static com.wells.qart.eAuction.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.wells.qart.eAuction.dto.SellerDto;
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

import com.wells.qart.eAuction.controller.MatchRestController;
import com.wells.qart.eAuction.dto.MatchDto;
import com.wells.qart.eAuction.filter.Filter;
import com.wells.qart.eAuction.filter.Filter.FilterType;
import com.wells.qart.eAuction.service.MatchService;
import com.wells.qart.eAuction.testutils.MasterData;

@WebMvcTest(MatchRestController.class)
@AutoConfigureMockMvc
public class MatchRestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MatchService matchService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}
    
	@Test
	public void testGetAllMatches() throws Exception {
		List<MatchDto> matches = MasterData.getMatchDtoList();

		when(this.matchService.getAllMatches(1L)).thenReturn(matches);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/match/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(matches)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetAllMatchesIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<MatchDto> matches = MasterData.getMatchDtoList();
		when(this.matchService.getAllMatches(1L)).then(new Answer<List<MatchDto>>() {

			@Override
			public List<MatchDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return matches;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/match/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}
	
	@Test
	public void testGetAllPotentialMatches() throws Exception {
		List<SellerDto> matches = MasterData.getUserDtoList();
		List<Filter> filters = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		list.add("Mumbai");
		filters.add(new Filter(FilterType.CITY,list));
		when(this.matchService.getPotentialMatches(1L, filters)).thenReturn(matches);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/match/1").content(MasterData.asJsonString(filters)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(MasterData.asJsonString(matches));
		System.out.println(result.getResponse().getContentAsString());
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(matches)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetAllPotentialMatchesIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<SellerDto> matches = MasterData.getUserDtoList();
		List<Filter> filters = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		list.add("Mumbai");
		filters.add(new Filter(FilterType.CITY,list));
		when(this.matchService.getPotentialMatches(1L, filters)).then(new Answer<List<SellerDto>>() {

			@Override
			public List<SellerDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return matches;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/match/1").content(MasterData.asJsonString(filters)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] > 0 ? true : false, businessTestFile);

	}
}

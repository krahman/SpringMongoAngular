package us.coderscamp.blog.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import us.coderscamp.blog.AbstractContextControllerTests;

@RunWith(SpringJUnit4ClassRunner.class)
public class GalaxyControllerTests extends AbstractContextControllerTests{
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void getGalaxyList() throws Exception{
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/galaxy"))
				.andExpect(MockMvcResultMatchers.request().asyncStarted())
				.andExpect(MockMvcResultMatchers.request().asyncResult("galaxy result"))
				.andReturn();
		
		this.mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
		.andExpect(status().isOk())
		.andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
		.andExpect(content().string("galaxy result"));
		
				
	}
}

package com.treino.consoles.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.treino.consoles.ConsolesApplication;
import com.treino.consoles.domain.Console;
import com.treino.consoles.repositories.ConsoleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ConsolesApplication.class)
public class ConsolesControllerIntegrationTests {
	
	@MockBean
	private ConsoleRepository consoleRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getTodosConsolesTest() throws Exception {
		mockMvc.perform(get("/consoles").accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void testeDeAdicaoDeConsole() throws Exception {
		Console console = new Console();
		console.setDescricao("This is for the Players");
		console.setDataLancamento(null);
		console.setNome("Playstation 1");
		console.setStatusAtividade("Descontinuado");
		
		mockMvc.perform(post("/consoles"))
		.andExpect(status().isOk());
	}
}

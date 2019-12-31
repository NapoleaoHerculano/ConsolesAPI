package com.treino.consoles;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.treino.consoles.domain.Console;
import com.treino.consoles.domain.Fabricante;
import com.treino.consoles.repositories.ConsoleRepository;
import com.treino.consoles.repositories.FabricanteRepository;

@SpringBootApplication
public class ConsolesApplication implements CommandLineRunner {
	
	@Autowired
	FabricanteRepository fabricanteRepository;
	
	@Autowired
	ConsoleRepository consoleRepository;

	public static void main(String[] args) {
		SpringApplication.run(ConsolesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Fabricante f1 = new Fabricante(null, "Sony", "Japão", "1990");
		Fabricante f2 = new Fabricante(null, "Nintendo", "Japão", "1980");
		Fabricante f3 = new Fabricante(null, "Microsoft", "USA", "2000");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Console c1 = new Console(null, "Playstation 1", sdf.parse("03/12/1994"), "Descontinuado", "Playstation Rocks", f1);
		Console c2 = new Console(null, "Playstation 2", sdf.parse("04/03/2000"), "Descontinuado", "Playstation Rocks 2", f1);
		Console c3 = new Console(null, "Playstation 3", sdf.parse("11/11/2006"), "Descontinuado", "Playstation Rocks 3", f1);
		Console c4 = new Console(null, "Xbox", sdf.parse("15/11/2001"), "Descontinuado", "Xbox Rocks", f3);
		Console c5 = new Console(null, "Xbox 360", sdf.parse("22/11/2005"), "Descontinuado", "Xbox Rocks 360", f3);
		
		fabricanteRepository.saveAll(Arrays.asList(f1, f2, f3));
		consoleRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
	}

}

package com.marcelo.syspsi;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelo.syspsi.domain.Paciente;
import com.marcelo.syspsi.repositories.PacienteRepository;

@SpringBootApplication
public class SyspsiApplication implements CommandLineRunner {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SyspsiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Paciente pac1 = new Paciente(null, "Carla Mello", "carla@gmail.com", sdf.parse("10/04/1982"));
		Paciente pac2 = new Paciente(null, "Marcos Silva", "marcos@gmail.com", sdf.parse("23/08/1994"));
		
		pac1.getTelefones().add("222222222");
		pac2.getTelefones().addAll(Arrays.asList("333333333", "444444444"));
		
		pacienteRepository.saveAll(Arrays.asList(pac1, pac2));
	}
}

package com.marcelo.syspsi;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelo.syspsi.domain.Endereco;
import com.marcelo.syspsi.domain.Paciente;
import com.marcelo.syspsi.domain.Psicologo;
import com.marcelo.syspsi.repositories.EnderecoRepository;
import com.marcelo.syspsi.repositories.PacienteRepository;
import com.marcelo.syspsi.repositories.PsicologoRepository;

@SpringBootApplication
public class SyspsiApplication implements CommandLineRunner {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PsicologoRepository psicologoRepository;
	
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
		
		Endereco end1 = new Endereco(null, "Wenceslau", "1544", "Sala 2", "Tristeza", "92345-999", "Porto Alegre", "RS");
		Endereco end2 = new Endereco(null, "Rua dos Pinheiros", "12", "Sala 15", "Centro", "44444-444", "Porto Alegre", "RS");
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		Psicologo psi1 = new Psicologo(null, "Magda Cunha", "magda@gmail.com", "07/0721");
		psi1.getEnderecosDeAtendimento().addAll(Arrays.asList(end1, end2));
		
		psicologoRepository.save(psi1);
		
	}
}

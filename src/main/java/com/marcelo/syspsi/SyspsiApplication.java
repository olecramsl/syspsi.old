package com.marcelo.syspsi;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelo.syspsi.domain.Atendimento;
import com.marcelo.syspsi.domain.Endereco;
import com.marcelo.syspsi.domain.Paciente;
import com.marcelo.syspsi.domain.Psicologo;
import com.marcelo.syspsi.repositories.AtendimentoRepository;
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
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	public static void main(String[] args) {		
		SpringApplication.run(SyspsiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {			
		Endereco end1 = new Endereco(null, "Acesso H", "3813", null, "Restinga", "91787-878", "Porto Alegre", "RS");
		Endereco end2 = new Endereco(null, "Vicente", "95", "Casa 20", "Praia de Belas", "90110-200", "Porto Alegre", "RS");
		Endereco end3 = new Endereco(null, "Wenceslau", "1544", "Sala 2", "Tristeza", "92345-999", "Porto Alegre", "RS");
		Endereco end4 = new Endereco(null, "Rua dos Pinheiros", "12", "Sala 15", "Centro", "44444-444", "Porto Alegre", "RS");
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Paciente pac1 = new Paciente(null, "Carla Mello", "carla@gmail.com", "11111111111", sdf.parse("10/04/1982"));
		Paciente pac2 = new Paciente(null, "Marcos Silva", "marcos@gmail.com", "22222222222", sdf.parse("23/08/1994"));
		
		pac1.getEnderecos().add(end1);
		pac2.getEnderecos().add(end2);
		
		pac1.getTelefones().add("222222222");
		pac2.getTelefones().addAll(Arrays.asList("333333333", "444444444"));
		
		pacienteRepository.saveAll(Arrays.asList(pac1, pac2));			
		
		Psicologo psi1 = new Psicologo(null, "Magda Cunha", "magda@gmail.com", "33333333333", "07/0721");
		psi1.getEnderecos().addAll(Arrays.asList(end3, end4));
		
		psicologoRepository.saveAll(Arrays.asList(psi1));
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Atendimento ated1 = new Atendimento(null, sdf1.parse("20/05/2019 10:30"), "Sessão iniciada com sucesso", 80.00, psi1, pac1, end4);
		Atendimento ated2 = new Atendimento(null, sdf1.parse("21/05/2019 15:45"), "Promessa de ascenção", 120.00, psi1, pac1, end3);
		Atendimento ated3 = new Atendimento(null, sdf1.parse("22/05/2019 09:10"), "Comprometimento e responsabilidade", 230.00, psi1, pac2, end4);
		
		atendimentoRepository.saveAll(Arrays.asList(ated1, ated2, ated3));
		
	}
}

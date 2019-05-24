package com.marcelo.syspsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.syspsi.domain.Psicologo;

@Repository
public interface PsicologoRepository extends JpaRepository<Psicologo, Integer> {

}

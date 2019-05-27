package com.marcelo.syspsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.syspsi.domain.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

}

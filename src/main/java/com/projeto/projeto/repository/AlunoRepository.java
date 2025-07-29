package com.projeto.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projeto.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}


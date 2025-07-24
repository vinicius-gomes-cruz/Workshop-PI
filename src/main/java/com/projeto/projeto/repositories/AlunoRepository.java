package com.projeto.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projeto.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}


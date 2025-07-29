package com.projeto.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projeto.model.Aluno;

@Repository // Indica que essa interface é um componente de repositório no Spring
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // A interface AlunoRepository estende JpaRepository, que fornece uma série de métodos prontos para interação com o banco de dados
}

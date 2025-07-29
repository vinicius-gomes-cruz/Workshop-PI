package com.projeto.projeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados
@Getter // Gera automaticamente os métodos getter para todos os campos
@Setter // Gera automaticamente os métodos setter para todos os campos
@NoArgsConstructor // Gera um construtor sem parâmetros (necessário para o JPA)
@AllArgsConstructor // Gera um construtor com todos os parâmetros, ou seja, um construtor para todos os campos
@Table(name = "alunos") // Define o nome da tabela no banco de dados, associando a classe à tabela "alunos"
public class Aluno {

    @Id // Indica que este campo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Informa que o valor da chave primária será gerado automaticamente pelo banco de dados, utilizando a estratégia "IDENTITY"
    private Long id;

    private String nome;

    private String email;
}

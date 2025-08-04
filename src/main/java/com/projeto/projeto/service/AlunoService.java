package com.projeto.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto.projeto.model.Aluno;
import com.projeto.projeto.repository.AlunoRepository;

@Service // Indica que esta classe é um serviço do Spring, sendo gerenciada pelo contêiner do Spring
public class AlunoService {

    private final AlunoRepository alunoRepository; // Injeção de dependência do repositório de alunos

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll(); // Chama o método findAll() do repositório, que retorna todos os alunos
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id); // Chama o método findById() do repositório, que retorna um Optional
    }

        public AlunoModel salvar(AlunoModel aluno) {
        return alunoRepository.save(aluno); // Chama o método save() do repositório para salvar o aluno
    }

    public AlunoModel atualizar(Long id, AlunoModel dadosAtualizados) {
        AlunoModel alunoExistente = alunoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com ID: " + id));

        alunoExistente.setNome(dadosAtualizados.getNome());
        alunoExistente.setEmail(dadosAtualizados.getEmail());
        return alunoRepository.save(alunoExistente);
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id); // Chama o método deleteById() do repositório para excluir o aluno
    }
}

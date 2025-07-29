package com.projeto.projeto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.projeto.model.Aluno;
import com.projeto.projeto.service.AlunoService;

@RestController // Define a classe como um controlador REST
@RequestMapping("/alunos") // Define o caminho base para as rotas dessa classe (endpoint "/alunos")
public class AlunoController {

    private final AlunoService alunoService; // Injeção de dependência do serviço de alunos

    // Construtor que recebe o serviço de alunos para ser utilizado pelos métodos
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping // Mapeia a requisição GET para "/alunos"
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos(); // Retorna a lista de todos os alunos
    }

    @GetMapping("/{id}") // Mapeia a requisição GET para "/alunos/{id}"
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        // Busca o aluno pelo ID e retorna o aluno ou 404 caso não encontre
        return alunoService.buscarPorId(id)
                .map(ResponseEntity::ok) // Se encontrado, retorna o aluno com HTTP 200 OK
                .orElse(ResponseEntity.notFound().build()); // Se não encontrado, retorna HTTP 404 Not Found
    }

    @PostMapping // Mapeia a requisição POST para "/alunos"
    public Aluno criar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno); // Chama o serviço para salvar o aluno e retorna o aluno criado
    }

    @DeleteMapping("/{id}") // Mapeia a requisição DELETE para "/alunos/{id}"
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        // Verifica se o aluno com o ID informado existe
        if (alunoService.buscarPorId(id).isPresent()) {
            alunoService.deletar(id); // Deleta o aluno
            return ResponseEntity.noContent().build(); // Retorna HTTP 204 No Content para sucesso
        }
        return ResponseEntity.notFound().build(); // Retorna HTTP 404 Not Found se o aluno não existir
    }

    @PutMapping("/{id}") // Mapeia a requisição PUT para "/alunos/{id}"
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        // Tenta buscar o aluno pelo ID
        return alunoService.buscarPorId(id)
                .map(alunoExistente -> {
                    // Se o aluno existir, atualiza seus dados
                    alunoExistente.setNome(alunoAtualizado.getNome());
                    alunoExistente.setEmail(alunoAtualizado.getEmail());
                    // Salva as alterações no banco de dados
                    Aluno alunoSalvo = alunoService.salvar(alunoExistente);
                    return ResponseEntity.ok(alunoSalvo); // Retorna o aluno atualizado com HTTP 200 OK
                })
                .orElse(ResponseEntity.notFound().build()); // Retorna HTTP 404 Not Found se o aluno não for encontrado
    }

}

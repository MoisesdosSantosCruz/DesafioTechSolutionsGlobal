package br.com.fatec.techsolutionsgloba.controller;


import br.com.fatec.techsolutionsgloba.model.Tarefa;
import br.com.fatec.techsolutionsgloba.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // GET - listar todas as tarefas
    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        return ResponseEntity.ok(tarefaService.listar());
    }

    // GET - buscar tarefa por índice
    @GetMapping("/{indice}")
    public ResponseEntity<Tarefa> buscarPorIndice(@PathVariable int indice) {
        Tarefa tarefa = tarefaService.buscarPorIndice(indice);
        if (tarefa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefa);
    }

    // POST - adicionar tarefa
    @PostMapping
    public ResponseEntity<Tarefa> adicionar(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.adicionar(tarefa);
        return ResponseEntity.status(201).body(novaTarefa);
    }

    // PUT - atualizar tatefa
    @PutMapping("/{indice}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable int indice, @RequestBody Tarefa tarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizar(indice, tarefa);
        if (tarefaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefaAtualizada);
    }

    // DELETE - remover tarefa
    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletar(@PathVariable int indice) {
        boolean removido = tarefaService.deletar(indice);
        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}

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


    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        return ResponseEntity.ok(tarefaService.listar());
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Tarefa> buscarPorIndice(@PathVariable int indice) {
        Tarefa tarefa = tarefaService.buscarPorIndice(indice);
        if (tarefa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefa);
    }


    @PostMapping
    public ResponseEntity<Tarefa> adicionarTafera(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.adicionar(tarefa);
        return ResponseEntity.status(201).body(novaTarefa);
    }


    @PutMapping("/{indice}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable int indice, @RequestBody Tarefa tarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizar(indice, tarefa);
        if (tarefaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefaAtualizada);
    }


    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable int indice) {
        boolean removido = tarefaService.deletar(indice);
        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}

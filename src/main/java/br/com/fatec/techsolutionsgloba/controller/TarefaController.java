package br.com.fatec.techsolutionsgloba.controller;


import br.com.fatec.techsolutionsgloba.model.Tarefa;
import br.com.fatec.techsolutionsgloba.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // GET - listar todos os usuários
    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        return ResponseEntity.ok(tarefaService.listar());
    }

    // GET - buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Integer id) {
        Optional<Tarefa> usuario = tarefaService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST - adicionar usuário
    @PostMapping
    public ResponseEntity<Tarefa> salvar(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.salvar(tarefa);
        return ResponseEntity.ok(novaTarefa);
    }

    // PUT - atualizar usuário
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Integer id, @RequestBody Tarefa tarefa)
    {
        return tarefaService.buscarPorId(id).map(t -> {
            t.setTitulo(tarefa.getTitulo());
            t.setDescricao(tarefa.getDescricao());
            t.setPrioridade(tarefa.getPrioridade());
            Tarefa atualizada = tarefaService.salvar(t);
            return ResponseEntity.ok(atualizada);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE - remover usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (tarefaService.buscarPorId(id).isPresent()) {
            tarefaService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
  /*
      Comentado para futuras oportunidades de uso.

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
*/
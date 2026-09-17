
package br.com.fatec.techsolutionsgloba.service;
import br.com.fatec.techsolutionsgloba.model.Tarefa;
import br.com.fatec.techsolutionsgloba.repository.TarefaRepository;

import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }


    public List<Tarefa> listar() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Integer id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public void deletar(Integer id) {
        tarefaRepository.deleteById(id);
    }

    public Optional<Tarefa> atualizar(Integer id, Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id).map(tarefaExistente -> {
            tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
            tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
            tarefaExistente.setPrioridade(tarefaAtualizada.getPrioridade());
            return tarefaRepository.save(tarefaExistente);
        });
    }

}


  /*
    Comentado para futuras oportunidades de uso.

  private final ArrayList<Tarefa> listaTarefa = new ArrayList<>();

    public List<Tarefa> listar() {
        return listaTarefa;

    }


    public Tarefa buscarPorIndice(int indice) {
        if (indice < 0 || indice >= listaTarefa.size()) {
            return null;
        }
        return listaTarefa.get(indice);
    }


    public Tarefa adicionar(Tarefa usuario) {
        listaTarefa.add(usuario);
        return usuario;
    }


    public Tarefa atualizar(int indice, Tarefa tarefa) {
        if (indice < 0 || indice >= listaTarefa.size()) {
            return null;
        }
        listaTarefa.set(indice, tarefa);
        return tarefa;
    }


    public boolean deletar(int indice) {
        if (indice < 0 || indice >= listaTarefa.size()) {
            return false;
        }
        listaTarefa.remove(indice);
        return true;
    }
*/
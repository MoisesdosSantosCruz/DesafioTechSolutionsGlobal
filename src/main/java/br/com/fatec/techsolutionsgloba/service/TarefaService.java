
package br.com.fatec.techsolutionsgloba.service;
import br.com.fatec.techsolutionsgloba.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {
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

}

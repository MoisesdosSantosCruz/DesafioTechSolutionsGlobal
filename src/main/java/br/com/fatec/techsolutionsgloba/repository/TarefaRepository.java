package br.com.fatec.techsolutionsgloba.repository;

import br.com.fatec.techsolutionsgloba.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}

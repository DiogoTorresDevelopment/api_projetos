package br.edu.famper.api_projetos.repository;

import br.edu.famper.api_projetos.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}

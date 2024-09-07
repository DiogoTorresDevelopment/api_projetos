package br.edu.famper.api_projetos.service;

import br.edu.famper.api_projetos.model.Projeto;
import br.edu.famper.api_projetos.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public ResponseEntity<List<Projeto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(projetoRepository.findAll());
    }

    public ResponseEntity<Projeto> findById(Long id) {
        return projetoRepository.findById(id)
                .map(projeto -> ResponseEntity.status(HttpStatus.OK).body(projeto)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Projeto save(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto update(Projeto projeto) {
        Projeto projetoSalvo = projetoRepository.findById(projeto.getId())
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));

        projetoSalvo.setNome(projeto.getNome());
        projetoSalvo.setDescricao(projeto.getDescricao());
        projetoSalvo.setDataInicio(projeto.getDataInicio());
        projetoSalvo.setDataFim(projeto.getDataFim());

        return projetoRepository.save(projetoSalvo);
    }

    public void deleteById(Long id) {
        projetoRepository.deleteById(id);
    }

}

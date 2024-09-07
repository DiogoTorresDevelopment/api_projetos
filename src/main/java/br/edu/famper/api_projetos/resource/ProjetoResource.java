package br.edu.famper.api_projetos.resource;

import br.edu.famper.api_projetos.model.Projeto;
import br.edu.famper.api_projetos.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/projeto")
public class ProjetoResource {
    
    @Autowired
    private ProjetoService projetoService;


    @GetMapping
    public ResponseEntity<List<Projeto>> findAll() {
        return projetoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable Long id) {
        return projetoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Projeto> save(@RequestBody Projeto projeto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.save(projeto));
    }

    @PutMapping
    public ResponseEntity<Projeto> update(@RequestBody Projeto projeto) {
        return ResponseEntity.status(HttpStatus.OK).body(projetoService.save(projeto));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Projeto projeto) {
        projetoService.deleteById(projeto.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    
}

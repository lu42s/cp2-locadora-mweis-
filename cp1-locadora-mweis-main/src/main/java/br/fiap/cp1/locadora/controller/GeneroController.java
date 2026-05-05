package br.fiap.cp1.locadora.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fiap.cp1.locadora.model.Genero;
import br.fiap.cp1.locadora.repository.GeneroRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping
    public ResponseEntity<Genero> create(@RequestBody Genero genero) {
        return ResponseEntity.status(HttpStatus.CREATED).body(generoRepository.save(genero));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> findById(@PathVariable Long id) {
        return generoRepository
            .findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Genero>> findAll() {
        return ResponseEntity.ok(generoRepository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> update(@PathVariable Long id, @RequestBody Genero genero) {
        Optional<Genero> optCliente = generoRepository.findById(id);

        if (optCliente.isPresent()) {
            genero.setId(id);
            Genero clienteAlterado = generoRepository.save(genero);
            return ResponseEntity.ok(clienteAlterado);
        } else {
            return ResponseEntity.notFound().build();
        }     
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) { 
        generoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
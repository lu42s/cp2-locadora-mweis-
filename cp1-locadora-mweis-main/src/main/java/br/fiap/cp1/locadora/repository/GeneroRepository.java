package br.fiap.cp1.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fiap.cp1.locadora.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
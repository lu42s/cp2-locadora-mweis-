package br.fiap.cp1.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fiap.cp1.locadora.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
}

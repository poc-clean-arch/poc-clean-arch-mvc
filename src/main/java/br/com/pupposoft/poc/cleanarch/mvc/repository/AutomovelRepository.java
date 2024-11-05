package br.com.pupposoft.poc.cleanarch.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pupposoft.poc.cleanarch.mvc.model.Automovel;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {

	List<Automovel> findByUsuarioId(Long id);

}

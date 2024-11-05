package br.com.pupposoft.poc.cleanarch.mvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pupposoft.poc.cleanarch.mvc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByCpf(String cpf);

}

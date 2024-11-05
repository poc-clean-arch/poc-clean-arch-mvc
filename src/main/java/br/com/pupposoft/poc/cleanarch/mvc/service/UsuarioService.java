package br.com.pupposoft.poc.cleanarch.mvc.service;

import br.com.pupposoft.poc.cleanarch.mvc.dto.UsuarioDto;

public interface UsuarioService {

	public Long salvar(UsuarioDto usuarioDto);
	public void alterar(UsuarioDto usuarioDto);
	public Double obterValorTaxa(Long userId);
	
}

package br.com.pupposoft.poc.cleanarch.mvc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pupposoft.poc.cleanarch.mvc.dto.UsuarioDto;
import br.com.pupposoft.poc.cleanarch.mvc.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	
    private UsuarioService usuarioService;
	
	@PostMapping
	public Long criar(@Valid @RequestBody UsuarioDto usuarioDto) {
		return usuarioService.salvar(usuarioDto);
	}
}

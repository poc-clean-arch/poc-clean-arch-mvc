package br.com.pupposoft.poc.cleanarch.mvc.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pupposoft.poc.cleanarch.mvc.dto.UsuarioDto;
import br.com.pupposoft.poc.cleanarch.mvc.exception.UsuarioComAutomovelAntigoException;
import br.com.pupposoft.poc.cleanarch.mvc.exception.UsuarioExistenteException;
import br.com.pupposoft.poc.cleanarch.mvc.exception.UsuarioMenorIdadeException;
import br.com.pupposoft.poc.cleanarch.mvc.exception.UsuarioSemAutomovelCadastradoException;
import br.com.pupposoft.poc.cleanarch.mvc.model.Automovel;
import br.com.pupposoft.poc.cleanarch.mvc.model.Usuario;
import br.com.pupposoft.poc.cleanarch.mvc.repository.AutomovelRepository;
import br.com.pupposoft.poc.cleanarch.mvc.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	private final AutomovelRepository automovelRepository;

	@Override
	@Transactional
	public Long salvar(UsuarioDto usuarioDto) {
		
		Optional<Usuario> usuarioOp = usuarioRepository.findByCpf(usuarioDto.getCpf());
		
		if(usuarioOp.isPresent()) {
			log.warn("Usuário ja existe com cpf informado. {}", usuarioDto.getCpf());
			throw new UsuarioExistenteException();
		}
		
		long idade = usuarioDto.getDataNascimento().until(LocalDate.now(), ChronoUnit.YEARS);
		if(idade < 18) {
			log.warn("Usuário menor de idade. idade={}", idade);
			throw new UsuarioMenorIdadeException();
		}
		
		List<Automovel> automoveis = automovelRepository.findByUsuarioId(usuarioDto.getId());
		if(automoveis.isEmpty()) {
			log.warn("Usuário sem automovel");
			throw new UsuarioSemAutomovelCadastradoException();
		}

		if(automoveis.stream().anyMatch(a -> a.getDataModelo().isBefore(LocalDate.now().minusYears(3)))) {
			log.warn("Usuário possui automoveis antigos");
			throw new UsuarioComAutomovelAntigoException();
		}
		
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDto.getId());
		usuario.setCpf(usuarioDto.getCpf());
		usuario.setDataNascimento(usuarioDto.getDataNascimento());
		usuario.setNome(usuario.getNome());
		
		
		return usuarioRepository.save(usuario).getId();
	}

	@Override
	public void alterar(UsuarioDto usuarioDto) {
		// TODO implementar
		
	}

	@Override
	public Double obterValorTaxa(Long userId) {
		// TODO implementar
		return null;
	}

}

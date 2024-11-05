package br.com.pupposoft.poc.cleanarch.mvc.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
	
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotNull
	private LocalDate dataNascimento;

}

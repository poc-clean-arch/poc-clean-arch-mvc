package br.com.pupposoft.poc.cleanarch.mvc.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Usuario")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 2074697474258118834L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nome;
	private LocalDate dataNascimento;
	
	private List<Automovel> automoveis;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Implementar NOSONAR
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Implementar NOSONAR
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Implementar NOSONAR
		return null;
	}
}

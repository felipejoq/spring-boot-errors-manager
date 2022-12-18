package com.uncodigo.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uncodigo.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;

	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1, "Felipe", "Jofre"));
		this.lista.add(new Usuario(2, "Lalo", "Gomez"));
		this.lista.add(new Usuario(3, "Luci", "Almacen"));
		this.lista.add(new Usuario(4, "Rodrigo", "Lobos"));
		this.lista.add(new Usuario(5, "Camila", "Ramires"));
		this.lista.add(new Usuario(6, "Oracio", "Gonzales"));
	}

	@Override
	public List<Usuario> listar() {

		return this.lista;
	}

	@Override
	public Usuario buscarPorId(Integer id) {

		Usuario resultado = null;

		for (Usuario usuario : this.lista) {
			if (usuario.getId().equals(id)) {
				resultado = usuario;
				break;
			}
		}

		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		
		Usuario user = this.buscarPorId(id);
		
		return Optional.ofNullable(user);
	}

}

package com.uncodigo.springboot.error.app.services;

import java.util.List;
import java.util.Optional;

import com.uncodigo.springboot.error.app.models.domain.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listar();
	
	public Usuario buscarPorId(Integer id);

	public Optional<Usuario> obtenerPorIdOptional(Integer id);

}

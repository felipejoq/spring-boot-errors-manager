package com.uncodigo.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uncodigo.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.uncodigo.springboot.error.app.models.domain.Usuario;
import com.uncodigo.springboot.error.app.services.UsuarioService;

@Controller
public class AppController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String index(Model model) {

		// Integer valor = 100/0;
		@SuppressWarnings("unused")
		Integer valor = Integer.parseInt("10_");

		return "index";
	}

	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {

		// Usuario user = usuarioService.buscarPorId(id);

//		if(user == null) {
//			throw new UsuarioNoEncontradoException(id.toString());
//		}

		Usuario user = usuarioService.obtenerPorIdOptional(id)
				.orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));

		model.addAttribute("titulo",
				"Detalles del usuario: ".concat(user.getNombre()).concat(" ").concat(user.getApellido()));

		model.addAttribute("usuario", user);

		return "ver";
	}

}

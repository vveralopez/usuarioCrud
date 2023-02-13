package com.vveral.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.vveral.demo.dto.UsuarioRegistrado;
import com.vveral.demo.entity.Usuario;
import com.vveral.demo.repository.IUsuarioRepository;
import com.vveral.demo.service.UsuarioService;

@ExtendWith(MockitoExtension)
public class testUsuarioService {
	
	private final IUsuarioRepository repositorioUsuario = null;
	
	@Test
	public void test1() {
		UsuarioService usuarioServicio = new UsuarioService(repositorioUsuario);
		Usuario usuario = new Usuario();
		usuario.setUsername("Victor Vera");
		usuario.setEmail("Vveralop@hotmail.com");
		usuario.setPassword("Admin2");

		UsuarioRegistrado userReq = new UsuarioRegistrado();
		
		Object resultado = usuarioServicio.guardarUsuario(usuario);
		
		Assertions.assertEquals(resultado, userReq);
		
	}

}

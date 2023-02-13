package com.vveral.demo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vveral.demo.dto.UsuarioRegistrado;
import com.vveral.demo.entity.Usuario;
import com.vveral.demo.repository.IUsuarioRepository;
import com.vveral.demo.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class testUsuarioService {
	
	@Mock
	private IUsuarioRepository usuarioRepositorio;
	
	@InjectMocks
	private UsuarioService usuarioService;
	
	@Test
	public void testGuardarUsuarioFailsClaveInvalida() {
		Usuario usuario = new Usuario();
		usuario.setUsername("Victor Vera");
		usuario.setEmail("Vveralop@hotmail.com");
		usuario.setPassword("Admin2");
		    
	    assertThatThrownBy(() -> usuarioService.guardarUsuario(usuario)).hasMessage("Clave invalida");
	}
	
	@Test
	public void testGuardarUsuarioFailsMailInvalido() {
		Usuario usuario = new Usuario();
		usuario.setUsername("Victor Vera");
		usuario.setEmail("Vveralop.com");
		usuario.setPassword("Admin21");
		    
	    assertThatThrownBy(() -> usuarioService.guardarUsuario(usuario)).hasMessage("Correo invalido");
	}
	
	@Test
	public void testGuardaUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setUsername("Victor Vera");
		usuario.setEmail("Vveralop@hotmail.com");
		usuario.setPassword("Admin22");
		
		Usuario usuarioEsperado = new Usuario();
		usuario.setUsername("Victor Vera");
		usuario.setEmail("Vveralop@hotmail.com");
		usuario.setPassword("Admin22");
		
		Mockito.when(usuarioRepositorio.save(usuario)).thenReturn(usuarioEsperado);

		Assertions.assertNotNull(usuarioService.guardarUsuario(usuario));
	}

}

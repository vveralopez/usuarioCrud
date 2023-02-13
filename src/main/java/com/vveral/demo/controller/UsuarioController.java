package com.vveral.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vveral.demo.dto.UsuarioRegistrado;
import com.vveral.demo.entity.Usuario;
import com.vveral.demo.service.IUsuarioService;

import exceptions.ErrorDto;

@RestController
@ControllerAdvice
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	public UsuarioController(IUsuarioService usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}

	private final IUsuarioService usuarioServicio;

	@PostMapping
	public ResponseEntity<Object> guardarUsuario(@RequestBody Usuario usuario) {
		UsuarioRegistrado respuesta = usuarioServicio.guardarUsuario(usuario);			
		return new ResponseEntity<Object> (respuesta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> leerUsuario(@PathVariable("id") Long idUsuario) {
		return new ResponseEntity<Usuario>(usuarioServicio.obtenerUsuario(idUsuario), HttpStatus.OK );
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> modificarUsuario(@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioServicio.usuarioModificar(idUsuario, usuario), HttpStatus.OK );
	}
	
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> borrarUsuario(@PathVariable("id") Long idUsuario) {
	//	boolean responder = usuarioServicio.eliminarUsuario(idUsuario);
		
	//	if (responder) {
	//		return new ResponseEntity<HttpStatus>(HttpStatus.OK);		
	//	}else {
	//		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	//	}
	//}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDto> runtimeException(RuntimeException e) {
	ErrorDto dto = new ErrorDto();
	dto.setMensaje(e.getMessage());
		//result = new ResponseApi(new Date(), "[Exception Response] - Exception: " + e.getMessage(), 500, "Error TEST");
		return new ResponseEntity<>(dto, HttpStatus.NOT_ACCEPTABLE);
	}
	
	
}

package com.vveral.demo.service;

import java.util.Date;
import java.util.EmptyStackException;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vveral.demo.dto.UsuarioRegistrado;
import com.vveral.demo.entity.Usuario;
import com.vveral.demo.repository.IUsuarioRepository;

import exceptions.ResponseApi;

@Service
public class UsuarioService implements IUsuarioService {

	private final IUsuarioRepository repositorioUsuario;
	
	public UsuarioService(IUsuarioRepository repositorioUsuario) {
		super();
		this.repositorioUsuario = repositorioUsuario;
	}

	@Override
	public UsuarioRegistrado guardarUsuario(Usuario usuario) {
		Usuario valor = repositorioUsuario.findByEmail(usuario.getEmail());
		if (valor != null) {
			throw new RuntimeException("El correo ya esta registrado");
		}
		
		boolean validaClave = validaClave(usuario.getPassword());
		if (validaClave) {		
			boolean emailCorrecto = validaCorreo(usuario.getEmail());
			if (emailCorrecto) {
				UsuarioRegistrado nuevoUsuario = new UsuarioRegistrado();
				Date fHoy = new Date();
				usuario.setCreated(fHoy);
				usuario.setLastlogin(fHoy);
				usuario.setModifed(fHoy);
				usuario.setIsactive(true);
				usuario.setToken(UUID.randomUUID());
				Usuario usuarioCreado = repositorioUsuario.save(usuario);
				nuevoUsuario.setUsername(usuarioCreado.getUsername());
				nuevoUsuario.setCreated(usuarioCreado.getCreated());
				nuevoUsuario.setModified(usuarioCreado.getModifed());
				nuevoUsuario.setId(usuarioCreado.getId());
				nuevoUsuario.setLastlogin(usuarioCreado.getLastlogin());
				nuevoUsuario.setIsactive(usuarioCreado.getIsactive());
				nuevoUsuario.setToken(usuarioCreado.getToken());
				return nuevoUsuario;
				
			} else {
				throw new RuntimeException("Correo invalido");
			} 
		} else {
			throw new RuntimeException("Clave invalida");
		}
			
	}
	
	@Override
	public Usuario obtenerUsuario(long idUsuario) {
		return repositorioUsuario.findById(idUsuario).orElseThrow(() -> {
			  throw new RuntimeException("Usuario no existe");});
	}
	
	@Override
	public Usuario usuarioModificar(Long id, Usuario usuario) {
		boolean emailCorrecto = validaCorreo(usuario.getEmail());
		if (emailCorrecto) {
			Usuario usuarioBuscar = repositorioUsuario.findById(id).get();
			Date fHoy = new Date();
			usuarioBuscar.setModifed(fHoy);
			usuarioBuscar.setEmail(usuario.getEmail());
			usuarioBuscar.setUsername(usuario.getUsername());
			usuarioBuscar.setPassword(usuario.getPassword());
			usuarioBuscar.setPhones(usuario.getPhones());
			return repositorioUsuario.save(usuarioBuscar);
		} else {
			throw new RuntimeException("Correo invalido");
		}
	}
	
	@Override
	public boolean eliminaUsuario(Long id) {
		try {
			repositorioUsuario.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	private boolean validaCorreo(String email) {
		return email != null && !email.isEmpty() && 
				email.replaceAll("[^@]", "").length() == 1
				&& !email.contains(".@");
	}

	private static boolean validaClave(String clave) {
		String claveRegex = "^(?=.*\\d{2})(?=.*[a-z])(?=.*[A-Z]).{4,8}$";
		Pattern pat = Pattern.compile(claveRegex);
		if (clave == null)
			return false;
		return pat.matcher(clave).matches();

	}
	
}

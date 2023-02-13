package com.vveral.demo.service;

import com.vveral.demo.entity.Usuario;

public interface IUsuarioService {
   Object guardarUsuario(Usuario usuario);
   
   Usuario obtenerUsuario(long idUsuario);
   
   Usuario usuarioModificar(Long id, Usuario usuario);
   
   boolean eliminaUsuario(Long id);
}

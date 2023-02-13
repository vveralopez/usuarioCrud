package com.vveral.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.vveral.demo.entity.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

	@Transactional(readOnly = true)
	public Object findByEmail(String email);
	
}

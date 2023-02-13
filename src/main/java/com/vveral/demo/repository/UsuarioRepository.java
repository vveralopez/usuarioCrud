package com.vveral.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public class UsuarioRepository {

	@Query(nativeQuery = true,value = "select count(1) from usuario u where u.email = :email ")
	public Object findByEmail(@Param("email") String email) {
		return email;
	}

}

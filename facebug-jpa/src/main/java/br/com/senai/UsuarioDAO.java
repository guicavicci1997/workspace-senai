package br.com.senai;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
//	public default Usuario findbyEmail(int id) {
//		
//		Usuario user = new Usuario();
//		user.getEmail();
//		
//	}

}

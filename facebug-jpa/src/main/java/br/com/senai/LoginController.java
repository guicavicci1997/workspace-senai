package br.com.senai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private UsuarioDAOHibernate usuarioDAOH;
	
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "/WEB-INF/login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("senha") String senha, Model model) {
		//ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		Usuario usuario = usuarioDAOH.getUsuario(email, senha);
	
		//Usuario usuarioRecuperado =	usuarioDAO.fi
		
		//usuarioDAOH.
		
		//usuarioDAOH.getClass(email, senha);
		
		
		//System.out.println(usuario);
		
		
		if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
			model.addAttribute("mensagem", "Bem vindo" + email);
			return "/WEB-INF/msg-cadastro-login";	
			
	
		} else {
			model.addAttribute("mensagem", "O login não foi permitido para " + email);
			return "/WEB-INF/msg-cadastro-login";
		}
	}
}

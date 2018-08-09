package br.com.senai.facebugjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CadastroController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastrar() {
		return "/WEB-INF/cadastro";
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String cadastrar(Usuario usuario,
			@RequestParam(name = "termos", defaultValue = "false") Boolean usuarioConcordou, Model model) {

		if (usuarioConcordou) {
			Usuario u = new Usuario();
			u.setNome(usuario.getNome());
			u.setSobrenome(usuario.getSobrenome());
			u.setEmail(usuario.getEmail());
			u.setGenero(usuario.getGenero());
			u.setSenha(usuario.getSenha());
			u.setTelefone(usuario.getTelefone());
			u.setDataNascimento(usuario.getDataNascimento());
			
			usuarioDAO.save(u);
			
			model.addAttribute("mensagem", "Cadastro realizado com sucesso!");
			return "/WEB-INF/msg-cadastro-login";
		} else {
			model.addAttribute("mensagem", "Houve um erro em seu cadastro!");
			return "/WEB-INF/msg-cadastro-login";
		}
	}
	
	@RequestMapping(value = "/atualizar", method = RequestMethod.POST)
	public String atualizar(Usuario usuario, Model model) {
		usuario.setEmail(UsuarioAtivoUtils.usuario.getEmail());
		Usuario retornado = usuarioDAO.save(usuario);
		if (retornado != null) {
			model.addAttribute("mensagem", "Atualização realizado com sucesso");
		}
		
		return "/WEB-INF/msg-cadastro-login";
	}

	
	@RequestMapping(value = "/minha-conta", method = RequestMethod.GET)
	public String minhaConta() {
		return "/WEB-INF/minha-conta";
	}
	
	@RequestMapping(value = "/apagar", method = RequestMethod.GET)
	public String apagar(Model model) {
				
		usuarioDAO.delete(UsuarioAtivoUtils.usuario);
		
		model.addAttribute("mensagem", "Sua conta foi apagada com sucesso!");
		return "/WEB-INF/msg-cadastro-login";
	}
}

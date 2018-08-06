package br.com.senai.facebugthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

	@RequestMapping(method = RequestMethod.GET)
	public String cadastro() {
		return "WEB-INF/cadastro";
		
	}
	
	
}

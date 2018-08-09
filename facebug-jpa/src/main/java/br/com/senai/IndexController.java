package br.com.senai;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

		@RequestMapping(method = RequestMethod.GET)
		public String main (Model model) {
			model.addAttribute("dateTime", LocalDateTime.now());			
			return "/WEB-INF/index";
			
		}
}

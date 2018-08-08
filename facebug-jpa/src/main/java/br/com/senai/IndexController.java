package br.com.senai;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

		public String main (Model model) {
			model.addAttribute("dateTime", LocalDateTime.now());			
			return "index";
			
		}
}

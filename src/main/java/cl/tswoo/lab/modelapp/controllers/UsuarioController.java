package cl.tswoo.lab.modelapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import cl.tswoo.lab.modelapp.models.Usuario;
import cl.tswoo.lab.modelapp.validations.RUNValidation;

@Controller
public class UsuarioController {
	
	@Autowired
	private RUNValidation validador;
	
	@GetMapping({"","/"})
	public String index(Model model) {
		Usuario usuario = new Usuario("","",0,"");
		model.addAttribute("usuario",usuario);
		return "index";
	}
	
	@GetMapping("/ver")
	public String ver(@Valid Usuario usuario, BindingResult result, Model model) {

		validador.validate(usuario, result);
		model.addAttribute("usuario",usuario);
		
		if(result.hasErrors())
			return "index";
		
		return "ver";
	}

}

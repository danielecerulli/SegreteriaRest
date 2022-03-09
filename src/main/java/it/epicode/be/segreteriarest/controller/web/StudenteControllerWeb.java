package it.epicode.be.segreteriarest.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.be.segreteriarest.model.Studente;
import it.epicode.be.segreteriarest.service.StudenteService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/web")
public class StudenteControllerWeb {

	@Autowired
	StudenteService studenteService;

	@GetMapping("/mostraelenco")
	public ModelAndView mostraElencoStudenti() {
		log.info("Test elenco studenti su pagina Thymeleaf");
		ModelAndView view = new ModelAndView("elencostudenti");
		view.addObject("listaStudenti", studenteService.findAll());
		//model.addAttribute("listaStudenti", studenteService.findAll());
		return view;
	}

	@GetMapping("/mostraformaggiungi")
	public String mostraFormAggiungi(Studente studente, Model model) {
		log.info("Test form aggiungi studente");
		return "formstudente";
	}

	@PostMapping("/aggiungistudente")
	public String aggiungiStudente(Studente studente, BindingResult result, Model model) {
		log.info("Test aggiungi studente");
		return "Form studenti";
	}

	@GetMapping("/mostraformaggiorna/{matricola}")
	public String mostraFormAggiorna(@PathVariable String matricola, Model model) {
		log.info("Test mostra form aggiorna studente");
		return "Form studenti";
	}

	@PostMapping("/aggiornastudente/{matricola}")
	public String aggiornaStudente(@PathVariable String matricola, Studente studente, BindingResult result,
			Model model) {
		log.info("Studente aggiorna");
		return "aggiorna studente";

	}

	@GetMapping("/eliminastudente/{matricola}")
	public String eliminaStudente(@PathVariable String matricola, Model model) {
		log.info("Elimina studente");
		return "elimina studente";

	}

}

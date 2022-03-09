package it.epicode.be.segreteriarest.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class VersionController {

	@GetMapping("/version")
	public String showVersion() {
		return "2.0";
	}

}

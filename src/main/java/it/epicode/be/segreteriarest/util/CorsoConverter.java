package it.epicode.be.segreteriarest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import it.epicode.be.segreteriarest.model.CorsoDiLaurea;
import it.epicode.be.segreteriarest.service.CorsoDiLaureaService;

@Component
public class CorsoConverter implements Converter<Long, CorsoDiLaurea> {

	@Autowired
	CorsoDiLaureaService corsoService;

	@Override
	public CorsoDiLaurea convert(Long idCorso) {
		return corsoService.findById(idCorso).get();
	}

}

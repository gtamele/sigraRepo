package iim.sigra.controller.pauta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/pautaimport")
public class LeitorDePauta {
	
	
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView step0(){
		
		ModelAndView modelView = new ModelAndView("/pautas/importarPauta-form");
		
		return modelView;
		
	}

}

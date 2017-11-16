package iim.sigra.utilitarios;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	
	@RequestMapping("/mostrapagina")
	public ModelAndView execute(){
		
		System.out.println("Veja a Saida");
		
		String msg = "Tudo posso Naquele que me fortalece!";
		
		return new ModelAndView("/paginas/pagina", "msg", msg);
	}
	
	
	@RequestMapping("/pegapagina")
	public String operar(){
		
		System.out.println("Operando......!");
		
		return "/paginas/pag";
	}

}

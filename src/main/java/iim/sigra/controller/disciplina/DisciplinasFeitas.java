package iim.sigra.controller.disciplina;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iim.sigra.model.pessoa.estudante.EstudanteDAO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.usuario.UsuarioVO;

@Controller			
@RequestMapping("/discfeitasaction")
public class DisciplinasFeitas {
	
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView step0(HttpServletRequest request){
		
		ModelAndView modelAndView = new  ModelAndView("/disciplina/disciplinasFeitas-form");
		

		
		String parametro = request.getParameter("estudanteId");
		long estudanteId = Long.parseLong(parametro);
		
		
		EstudanteVO estudante = new EstudanteVO();
		EstudanteDAO estudanteDao = new EstudanteDAO();
		estudante = estudanteDao.getByID(estudanteId, new UsuarioVO());
		

	
		modelAndView.addObject("estudante", estudante);
	
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/home",  method= RequestMethod.GET)
	public ModelAndView backToMenu(){

		return new ModelAndView("menu/menu1");
	}

}

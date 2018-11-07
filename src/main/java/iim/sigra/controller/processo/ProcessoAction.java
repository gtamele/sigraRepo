package iim.sigra.controller.processo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iim.sigra.model.pessoa.PessoaDAO;
import iim.sigra.model.pessoa.PessoaVO;
import iim.sigra.model.pessoa.estudante.EstudanteDAO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.processo.ProcessoDAO;
import iim.sigra.model.processo.ProcessoVO;
import iim.sigra.model.usuario.UsuarioVO;

@Controller			
@RequestMapping("/processoaction")
public class ProcessoAction {
	
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView step0(HttpServletRequest request){
		
		ModelAndView modelAndView = new  ModelAndView("/processo/processo-form");
		

		
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

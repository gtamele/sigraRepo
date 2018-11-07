package iim.sigra.controller.inscricao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iim.sigra.model.disciplina.DisciplinaDAO;
import iim.sigra.model.disciplina.DisciplinaVO;
import iim.sigra.model.disciplina.inscricao.InscricaoDAO;
import iim.sigra.model.disciplina.inscricao.InscricaoVO;
import iim.sigra.model.endereco.EnderecoVO;
import iim.sigra.model.especialidade.EspecialidadeVO;
import iim.sigra.model.pessoa.estudante.EstudanteDAO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;


@Controller
@RequestMapping("/inscricaoaction")
public class InscricaoAction {
	
	EstudanteVO estudante = new EstudanteVO();
	long estudanteId;
	
	
	ArrayList<DisciplinaVO> disciplinas = new ArrayList<DisciplinaVO>();
	
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView step0(HttpServletRequest request){
		
	//	Model model = new Model();	
		
		ModelAndView modelView = new ModelAndView("/inscricao/inscricao-form");
		
		InscricaoVO inscricao = new InscricaoVO();
		
		if(request.getParameter("estudanteId")!=null){
			this.estudanteId = Long.parseLong(request.getParameter("estudanteId"));
			EstudanteDAO estudanteDao = new EstudanteDAO();
			this.estudante = estudanteDao.getByID(estudanteId, new UsuarioVO());
			
		}
		
		
		DisciplinaDAO disciplinaDao = new DisciplinaDAO();
		disciplinas = disciplinaDao.getAll();
		
		
		
	//	modelView.addObject("inscricao", inscricao);
		modelView.addObject("disciplinas", disciplinas);
		modelView.addObject("estudante", estudante);
		
		return modelView;
		
	}
	
	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save ( @ModelAttribute("inscricao") InscricaoVO inscricao,  @ModelAttribute("estudante") EstudanteVO estudante1, UsuarioVO user,
			@RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		inscricao.setEstudante(estudante);
		
		
		InscricaoDAO inscricaoDao = new InscricaoDAO();
		
		DisciplinaDAO discDao = new DisciplinaDAO();
		
		
		try {
			//	for (DisciplinaVO disc :String) {
					
				//	inscricao.setDisciplina(discDao.getByID(discAuxId, user));
					
					inscricaoDao.save(inscricao, user);
					
		//		}
				
				
				redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "redirect:";
	}	

}

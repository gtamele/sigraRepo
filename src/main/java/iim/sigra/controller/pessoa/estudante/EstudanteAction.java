package iim.sigra.controller.pessoa.estudante;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iim.sigra.controller.pessoa.PessoaAction;
import iim.sigra.model.especialidade.EspecialidadeDAO;
import iim.sigra.model.especialidade.EspecialidadeVO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoDAO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoVO;
import iim.sigra.model.pessoa.PessoaVO;
import iim.sigra.model.pessoa.estudante.EstudanteDAO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;

@Controller
@RequestMapping("/estudanteaction")
public class EstudanteAction {
	
	ArrayList<EspecialidadeVO> allEspc = new ArrayList<EspecialidadeVO>();
	ArrayList<TipoDocIdentificacaoVO> allTipoDocIdent = new ArrayList<TipoDocIdentificacaoVO>();
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView step0(){
		
		ModelAndView modelView = new ModelAndView("/pessoa/estudante-form");
		
		EspecialidadeDAO especDao = new EspecialidadeDAO();
		allEspc = especDao.getAll();
		allEspc.add(0, new EspecialidadeVO());
		modelView.addObject("allEspc", this.allEspc);
		
		EstudanteVO estudante = new EstudanteVO();
		estudante.setTrabalhador(true);
		modelView.addObject("estudante", estudante);
		
		return modelView;
	}
	
	
	@RequestMapping(value="/save", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView save(EstudanteVO estudante, UsuarioVO user, RedirectAttributes redirectAttributes) throws Exception{
		
		EstudanteDAO estudanteDao = new EstudanteDAO();
		estudanteDao.save(estudante,user);
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);	
		
		return new ModelAndView("/pessoa/estudante-form","estudante",estudante);
	}
	
	
	
	@RequestMapping(value="/criarpessoa",  method= RequestMethod.GET)
	public ModelAndView criarPessoa(){
		
		
		ModelAndView modelAndView = new ModelAndView("/pessoa/pessoa-form");
		
		
		
		TipoDocIdentificacaoDAO tipoDocDao = new TipoDocIdentificacaoDAO();
		allTipoDocIdent=tipoDocDao.getAll();
		allTipoDocIdent.add(0, new TipoDocIdentificacaoVO());
		
		modelAndView.addObject("allTipoDocIdent", this.allTipoDocIdent);
		
	
		TipoDocIdentificacaoVO tipoDoc = new TipoDocIdentificacaoVO();
		modelAndView.addObject("tipoDoc", tipoDoc);
		
		
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/pesquisarpessoa",  method= {RequestMethod.PUT, RequestMethod.GET})
	public ModelAndView ppesquisarPessoa(){
		
		return null;
	}
	
}

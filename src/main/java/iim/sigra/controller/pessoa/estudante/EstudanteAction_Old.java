package iim.sigra.controller.pessoa.estudante;

import java.util.ArrayList;

import javax.print.attribute.standard.Sides;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import iim.sigra.model.especialidade.EspecialidadeDAO;
import iim.sigra.model.especialidade.EspecialidadeVO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoDAO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoVO;
import iim.sigra.model.pessoa.PessoaDAO;
import iim.sigra.model.pessoa.PessoaVO;
import iim.sigra.model.pessoa.estudante.EstudanteDAO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.processo.ProcessoVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping("/estudanteaction")
public class EstudanteAction_Old {
	
	ArrayList<EspecialidadeVO> allEspc = new ArrayList<EspecialidadeVO>();
	ArrayList<TipoDocIdentificacaoVO> allTipoDocIdent = new ArrayList<TipoDocIdentificacaoVO>();
	long pessoaIdAux;
	
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView step0(HttpServletRequest request){
		
		ModelAndView modelView = new ModelAndView("/pessoa/estudante-form");
		
		String parametro = request.getParameter("pessoaId");
		EstudanteVO estudante = new EstudanteVO();
		PessoaVO pessoa = new PessoaVO();
		
		if (parametro!=null && parametro!="") {
			
			Long pessoaId = Long.parseLong(parametro);
			this.pessoaIdAux = pessoaId;
			
			PessoaDAO pDaso = new PessoaDAO();
			
			pessoa = pDaso.getByID(pessoaId, new UsuarioVO());
			estudante.setPessoa(pessoa);
			pessoa.setEstudante(estudante);
			
		}
		
		
	
		
		EspecialidadeDAO especDao = new EspecialidadeDAO();
		allEspc = especDao.getAll();
		allEspc.add(0, new EspecialidadeVO());
		modelView.addObject("allEspc", this.allEspc);
		
		
		estudante.setTrabalhador(true);
		modelView.addObject("estudante", estudante);
		modelView.addObject("pessoa", pessoa);
		return modelView;
	}
	
	
	@RequestMapping(value="/save", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView save(@ModelAttribute("estudante") EstudanteVO estudante, @ModelAttribute("pessoa") PessoaVO pessoa, UsuarioVO user) throws Exception{
		
		if (pessoa.getSelfId()==0 || pessoa.getSelfId()>1){
			PessoaDAO pDao = new PessoaDAO();
			pessoa = pDao.getByID(pessoaIdAux, new UsuarioVO());
		}
		
		EspecialidadeDAO espDdao = new EspecialidadeDAO();
		
		estudante.setPessoa(pessoa);
		pessoa.setEstudante(estudante);
		
		ProcessoVO processo = new ProcessoVO();
		processo.setEstudante(estudante);
		estudante.setProcesso(processo);
		
		
		EstudanteDAO estudanteDao = new EstudanteDAO();
		estudanteDao.save(estudante,user);
		
		ModelAndView modelAndView = new ModelAndView("/pessoa/estudante-form","estudante",estudante);
		modelAndView.addObject("especialidade", espDdao.getByID(estudante.getEspecialidade().getSelfId(), new UsuarioVO()));
		modelAndView.addObject("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		modelAndView.addObject("currStepEstudante", SigraSteps.VISUALIZAR);
		
		return modelAndView;
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
	
	@RequestMapping(value="/abortar",  method= RequestMethod.GET)
	public String abortar( RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("currStepEstudante", null);	
		return "redirect:";
	}
	
}

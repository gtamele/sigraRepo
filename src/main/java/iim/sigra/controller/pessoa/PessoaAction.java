package iim.sigra.controller.pessoa;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iim.sigra.model.contacto.ContactoVO;
import iim.sigra.model.documentoidentificacao.DocumentoIdentificacaoVO;
import iim.sigra.model.endereco.EnderecoVO;
import iim.sigra.model.especialidade.EspecialidadeDAO;
import iim.sigra.model.especialidade.EspecialidadeVO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoDAO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoVO;
import iim.sigra.model.pessoa.PessoaVO;
import iim.sigra.model.pessoa.estudante.EstudanteDAO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.processo.ProcessoDAO;
import iim.sigra.model.processo.ProcessoVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping("/estudante")
public class PessoaAction {
	
	
	ArrayList<TipoDocIdentificacaoVO> allTipoDocIdent = new ArrayList<TipoDocIdentificacaoVO>();
	ArrayList<EspecialidadeVO> allEspc = new ArrayList<EspecialidadeVO>();
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView step0( ){
		
		ModelAndView modelAndView = new ModelAndView("/pessoa/estudante-form");
		
		EstudanteVO estudante = new EstudanteVO();
		
		TipoDocIdentificacaoDAO tipoDocDao = new TipoDocIdentificacaoDAO();
		allTipoDocIdent=tipoDocDao.getAll();
		allTipoDocIdent.add(0, new TipoDocIdentificacaoVO());
		
		
		modelAndView.addObject("allTipoDocIdent", this.allTipoDocIdent);
		
	
		TipoDocIdentificacaoVO tipoDoc = new TipoDocIdentificacaoVO();
		modelAndView.addObject("tipoDoc", tipoDoc);
		
		
		EspecialidadeDAO especDao = new EspecialidadeDAO();
		allEspc = especDao.getAll();
		allEspc.add(0, new EspecialidadeVO());
		modelAndView.addObject("allEspc", this.allEspc);
		
		
		estudante.setTrabalhador(true);
		modelAndView.addObject("estudante", estudante);
		
		
		return modelAndView;
		
		
		
	}
	
	
	@RequestMapping(value="/save", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView save(@ModelAttribute("estudante") EstudanteVO estudante, @ModelAttribute("documento") DocumentoIdentificacaoVO documento, @ModelAttribute("endereco") EnderecoVO endereco,
			@ModelAttribute("contacto") ContactoVO contacto, @ModelAttribute("tipoDoc") TipoDocIdentificacaoVO tipoDoc, UsuarioVO user, @ModelAttribute("especialidade") EspecialidadeVO especialidade, 
			@RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		
		documento.setPessoa(estudante);
		estudante.setDocumento(documento);
		
		estudante.setEndereco(endereco);
		estudante.setContacto(contacto);
		
		estudante.setEspecialidade(especialidade);
		
		ProcessoVO processo = new ProcessoVO();
		processo.setEstudante(estudante);
		estudante.setProcesso(processo);
		
		TipoDocIdentificacaoDAO tipoDao = new TipoDocIdentificacaoDAO();
		EspecialidadeDAO espDdao = new EspecialidadeDAO();
		EstudanteDAO dao = new EstudanteDAO();
		
		if(action.equalsIgnoreCase("Salvar")){
			dao.save(estudante, user);
		}
		
		else if(action.equalsIgnoreCase("Actualizar")){
			dao.update(estudante, user);
		}
		
	
	
		ModelAndView modelView = new ModelAndView("/pessoa/estudante-form","estudante",estudante);
		modelView.addObject("tipoDoc", tipoDao.getByID(estudante.getDocumento().getTipoDoc().getSelfId(), user));	
		modelView.addObject("allTipoDocIdent", this.allTipoDocIdent);	
		modelView.addObject("especialidade", espDdao.getByID(estudante.getEspecialidade().getSelfId(), new UsuarioVO()));
		modelView.addObject("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);							
		modelView.addObject("currStepEstudante", SigraSteps.VISUALIZAR);
	
		
		
		return modelView;
	}
	
	
	@RequestMapping(value="/loadpessoatoestudanteform", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadPessoaToEstudanteForm(@ModelAttribute("pessoa") PessoaVO pessoa){
		
		EstudanteVO estudante = new EstudanteVO();
		
		
		
		ModelAndView modelAndView = new ModelAndView("/pessoa/estudante-form");
		
		modelAndView.addObject("estudante", estudante);
		
		return  modelAndView;
	}
	
	
	@RequestMapping(value="/remove", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView remove(@ModelAttribute("estudante") EstudanteVO estudante, UsuarioVO user){
		
		
		
		ModelAndView modelAndView = new ModelAndView("/pessoa/estudante-form");
		
		
		try {
			
			EstudanteDAO estudanteDao = new EstudanteDAO();
			ProcessoDAO procDao = new ProcessoDAO();
			
			procDao.deleteByEstudanteID(estudante.getSelfId(), user);
			estudanteDao.deleteByID(estudante.getSelfId(), user);
			
			
			modelAndView.addObject("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
			
		} catch (Exception e) {
			throw e;
		}
		
		return  modelAndView;
	}
	
	@RequestMapping(value="/home",  method= RequestMethod.GET)
	public ModelAndView backToMenu(){

		return new ModelAndView("menu/menu1");
	}

}

package iim.sigra.controller.pessoa;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iim.sigra.model.documentoidentificacao.DocumentoIdentificacaoVO;
import iim.sigra.model.endereco.EnderecoVO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoDAO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoVO;
import iim.sigra.model.pessoa.PessoaDAO;
import iim.sigra.model.pessoa.PessoaVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping("/pessoa")
public class PessoaAction {
	
	
	ArrayList<TipoDocIdentificacaoVO> allTipoDocIdent = new ArrayList<TipoDocIdentificacaoVO>();
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView step0( ){
		
		ModelAndView modelAndView = new ModelAndView("/pessoa/pessoa-form");
		
		
		TipoDocIdentificacaoDAO tipoDocDao = new TipoDocIdentificacaoDAO();
		allTipoDocIdent=tipoDocDao.getAll();
		allTipoDocIdent.add(0, new TipoDocIdentificacaoVO());
		
		modelAndView.addObject("allTipoDocIdent", this.allTipoDocIdent);
		
	
		TipoDocIdentificacaoVO tipoDoc = new TipoDocIdentificacaoVO();
		modelAndView.addObject("tipoDoc", tipoDoc);
		
		return modelAndView;
		
		
		
	}
	
	
	@RequestMapping(value="/save", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView save(@ModelAttribute("pessoa") PessoaVO pessoa, @ModelAttribute("documento") DocumentoIdentificacaoVO documento, @ModelAttribute("endereco") EnderecoVO endereco,
			@ModelAttribute("tipoDoc") TipoDocIdentificacaoVO tipoDoc, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		
		documento.setPessoa(pessoa);
		pessoa.setDocumento(documento);
		
		pessoa.setEndereco(endereco);
		
		TipoDocIdentificacaoDAO tipoDao = new TipoDocIdentificacaoDAO();
		PessoaDAO dao = new PessoaDAO();
		
		if(action.equalsIgnoreCase("Salvar")){
			dao.save(pessoa, user);
		}
		else{
			dao.update(pessoa, user);
		}
	
		ModelAndView modelView = new ModelAndView("/pessoa/pessoa-form","pessoa",pessoa);
		modelView.addObject("tipoDoc", tipoDao.getByID(pessoa.getDocumento().getTipoDoc().getSelfId(), user));	
		modelView.addObject("allTipoDocIdent", this.allTipoDocIdent);	
		modelView.addObject("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);							
		modelView.addObject("currStepPessoa", SigraSteps.VISUALIZAR);
		
		
		return modelView;
	}
	

}

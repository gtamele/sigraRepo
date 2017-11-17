package iim.sigra.controller.tipopagamento;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoDAO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;
import iim.sigra.model.pessoa.usuario.UsuarioVO;

@Controller
@RequestMapping(value={"/tipopagamento"})
public class TipoPagamentoAction {
	
	

	@RequestMapping(value="/loadpage", method=RequestMethod.GET)
	public ModelAndView showForm(){
		
		
		String msg = "Mensagem";
		System.out.println("Carregando a pagina de save....!");
		
		return new ModelAndView("/tipopagamento/tipopagamento", "msg", msg);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listAllPagamentos(){
		
		ArrayList<TipoPagamentoVO> allTipoPagamentos = new ArrayList<TipoPagamentoVO>();
		TipoPagamentoDAO tipo = new TipoPagamentoDAO();
		
		allTipoPagamentos = tipo.getAll();
		
		System.out.println(" carregando os tipos de Pagamentos......!");
		
		return new ModelAndView("/tipopagamento/tipopagamento", "allTipoPagamentos", allTipoPagamentos);
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("tipopagamento") TipoPagamentoVO tipopagamento, UsuarioVO user) throws Exception{
		
		System.out.println("salvando na BD.....!");
		
		TipoPagamentoDAO dao = new TipoPagamentoDAO();
		ArrayList<TipoPagamentoVO> allpagamentos = new ArrayList<TipoPagamentoVO>();
		
		dao.save(tipopagamento, user);
		//allpagamentos = dao.getAll();
		
		return new ModelAndView("/tipopagamento/tipopagamento", "tipopagamento", tipopagamento);
	}

}

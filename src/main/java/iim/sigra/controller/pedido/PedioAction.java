package iim.sigra.controller.pedido;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iim.sigra.model.especialidade.EspecialidadeVO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoDAO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoVO;
import iim.sigra.model.pedido.PedidoDAO;
import iim.sigra.model.pedido.PedidoVO;
import iim.sigra.model.pessoa.estudante.EstudanteDAO;
import iim.sigra.model.processo.ProcessoDAO;
import iim.sigra.model.processo.ProcessoVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping("/pedidoaction")
public class PedioAction {
	
	ArrayList<PedidoVO> allPedidos = new ArrayList<PedidoVO>();
	ArrayList<TipoPedidoVO> allTipopedidos = new ArrayList<TipoPedidoVO>();
	ProcessoVO processo = new ProcessoVO();
	long processoId;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView step0(HttpServletRequest request){
		
		ModelAndView modelView = new ModelAndView("/pedido/pedido-form");
		
		if(request.getParameter("processoId")!=null){
			this.processoId = Long.parseLong(request.getParameter("processoId"));
			ProcessoDAO procDao = new ProcessoDAO();
			this.processo = procDao.getByID(this.processoId, new UsuarioVO());
			
		}
		
		TipoPedidoDAO tipoPedidoDao = new TipoPedidoDAO();
		allTipopedidos=tipoPedidoDao.getAll();
		modelView.addObject("allTipopedidos", this.allTipopedidos);
		
		
		PedidoDAO pedidoDao = new PedidoDAO();
		this.allPedidos=pedidoDao.getAll();
		modelView.addObject("allPedidos", this.allPedidos);
		
		
		return modelView;
	}
	
	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save (PedidoVO pedido, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		
		PedidoDAO pedidoDao = new PedidoDAO();
		
		pedido.setProcesso(this.processo);
		
		if (action.equalsIgnoreCase("Cancelar")) {
			redirectAttributes.addFlashAttribute("currStepPedido", null);	
			return "redirect:";
		}
		
		else if(action.equalsIgnoreCase("Salvar")){
			pedidoDao.save(pedido,user);
		}
		
		else if (action.equalsIgnoreCase("Actualizar")){
			pedidoDao.update(pedido, user);
			
		}
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		
		return "redirect:";
	}
	

	@RequestMapping(value="/selectedPedido",  method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadPedido(@RequestParam("selfId") long id, UsuarioVO user,Model model){
		
		PedidoVO pedido = new PedidoVO();
		pedido.setSelfId(id);
		
		
		for ( PedidoVO p : this.allPedidos) {
			if(p.getSelfId()== pedido.getSelfId()){
				
				model.addAttribute("pedido", p);
			}	
		}
		
		model.addAttribute("currStepPedido", SigraSteps.VISUALIZAR);
		model.addAttribute("allPedidos", this.allPedidos);
		
		return new ModelAndView("/pedido/pedido-form" );
	}
	

	@RequestMapping(value="/remove")
	public String remove( PedidoVO pedido , UsuarioVO user, RedirectAttributes redirectAttributes) throws Exception{
		
		
		PedidoDAO pedidoDao = new PedidoDAO();
		
		pedidoDao.deleteByID(pedido.getSelfId(), user);
		
		ModelAndView modelAndView = new ModelAndView("/pedido/pedido-form");
		
		modelAndView.addObject("allPedidos", this.allPedidos );
		modelAndView.addObject("allTipopedidos", this.allTipopedidos );
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);	

		return "redirect:";
	}
	

	@RequestMapping(value="/editar",  method= {RequestMethod.GET})
	public ModelAndView editar(@RequestParam("selfId") Long selfId) throws IOException{
		
		
		ModelAndView modeView = new ModelAndView("/pedido/pedido-form", "allPedidos", this.allPedidos);
		
		PedidoVO pedido = new PedidoVO();
		pedido.setSelfId(selfId);
		
		
		for ( PedidoVO p : this.allPedidos) {
			if(p.getSelfId()== pedido.getSelfId()){
			
				modeView.addObject("pedido", p);
			}	
		}
		
		modeView.addObject("currStepPedido", SigraSteps.EDITAR);	
		modeView.addObject("allTipopedidos", this.allTipopedidos);
		
		return modeView;
		
	}
	
	@RequestMapping(value="/home",  method= RequestMethod.GET)
	public ModelAndView backToMenu(){

		return new ModelAndView("menu/menu1");
	}
}

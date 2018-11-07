package iim.sigra.controller.pessoa.estudante;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import iim.sigra.model.especialidade.EspecialidadeDAO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoDAO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoVO;
import iim.sigra.model.pessoa.estudante.EstudanteDAO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping("/pesquisaestudanteaction")
public class PesquisaEstudanteAction {
	
	ArrayList<EstudanteVO> estudantesFromPesquisa = new ArrayList<EstudanteVO>();
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView step0(){
		
		ModelAndView modelView = new ModelAndView("/pessoa/estudante/pesquisaEstudante-form");
		
		return modelView;
		
	}
	
	@RequestMapping(value="/pesquisaestudante", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView pesquisaEstudante(@ModelAttribute("estudante") EstudanteVO estudante)  {
		
		ModelAndView modelView = new ModelAndView("/pessoa/estudante/pesquisaEstudante-form");
		
		
		EstudanteDAO estudanteDao = new EstudanteDAO();
		
		estudantesFromPesquisa.clear();
		
		
		try {
			
			if(estudante.getSelfId()>0){
				EstudanteVO estudanteFromBD = new EstudanteVO();
				estudanteFromBD = estudanteDao.getByID(estudante.getSelfId(), new UsuarioVO());
					if(estudanteFromBD!=null){
						estudantesFromPesquisa.add(estudanteFromBD);
						modelView.addObject("estudantesFromPesquisa", estudantesFromPesquisa);
					}
			}
			
			else if (estudante.getNome()!=null && !estudante.getNome().isEmpty()) {
				ArrayList<EstudanteVO> estudantesFromBDByNome = new ArrayList<EstudanteVO>();
				estudantesFromBDByNome = estudanteDao.estudanteByNome(estudante, new UsuarioVO());
					if(!estudantesFromBDByNome.isEmpty()){
						estudantesFromPesquisa.addAll(estudantesFromBDByNome);
						modelView.addObject("estudantesFromPesquisa", estudantesFromPesquisa);
					}
				
			}
			
			else if (estudante.getApelido()!=null && !estudante.getApelido().isEmpty()) {
				ArrayList<EstudanteVO> estudantesFromBDByApelido = new ArrayList<EstudanteVO>();
				estudantesFromBDByApelido = estudanteDao.allEstudanteByApelido(estudante, new UsuarioVO());
					if(!estudantesFromBDByApelido.isEmpty()){
						estudantesFromPesquisa.addAll(estudantesFromBDByApelido);
						modelView.addObject("estudantesFromPesquisa", estudantesFromPesquisa);
					}
			}
			
			
				
				
			if(estudantesFromPesquisa.isEmpty()){
				modelView.addObject("statusMsg", Mensagens.NO_RECORD_FOUND_MSG);
			}
					
		} catch (Exception e) {
			return modelView;
		}	
		
 		return modelView;
		
	}
	
	
	@RequestMapping(value="/selectedEstudante",  method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadSelectedEstudannte (@RequestParam("selfId") long id, UsuarioVO user){
		
		ModelAndView modelView = new ModelAndView("/pessoa/estudante-form");
		
		EstudanteVO estudante = new EstudanteVO();
		estudante.setSelfId(id);
		
		for ( EstudanteVO tempEstudante : this.estudantesFromPesquisa) {
			if(tempEstudante.getSelfId()== estudante.getSelfId()){
			
				modelView.addObject("estudante", tempEstudante);
				
				modelView.addObject("especialidade", new EspecialidadeDAO().getByID(tempEstudante.getEspecialidade().getSelfId(), user));
				modelView.addObject("tipoDoc", new TipoDocIdentificacaoDAO().getByID(tempEstudante.getDocumento().getTipoDoc().getSelfId(), user));
				
			}	
		}
		
		modelView.addObject("currStepEstudante", SigraSteps.VISUALIZAR);
		
		return modelView;
	}
	
	
	
	
	@RequestMapping(value="/home",  method= RequestMethod.GET)
	public ModelAndView backToMenu(){

		return new ModelAndView("menu/menu1");
	}

}

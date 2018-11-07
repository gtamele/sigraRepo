package iim.sigra.controller.matricula;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iim.sigra.model.matricula.MatriculaDAO;
import iim.sigra.model.matricula.MatriculaVO;
import iim.sigra.model.pagamento.PagamentoVO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoDAO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoDAO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoVO;
import iim.sigra.model.pessoa.PessoaVO;
import iim.sigra.model.pessoa.estudante.EstudanteDAO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.processo.ProcessoVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/matriculaaction")
public class MatriculaAction {

	ArrayList<TipoPagamentoVO> allTipoPagamento = new ArrayList<TipoPagamentoVO>();
	ArrayList<MatriculaVO> allMatriculaByProcId = new ArrayList<MatriculaVO>();
	ArrayList<Integer> anosLectivo = new ArrayList<Integer>();
	EstudanteVO estudante = new EstudanteVO();
	long estudanteId;

	@Autowired
	ServletContext context;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView step0(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("/matricula/matricula-form");

		MatriculaVO matricula = new MatriculaVO();
		MatriculaDAO matriculaDao = new MatriculaDAO();
		UsuarioVO usuario = new UsuarioVO();

		if (request.getParameter("estudanteId") != null) {
			this.estudanteId = Long.parseLong(request.getParameter("estudanteId"));
			EstudanteDAO estudanteDao = new EstudanteDAO();
			this.estudante = estudanteDao.getByID(estudanteId, new UsuarioVO());

			anosLectivo.add(matricula.getAnoLectivo());
			anosLectivo.add(matricula.getAnoLectivo() + 1);
		}

		this.allMatriculaByProcId = matriculaDao.getAllMatriculaByProcId(this.estudante.getProcesso().getSelfId(),
				usuario);

		TipoPagamentoDAO tipoPagaDao = new TipoPagamentoDAO();
		allTipoPagamento = tipoPagaDao.getAll();

		modelAndView.addObject("allTipoPagamento", this.allTipoPagamento);
		modelAndView.addObject("estudante", estudante);
		modelAndView.addObject("matricula", matricula);
		modelAndView.addObject("anosLectivo", anosLectivo);
		modelAndView.addObject("allMatriculaByProcId", allMatriculaByProcId);

		return modelAndView;
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST, RequestMethod.GET })
	public String save(@ModelAttribute("matricula") MatriculaVO matricula,
			@ModelAttribute("tipoPaga") TipoPagamentoVO tipoPagamento,
			@ModelAttribute("pagamento") PagamentoVO pagamento, @RequestParam("action") String action, UsuarioVO user,
			RedirectAttributes redirectAttributes) throws Exception {

		pagamento.setTipoPagamento(tipoPagamento);
		matricula.setPagamento(pagamento);
		matricula.setProcesso(this.estudante.getProcesso());

		MatriculaDAO matriculaDao = new MatriculaDAO();

		if (action.equalsIgnoreCase("Cancelar")) {
			redirectAttributes.addFlashAttribute("currStepMatricula", null);
			return "redirect:";
		}

		else if (action.equalsIgnoreCase("Salvar")) {

			matriculaDao.save(matricula, user);
		}

		else if (action.equalsIgnoreCase("Actualizar")) {

			matriculaDao.update(matricula, user);

		}

		redirectAttributes.addFlashAttribute("allMatriculaByProcId", allMatriculaByProcId.add(matricula));
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		return "redirect:";

	}

	@RequestMapping(value = "/selectedMatricula", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loadMatricula(@RequestParam("selfId") long id, UsuarioVO user, Model model) {

		MatriculaVO matricula = new MatriculaVO();
		matricula.setSelfId(id);

		for (MatriculaVO matri : this.allMatriculaByProcId) {
			if (matri.getSelfId() == matricula.getSelfId()) {

				model.addAttribute("matricula", matri);
				model.addAttribute("estudante", estudante);
			}
		}

		model.addAttribute("currStepMatricula", SigraSteps.VISUALIZAR);

		return new ModelAndView("/matricula/matricula-form", "allMatriculaByProcId", this.allMatriculaByProcId);
	}

	/**
	 * Este Método muda o estado do formulário para estado de edição
	 * 
	 * @param selfId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/editar", method = { RequestMethod.GET })
	public ModelAndView editar(@RequestParam("selfId") Long selfId) throws IOException {

		System.out.println("matricula " + selfId);
		ModelAndView modeView = new ModelAndView("/matricula/matricula-form", "allMatriculaByProcId",
				this.allMatriculaByProcId);

		MatriculaVO matricula = new MatriculaVO();
		matricula.setSelfId(selfId);

		for (MatriculaVO matri : this.allMatriculaByProcId) {
			if (matri.getSelfId() == matricula.getSelfId()) {

				modeView.addObject("matricula", matri);
			}
		}

		modeView.addObject("estudante", this.estudante);
		modeView.addObject("allTipoPagamento", this.allTipoPagamento);
		modeView.addObject("anosLectivo", this.anosLectivo);
		modeView.addObject("currStepMatricula", SigraSteps.EDITAR);

		return modeView;

	}

	@RequestMapping(value = "/remove", method = { RequestMethod.POST, RequestMethod.GET })
	public String remove(@RequestParam("selfId") long id, UsuarioVO user, RedirectAttributes redirectAttributes)
			throws Exception {

		MatriculaVO matricula = new MatriculaVO();
		MatriculaDAO matriculaDao = new MatriculaDAO();
		
		matriculaDao.deleteByID(id, user);

		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);

		return "redirect:";
	}

	@RequestMapping(value = "/abortaredicao", method = RequestMethod.GET)
	public String abortar(RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute("currStepMatricula", null);
		return "redirect:";
	}

	@RequestMapping(value = "/printcomprovativo", method = RequestMethod.GET, produces = "application/pdf")
	public @ResponseBody HttpEntity<byte[]> downloadComprovativo(@RequestParam("selfId") long id) throws IOException {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);
		byte file[] = null;
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "pdf"));
		//header.setContentDispositionFormData("attachment", "Comprovatico");
		header.set("Content-Disposition", "inline; filename=" + "Comprovativo");

		try {
			MatriculaDAO matriculaDAO = new MatriculaDAO();

			JasperPrint jasperPrint = createJasperPrint(context.getRealPath("/relatorios/matriculaComprovativo.jasper"),
					parameters, matriculaDAO.getConnection());

			file = JasperExportManager.exportReportToPdf(jasperPrint);
			
			header.setContentLength(file.length);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return new HttpEntity<byte[]>(file, header);
	}

//	@RequestMapping(value = "/printcomprovativo", method = RequestMethod.GET)
//	public ModelAndView imprimirComprovativo(HttpServletResponse resp, @RequestParam("selfId") long id)
//			throws JRException {
//
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("id", id);
//
//		ModelAndView mav = new ModelAndView("/matricula/matricula-form", "allMatriculaByProcId",
//				this.allMatriculaByProcId);
//
//		// URL reportTemplate =
//		// getClass().getClassLoader().getResource("iim/sigra/relatorios/matriculaComprovativo.jrxml");
//		//
//		// JasperReport jReportPath =
//		// JasperCompileManager.compileReport(reportTemplate.getPath());
//		//
//		//
//		// JasperPrint jasperPrint = JasperFillManager.fillReport(jReportPath,
//		// parameters);
//		//
//		// mav.addObject("printReport", jasperPrint);
//
//		try {
//			MatriculaDAO matriculaDAO = new MatriculaDAO();
//
//			JasperPrint jasperPrint = createJasperPrint(context.getRealPath("/relatorios/matriculaComprovativo.jasper"),
//					parameters, matriculaDAO.getConnection());
//
//			// byte file [] =
//			// JasperExportManager.exportReportToPdf(jasperPrint);
//
//			mav.addObject("printReport", jasperPrint);
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return mav;
//
//	}

	/**
	 * 
	 * @param filePath
	 * @param parameters
	 * @return
	 * @throws JRException
	 * @throws FileNotFoundException
	 */
	private JasperPrint createJasperPrint(String filePath, Map<String, Object> parameters, Connection conn)
			throws JRException, FileNotFoundException {
		InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
		return JasperFillManager.fillReport(inputStream, parameters, conn);
	}
}

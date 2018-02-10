package iim.sigra.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import iim.sigra.model.departamento.DepartamentoDAO;
import iim.sigra.model.departamento.DepartamentoVO;
import iim.sigra.model.documentoidentificacao.DocumentoIdentificacaoDAO;
import iim.sigra.model.documentoidentificacao.DocumentoIdentificacaoVO;
import iim.sigra.model.endereco.EnderecoDAO;
import iim.sigra.model.endereco.EnderecoVO;
import iim.sigra.model.especialidade.EspecialidadeDAO;
import iim.sigra.model.especialidade.EspecialidadeVO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoDAO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoVO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoDAO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;
import iim.sigra.model.parametrizacao.tipousuario.TipoUsuarioDAO;
import iim.sigra.model.parametrizacao.tipousuario.TipoUsuarioVO;
import iim.sigra.model.pessoa.PessoaDAO;
import iim.sigra.model.pessoa.PessoaVO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.usuario.UsuarioDAO;
import iim.sigra.model.usuario.UsuarioVO;

public class TestaPesistencia {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		
		UsuarioVO user = new UsuarioVO();
		UsuarioDAO daoU = new UsuarioDAO();
//		TipoDocIdentificacaoVO tipoDoc = new TipoDocIdentificacaoVO();
//		tipoDoc.setSelfId(1);
		
		/**
		PessoaVO pessoa = new PessoaVO();
		PessoaDAO pDao = new PessoaDAO();
		DocumentoIdentificacaoDAO docDao = new DocumentoIdentificacaoDAO();
		EnderecoDAO endDao = new EnderecoDAO();
		**/
	
		EstudanteVO estudante = new EstudanteVO();
		
		
	}
		
}

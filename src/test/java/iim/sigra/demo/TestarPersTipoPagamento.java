package iim.sigra.demo;

import org.junit.Test;

import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoDAO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;
import iim.sigra.model.pessoa.usuario.UsuarioVO;
import iim.sigra.utilitarios.DAOFactory;

public class TestarPersTipoPagamento {
	
	UsuarioVO user = new UsuarioVO();
	


	
	@Test
	public void testeSave() throws Exception{
		
		TipoPagamentoVO tipoPagamento = new TipoPagamentoVO(0, "Designa��o 4", "Descri��o 4");
		TipoPagamentoDAO tipoPagamentoDao =   DAOFactory.tipoPagamentoInstance();
		
		tipoPagamentoDao.save(tipoPagamento, user);
		
		System.out.println(tipoPagamento+" Inserido com sucesso na BD");
		
	}
}

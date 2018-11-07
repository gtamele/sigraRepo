package iim.sigra.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

import iim.sigra.model.cliente.Cliente;
import iim.sigra.model.cliente.ClienteDAO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoDAO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.DAOFactory;

public class TestarPersTipoPagamento {
	
	UsuarioVO user = new UsuarioVO();
	


	
	@Test
	public void testeSave() throws Exception{
		
		/**
		
		TipoPagamentoVO tipoPagamento = new TipoPagamentoVO(0, "Designação 4", "Descrição 4");
		TipoPagamentoDAO tipoPagamentoDao =   DAOFactory.tipoPagamentoInstance();
		
		tipoPagamentoDao.save(tipoPagamento, user);
		
		System.out.println(tipoPagamento+" Inserido com sucesso na BD");
		**/
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Data "+LocalDate.now());
		
		
		
		Cliente cliente = new Cliente ();
	//	ClienteDAO cdao =   DAOFactory.clienteDaoInstance();
		
		cliente.setApelido("Apelido");
		cliente.setName("Nome");
		
    //		cdao.save(cliente, user);
		
		System.out.println(cliente+" Inserido com sucesso na BD");
	}
}

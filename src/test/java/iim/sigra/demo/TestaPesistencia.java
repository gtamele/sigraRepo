package iim.sigra.demo;

import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoDAO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoDAO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoVO;
import iim.sigra.model.pessoa.usuario.UsuarioVO;
import iim.sigra.utilitarios.DAOFactory;

public class TestaPesistencia {

	public static void main(String[] args) throws Exception {

		UsuarioVO user = new UsuarioVO();
		
		
		
		TipoPedidoVO tipo = new TipoPedidoVO();
		TipoPedidoDAO dao = new TipoPedidoDAO();
		dao.getEntityManager();	
		
		
		tipo.setDescricao("Pedido solicitado 8");
		tipo.setDesignacao("pedido de Certificado 8");
		
		dao.persist(tipo);
		
		System.out.println("Tipo inserido com Sucesso!");
		
		
		
		
		TipoPagamentoVO tipoPagamento = new TipoPagamentoVO();
		TipoPagamentoDAO tipoPagamentoDao =   DAOFactory.tipoPagamentoInstance();
		
		tipoPagamento.setDesignacao("Tipo Pagamento 8");
		tipoPagamento.setDescricao("Para pagamento urgente 8");
		
		tipoPagamentoDao.save(tipoPagamento, user);
		
		System.out.println(tipoPagamento+" Inserido com sucesso na BD");
	}

}

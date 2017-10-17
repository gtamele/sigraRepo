package iim.sigra.utilitarios;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoDAO;

public final class DAOFactory {
	
	private DAOFactory (){}
	
	private static final String PERSISTENCE_UNIT_NAME = "sigrasoft";
	private static EntityManagerFactory entityMangerFactoryInstance;
	
	public static EntityManagerFactory entityMangerFactoryInstance(){
		
		if(entityMangerFactoryInstance == null){
			entityMangerFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		
		return entityMangerFactoryInstance;
		
	}
	
	private static TipoPagamentoDAO tipoPagamentoDaoInstance;
	
	public static TipoPagamentoDAO tipoPagamentoInstance(){
		if(tipoPagamentoDaoInstance == null){
			tipoPagamentoDaoInstance = new TipoPagamentoDAO();
		}
		return tipoPagamentoDaoInstance;
	}

}

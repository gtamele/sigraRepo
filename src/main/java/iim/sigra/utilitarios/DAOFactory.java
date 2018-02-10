package iim.sigra.utilitarios;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoDAO;
import iim.sigra.model.parametrizacao.tipousuario.TipoUsuarioDAO;
import iim.sigra.model.parametrizacao.tipousuario.TipoUsuarioVO;
import iim.sigra.model.pessoa.PessoaDAO;
import iim.sigra.model.usuario.UsuarioDAO;

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
	
	
	/*********TipoPagamentoDAO************/
	private static TipoPagamentoDAO tipoPagamentoDaoInstance;
	
	public static TipoPagamentoDAO tipoPagamentoInstance(){
		if(tipoPagamentoDaoInstance == null){
			tipoPagamentoDaoInstance = new TipoPagamentoDAO();
		}
		return tipoPagamentoDaoInstance;
	}
	
	
	/*********TipoTipo************/
	private static TipoUsuarioDAO tipoUsuarioDaoInstance;
	
	public static TipoUsuarioDAO tipoUsuarioDaoInstance(){
		if(tipoUsuarioDaoInstance == null){
			tipoUsuarioDaoInstance = new TipoUsuarioDAO();
		}
		return tipoUsuarioDaoInstance;
	}
	
	
	/*********PessoaDAO************ **/
	
	private static PessoaDAO pessoaDaoInstance;
	
	public static PessoaDAO pessoaDaoInstance(){
		if(pessoaDaoInstance == null){
			pessoaDaoInstance = new PessoaDAO();
		}
		return pessoaDaoInstance;
	}
		
	
	/** *******UsuarioDAO***********/
		
	private static UsuarioDAO usuarioDaoInstance;
	
	public static UsuarioDAO usuarioDaoInstance(){
		if(usuarioDaoInstance == null){
			usuarioDaoInstance = new UsuarioDAO();
		}
		return usuarioDaoInstance;
	} 

}

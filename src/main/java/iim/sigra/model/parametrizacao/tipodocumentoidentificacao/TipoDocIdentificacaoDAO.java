package iim.sigra.model.parametrizacao.tipodocumentoidentificacao;

import javax.persistence.Query;

import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.GenericDAO;

public class TipoDocIdentificacaoDAO extends GenericDAO<TipoDocIdentificacaoVO>{
	
	
	public void deleteByID(long id, UsuarioVO user){
		
		String hql = "DELETE FROM TipoDocIdentificacaoVO "
					+" WHERE selfId = :id";
		
		try {
			beginTransaction();
		//	Query query = session.createQuery(hql);
			Query query = getSession().createQuery(hql);
			query.setParameter("id", id);
			int result = query.executeUpdate();
			commit();
		} catch (Exception e) {
			rollBack();
			throw e;
		}
	}

}

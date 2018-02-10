package iim.sigra.model.documentoidentificacao;

import javax.persistence.Query;

import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.GenericDAO;

public class DocumentoIdentificacaoDAO extends GenericDAO<DocumentoIdentificacaoVO> {
	
	
public void deleteByID(long id, UsuarioVO user){
		
		String hql = "DELETE FROM DocumentoIdentificacaoVO "
					+" WHERE selfId = :id";
		
		try {
			beginTransaction();
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

package iim.sigra.model.pessoa;

import javax.persistence.Query;

import iim.sigra.model.processo.ProcessoVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.GenericDAO;

public class PessoaDAO extends GenericDAO<PessoaVO> {
	
public void deleteByID(long id, UsuarioVO user){
		
		String hql = "DELETE FROM PessoaVO "
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


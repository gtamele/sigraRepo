package iim.sigra.model.departamento;

import javax.persistence.Query;

import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.GenericDAO;

public class DepartamentoDAO extends GenericDAO<DepartamentoVO> {
	
	
	public void deleteByID(long id, UsuarioVO user){
		
		String hql = "DELETE FROM DepartamentoVO "
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

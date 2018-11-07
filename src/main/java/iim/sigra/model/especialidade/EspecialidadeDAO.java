package iim.sigra.model.especialidade;

import javax.persistence.Query;

import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.GenericDAO;

public class EspecialidadeDAO extends GenericDAO<EspecialidadeVO> {

	
		
	public void deleteByID(long id, UsuarioVO user){
			
			String hql = "DELETE FROM EspecialidadeVO "
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

	
	public EspecialidadeVO getEspecialidadeById(long id, UsuarioVO user) throws Exception{
		
		EspecialidadeVO especialidade = new EspecialidadeVO();
			
			String hql = " from EspecialidadeVO "+
						 " where selfId = :selfId ";
			
			try {
				beginTransaction();
				Query query = getSession().createQuery(hql);
				query.setParameter("selfId", id);
				
				especialidade = (EspecialidadeVO) query.getSingleResult();
				
			} catch (Exception e) {
				rollBack();
				throw e;
			}
			return especialidade;
		}
}

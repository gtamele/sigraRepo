package iim.sigra.model.processo;

import javax.persistence.Query;

import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.GenericDAO;

public class ProcessoDAO extends GenericDAO<ProcessoVO>{
	
	
	public void deleteByID(long id, UsuarioVO user){
			
			String hql = "DELETE FROM ProcessoVO "
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
	
	public void deleteByEstudanteID(long id, UsuarioVO user){
		
		String hql = "DELETE FROM ProcessoVO "
					+" WHERE id_estudante = :id";
		
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

		
		public ProcessoVO getAllOfProcesso(long id, UsuarioVO user){
			
			ProcessoVO processo = new ProcessoVO();
			
			String hql = " SELECT processo.selfId, processo.dataCriacao, pessoa.nome, pessoa.apelido, especialidade.descricao  "+
						 " FROM processo "+
						 " INNER JOIN estudante ON processo.id_estudante = estudante.selfId "+
						 " INNER JOIN especialidade ON estudante.id_Especialidade = especialidade.selfId "+
						 " INNER JOIN pessoa ON pessoa.selfId = estudante.id_pessoa "+
						 " where estudante.selfId = :id ";
			
			try {
				beginTransaction();
				Query query = getSession().createQuery(hql);
				query.setParameter("id", id);
				query.setMaxResults(1);
			//	int result = query.executeUpdate();
				
				commit();
			} catch (Exception e) {
				rollBack();
				throw e;
			}
			return processo;
		}
		
		
	public ProcessoVO getProcByEstudanteId(long selfId, UsuarioVO user){
		
		ProcessoVO processo = new ProcessoVO();
			
			String hql = " from ProcessoVO "+
						 " where id_estudante = :selfId ";
			
			try {
				beginTransaction();
				Query query = getSession().createQuery(hql);
				query.setParameter("selfId", selfId);
			//	int result = query.executeUpdate();
				
				processo = (ProcessoVO) query.getSingleResult();
				
			//	commit();
			} catch (Exception e) {
				rollBack();
				throw e;
			}
			return processo;
		}
	
	
	


}

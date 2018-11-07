package iim.sigra.model.matricula;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.GenericDAO;

public class MatriculaDAO  extends GenericDAO<MatriculaVO>{
	

	public void deleteByID(long id, UsuarioVO user){
		
		String hql = "DELETE FROM MatriculaVO "
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
	
	
	public ArrayList<MatriculaVO> getAllMatriculaByProcId(long id_processo, UsuarioVO user){
		
		ArrayList<MatriculaVO> allMatriculaByProcId = new ArrayList<MatriculaVO>();
			
			String hql = " from MatriculaVO "+
						 " where id_processo = :id_processo ";
			
			try {
				beginTransaction();
				Query query = getSession().createQuery(hql);
				query.setParameter("id_processo", id_processo);
				
				allMatriculaByProcId = (ArrayList<MatriculaVO>) query.getResultList();
				
			//	commit();
			} catch (Exception e) {
				rollBack();
				throw e;
			}
			return allMatriculaByProcId;
		}
	
		public Object getAllForMatriculaComprovativo(long id, UsuarioVO user){
				
				//ArrayList<MatriculaVO> allForMatriculaComprovativo = new ArrayList<MatriculaVO>();
			
				Object allOfMatricula = new MatriculaVO();
					
					String hql  = " SELECT m.anoLectivo, m.dataExecucao FROM MatriculaVO m "+
								  " INNER JOIN  m.processo as p "+
								  " WHERE p.selfId = :id ";
					try {
						beginTransaction();
						Query query = getSession().createQuery(hql);
						query.setParameter("id", id);
						
					//	allForMatriculaComprovativo = (ArrayList<MatriculaVO>) query.getResultList();
						
						allOfMatricula =   query.getSingleResult();
						
						
					} catch (Exception e) {
						rollBack();
						throw e;
					}
					return allOfMatricula;
				}
		
		public List<?> getAllForMatriCompr(long id, UsuarioVO user){
			
			//ArrayList<MatriculaVO> allForMatriculaComprovativo = new ArrayList<MatriculaVO>();
		
			List<?> lista;
				
				String hql  = " From MatriculaVO as matri "+
							  " INNER JOIN  matri.processo as proc "+
							  " INNER JOIN  proc.estudante as est "+
							  " INNER JOIN  est.especialidade as esp "+
							  " INNER JOIN  matri.pagamento as pag "+
							  " WHERE matri.selfId = :id ";
				try {
					beginTransaction();
					Query query = getSession().createQuery(hql);
					query.setParameter("id", id);
					
				//	allForMatriculaComprovativo = (ArrayList<MatriculaVO>) query.getResultList();
					
					lista =   query.getResultList();
					
					
				} catch (Exception e) {
					rollBack();
					throw e;
				}
				return lista;
			}

	
	
}

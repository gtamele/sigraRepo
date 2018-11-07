package iim.sigra.model.pessoa.estudante;

import java.util.ArrayList;

import javax.persistence.Query;

import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.GenericDAO;

public class EstudanteDAO extends GenericDAO<EstudanteVO> {
	
	
	public EstudanteVO getEstudanteById(long id, UsuarioVO user) throws Exception{
			
			EstudanteVO estudante = new EstudanteVO();
				
				String hql = " from EstudanteVO "+
							 " where id_estudante = :selfId ";
				
				try {
					beginTransaction();
					Query query = getSession().createQuery(hql);
					query.setParameter("selfId", id);
					
					estudante = (EstudanteVO) query.getSingleResult();
					
				} catch (Exception e) {
					rollBack();
					throw e;
				}
				return estudante;
			}
		
	
		
		
	public ArrayList<EstudanteVO> allEstudanteByApelido(EstudanteVO estudante, UsuarioVO user) throws Exception{
		
		
		ArrayList<EstudanteVO> allEstudanteByApelido = new ArrayList<EstudanteVO>();
			
			String hql = " from EstudanteVO "+
						 " where apelido = :apelido ";
			
			try {
				beginTransaction();
				Query query = getSession().createQuery(hql);
				query.setParameter("apelido", estudante.getApelido());
				
				allEstudanteByApelido = (ArrayList<EstudanteVO>) query.getResultList();
				
			} catch (Exception e) {
				rollBack();
				throw e;
			}
			return allEstudanteByApelido;
		}
		
	public ArrayList<EstudanteVO> estudanteByNome(EstudanteVO estudante, UsuarioVO user) throws Exception{
		
		
		ArrayList<EstudanteVO> estudanteByNome = new ArrayList<EstudanteVO>();
			
			String hql = " from EstudanteVO "+
						 " where nome like :nome";
			
			try {
				beginTransaction();
				Query query = getSession().createQuery(hql);
				query.setParameter("nome", "%"+estudante.getNome()+"%");
				
				estudanteByNome = (ArrayList<EstudanteVO>) query.getResultList();
				
			} catch (Exception e) {
				rollBack();
				throw e;
			}
			return estudanteByNome;
		}
	
	
	public void deleteByID(long id, UsuarioVO user){
			
			String hql = "DELETE FROM EstudanteVO "
						+" WHERE id_estudante = :selfId";
			
			try {
				beginTransaction();
				Query query = getSession().createQuery(hql);
				query.setParameter("selfId", id);
				int result = query.executeUpdate();
				commit();
			} catch (Exception e) {
				rollBack();
				throw e;
			}
		}
	

}

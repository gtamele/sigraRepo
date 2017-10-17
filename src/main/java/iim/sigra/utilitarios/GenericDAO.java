package iim.sigra.utilitarios;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import iim.sigra.model.pessoa.usuario.UsuarioVO;


public abstract class GenericDAO<T> {
	
	
	private final EntityManager entityManger;
	private final EntityManagerFactory factory;
	private  Class<?> classe;
	
	
	public GenericDAO(){
		this(DAOFactory.entityMangerFactoryInstance());
	}
	
	
	public GenericDAO(EntityManagerFactory factory) {
		this.entityManger = factory.createEntityManager();
		this.factory = factory;
		this.classe = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	}
	

	public void beginTransaction (){
		this.entityManger.getTransaction().begin();
	}
	
	public void commit(){
		this.entityManger.getTransaction().commit();
	}
	
	public void close(){
		this.entityManger.close();
		this.factory.close();
	}
	
	public void rollBack(){
		this.entityManger.getTransaction().rollback();
	}
	
	
	
	public void save(T entidade, UsuarioVO user) throws Exception{
		
		try {
			this.beginTransaction();
			this.entityManger.persist(entidade);
			this.commit();
		} catch (Exception e) {
			rollBack();
			throw e;
		}
		
	}
	
	public void update(T entidade, UsuarioVO user) throws Exception{
		
		try {
			beginTransaction();
			entityManger.merge(entidade);
			commit();
			
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
		
	}
	
	
	public ArrayList<T> getAll(){
		
		return (ArrayList<T>) entityManger.createQuery(("FROM "+classe.getName())).getResultList();
		//return (ArrayList<T>) entityManger.createQuery(("FROM "+classe.getName())).getResultList();
	}
	
	
	public T getByID(long selfId, UsuarioVO user){
		
		return (T) entityManger.find(classe, selfId);
		
	}
	
	
	public void delete(T entidade, UsuarioVO user) throws Exception{
		
		try {
			beginTransaction();
			entityManger.remove(entidade);
			commit();
		} catch (Exception e) {
			rollBack();
			throw e;
		}
	}
	
}

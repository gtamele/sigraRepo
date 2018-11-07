package iim.sigra.utilitarios;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.SessionImpl;

import iim.sigra.model.usuario.UsuarioVO;

public abstract class GenericDAO<T> {

	protected final EntityManager entityManager;
	private final EntityManagerFactory factory;
	protected Class<?> classe;
	// Session session = (Session) this.entityManager.getDelegate();
	private Session session;

	public GenericDAO() {
		this(DAOFactory.entityMangerFactoryInstance());
	}

	public GenericDAO(EntityManagerFactory factory) {
		this.entityManager = factory.createEntityManager();
		this.factory = factory;
		this.classe = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		session = (Session) this.entityManager.getDelegate();
	}

	public void beginTransaction() {
		this.entityManager.getTransaction().begin();
	}

	public void commit() {
		this.entityManager.getTransaction().commit();
	}

	public void close() {
		this.entityManager.close();
		this.factory.close();
	}

	public void rollBack() {
		this.entityManager.getTransaction().rollback();
	}

	/**
	 * 
	 * @return Connection
	 */
	public Connection getConnection() {

		Session session = entityManager.unwrap(Session.class);
		SessionImpl sessionImpl = (SessionImpl) session;
		return sessionImpl.connection();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void save(T entidade, UsuarioVO user) throws Exception {

		try {
			this.beginTransaction();
			this.entityManager.persist(entidade);
			this.commit();
		} catch (Exception e) {
			rollBack();
			throw e;
		}

	}

	public void update(T entidade, UsuarioVO user) throws Exception {

		try {
			beginTransaction();
			entityManager.merge(entidade);
			commit();

		} catch (Exception e) {
			this.rollBack();
			throw e;
		}

	}

	public ArrayList<T> getAll() {

		return (ArrayList<T>) entityManager.createQuery(("FROM " + classe.getName())).getResultList();

	}

	public T getByID(long selfId, UsuarioVO user) {

		return (T) entityManager.find(classe, selfId);

	}

	public void delete(T entidade, UsuarioVO user) throws Exception {

		try {
			beginTransaction();
			entityManager.remove(entidade);
			commit();
		} catch (Exception e) {
			rollBack();
			throw e;
		}
	}

}

package iim.sigra.model.parametrizacao.tipopedido;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TipoPedidoDAO {

	
	 private static TipoPedidoDAO instance;
     protected EntityManager entityManager;
     
     public static TipoPedidoDAO getInstance(){
         if (instance == null){
                  instance = new TipoPedidoDAO();
         }
         
         return instance;
     }
     
     public TipoPedidoDAO() {
	         entityManager = getEntityManager();
	}
     
     public EntityManager getEntityManager() {
         EntityManagerFactory factory = Persistence.createEntityManagerFactory("sigrasoft");
         if (entityManager == null) {
                  entityManager = factory.createEntityManager();
         }

         return entityManager;
}
     
     
     public void persist(TipoPedidoVO tipoPedido) {
         try {
                  entityManager.getTransaction().begin();
                  entityManager.persist(tipoPedido);
                  entityManager.getTransaction().commit();
         } catch (Exception ex) {
                  ex.printStackTrace();
                  entityManager.getTransaction().rollback();
         }
}
}

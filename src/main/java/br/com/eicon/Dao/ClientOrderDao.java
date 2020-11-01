package br.com.eicon.Dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import br.com.eicon.model.ClientOrder;

@Component
public class ClientOrderDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public List<ClientOrder> searchClientOrder(String clientOrderSearch, boolean all) {
		String connector = " and ";
		if (all) connector = " or ";
		String query = "SELECT c.* FROM client_order c WHERE c.number_control = '?' # c.order_id = '?' # c.client_code = '?' #"
				+ " c.date_register = '?' # c.name = '?' # c.quantity = '?' # c.value = '?'  ";
		query.replaceAll("#", connector);
		Query q = em.createNativeQuery(query);
		q.setParameter(1, clientOrderSearch);
		List<ClientOrder> clientOrders =  q.getResultList();
		return clientOrders;
	}
	
	public List<ClientOrder> findOrdersByNumber(int numberControl) {
		Query q = em.createNativeQuery("SELECT c.* FROM client_order c WHERE c.number_control = ?");
		q.setParameter(1, numberControl);
		List<ClientOrder> clientOrders =  q.getResultList();
		return clientOrders;
	}
	
	

	public void persist(ClientOrder clientOrder) {
		Session session = em.unwrap(Session.class);
		session.saveOrUpdate(clientOrder);
	}

	public List<ClientOrder> findAll() {
		return em.createQuery("SELECT c FROM ClientOrder c").getResultList();
	}

}

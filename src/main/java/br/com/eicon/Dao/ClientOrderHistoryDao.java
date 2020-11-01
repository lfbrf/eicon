package br.com.eicon.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import br.com.eicon.model.ClientOrder;
import br.com.eicon.model.ClientOrderHistory;

@Component
public class ClientOrderHistoryDao {

	@PersistenceContext
	private EntityManager em;

	public void persist(ClientOrderHistory clientOrderHistory) {
		Session session = em.unwrap(Session.class);
		session.saveOrUpdate(clientOrderHistory);
	}

	public List<ClientOrder> findAll() {
		return em.createQuery("SELECT c FROM ClientOrderHistory c").getResultList();
	}

}


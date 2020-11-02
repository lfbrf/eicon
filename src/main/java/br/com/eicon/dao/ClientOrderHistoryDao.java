package br.com.eicon.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	@SuppressWarnings("unchecked")
	public List<ClientOrder> findAll() {
		return em.createQuery("SELECT c FROM ClientOrderHistory c").getResultList();
	}

}


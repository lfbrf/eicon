package br.com.eicon.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import br.com.eicon.model.ClientOrder;
import br.com.eicon.model.ClientOrderGroup;

@Component
public class ClientOrderGroupDao {
	
	@PersistenceContext
	private EntityManager em;

	public void persist(ClientOrderGroup clientOrderGroup) {
		Session session = em.unwrap(Session.class);
		session.saveOrUpdate(clientOrderGroup);
	}

	public List<ClientOrder> findAll() {
		return em.createQuery("SELECT c FROM ClientOrderGroup c").getResultList();
	}
}

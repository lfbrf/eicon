package br.com.eicon.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.stereotype.Component;

import br.com.eicon.model.ClientOrder;
import br.com.eicon.util.Util;

@Component
@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
public class ClientOrderDao {

	@PersistenceContext
	private EntityManager em;

	public List<ClientOrder> searchClientOrder(String clientOrderSearch, boolean numberControl, boolean dateRegister, boolean client 
			, boolean all) {
		String query = "SELECT * FROM client_order c WHERE 1 = 1 and ";
		int numberParam = 0;
		if (all) {
			query +=  " (c.number_control LIKE ? or c.order_id LIKE ? or c.client_code LIKE ? or  c.date_register LIKE ? "
					+ " or c.name LIKE ? or c.quantity LIKE ? or c.value LIKE ? or c.total_value LIKE ? )     ";
			numberParam = 8;
		}
		else {
			if (numberControl) {
				query += "( c.number_control LIKE ? )  or ";
				numberParam++;
			}
			if (dateRegister) {
				query += "( c.date_register LIKE ? )  or ";
				numberParam++;
			}
			if (client) {
				query += "( c.client_code LIKE ? )  or ";
				numberParam++;
			}
		}
		query = Util.formatToValidQuery(query); 
		Query q = em.createNativeQuery(query);
		if (numberParam > 0) {
			for (int i=1; i<= numberParam; i++) {
				q.setParameter(i,  "%"+clientOrderSearch+"%");
			}
		}

		List<ClientOrder> allClientOrders = new ArrayList<>();
		NativeQueryImpl nativeQuery = (NativeQueryImpl) q;
		nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List < Map < String, Object >> result = q.getResultList();
		for (Map map: result) {
			ClientOrder clientOrder = new ClientOrder(map);
			allClientOrders.add(clientOrder);
		}

		return  allClientOrders;
	}

	public List<ClientOrder> findOrdersByNumber(int numberControl) {
		Query q = em.createNativeQuery("SELECT c.* FROM client_order c WHERE c.number_control = ?");
		q.setParameter(1, numberControl);
		return q.getResultList();
	}

	public void persist(ClientOrder clientOrder) {
		Session session = em.unwrap(Session.class);
		session.saveOrUpdate(clientOrder);
	}


	public List<ClientOrder> findAll() {
		return em.createQuery("SELECT c FROM ClientOrder c").getResultList();
	}

}

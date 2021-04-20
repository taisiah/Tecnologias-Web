
package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.bank.model.Client;
import br.com.bank.util.JPAUtil;

public class ClientDaoImpl implements ClientDao {

	@Override
	public Client getClient(String name) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {

			Client client = entityManager.createNamedQuery("Client.getByName", Client.class).setParameter("name", name)
					.getSingleResult();

			return client;

		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}

		return null;
	}

	public Client getClientByEmail(String email) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {

			Client client = entityManager.createNamedQuery("Client.getByEmail", Client.class)
					.setParameter("email", email).getSingleResult();

			return client;

		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}

		return null;
	}

	public Client getClientByPhone(String phone) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {

			Client client = entityManager.createNamedQuery("Client.getByPhone", Client.class)
					.setParameter("phone", phone).getSingleResult();

			return client;

		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}

		return null;
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		List<Client> clients = entityManager.createNamedQuery("Client.getAll", Client.class).getResultList();
		return clients;
	}

	@Override
	public boolean save(Client client) {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		if (getClientByEmail(client.getEmail()) == null && getClientByPhone(client.getPhone()) == null) {
			try {

				entityManager.persist(client);
				entityManager.getTransaction().commit();
				entityManager.close();
				return true;

			}

			catch (Exception e) {
				e.getMessage();
				return false;
			}

		}
		else {
			return false;
		}
	}

	@Override
	public void deleteById(Long idClient) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {
			
			Client client = entityManager.find(Client.class, idClient);		
			//entityManager.createNamedQuery("Client.deleteById", Client.class).setParameter("id", idClient);
			entityManager.remove(client);
			entityManager.getTransaction().commit();
			entityManager.close();

		}

		catch (Exception e) {
			e.getMessage();
		}

	}

}

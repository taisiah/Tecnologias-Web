/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.ClientDaoImpl;
import br.com.bank.model.Client;


public class ClientServiceImpl implements ClientService {
	
	private ClientDaoImpl dao;
	
	public ClientServiceImpl() {
		this.dao = new ClientDaoImpl();
	}

	@Override
	public Client getClient(String name) {
		
		return this.dao.getClient(name);
	}

	@Override
	public List<Client> getAll() {
		return this.dao.getAll();
	}

	@Override
	public boolean save(Client client) {
		return this.dao.save(client);
		
	}

	@Override
	public void deleteById(Long idClient) {
		this.dao.deleteById(idClient);
		// TODO Auto-generated method stub
		
	}

	
}

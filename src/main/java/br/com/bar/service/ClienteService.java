package br.com.bar.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bar.dao.ClienteDAO;
import br.com.bar.domain.Cliente;
import br.com.bar.interfaces.ClienteInterface;
import br.com.bar.mappers.ClienteMapper;

public class ClienteService implements ClienteInterface {

	@Override
	public void save(ClienteDAO dao) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		try {
			em.persist(ClienteMapper.toEntity(dao));
			
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		
		em.close();
		fabrica.close();
		
	}

	@Override
	public List<ClienteDAO> findAll() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			clientes = em.createQuery("select * from Cliente",Cliente.class).getResultList();
			
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		
		em.close();
		fabrica.close();
		return ClienteMapper.toDAO(clientes);
	}

	@Override
	public ClienteDAO find(String celular) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		Cliente cliente = null;
		
		try {
			cliente = em.createQuery("select e from Cliente e where celular = '"+celular+"'",Cliente.class).getSingleResult();
			
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		em.close();
		fabrica.close();
		return ClienteMapper.toDAO(cliente);
	}

	@Override
	public void update(ClienteDAO dao) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		
		
		try {
			em.merge(ClienteMapper.toEntity(dao));
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		
		em.close();
		fabrica.close();
		
	}

	@Override
	public void delete(int id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, id);
		
		try {
			em.remove(cliente);
			em.getTransaction().begin();
			em.getTransaction().commit();
			
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
		fabrica.close();
		
	}

}

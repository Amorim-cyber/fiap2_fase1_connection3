package br.com.bar.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bar.dao.ComandaDAO;
import br.com.bar.domain.Comanda;
import br.com.bar.interfaces.ComandaInterface;
import br.com.bar.mappers.ComandaMapper;

public class ComandaService implements ComandaInterface{

	@Override
	public void save(ComandaDAO dao) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		Comanda comanda = ComandaMapper.toEntity(dao);
		
		try {
			em.getTransaction().begin();
			System.out.println(comanda);
			em.persist(comanda);
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
	public List<ComandaDAO> findAll() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		List<Comanda> comandas = new ArrayList<Comanda>();
		
		try {
			comandas = em.createQuery("select e from Comanda e",Comanda.class).getResultList();
			System.out.println(comandas);
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		
		em.close();
		fabrica.close();
		return ComandaMapper.toDAO(comandas);
	}

	@Override
	public ComandaDAO find(int id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		Comanda comanda = null;
		
		try {
			comanda = em.find(Comanda.class, id);
			
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
		fabrica.close();
		return ComandaMapper.toDAO(comanda);
	}

	@Override
	public void update(ComandaDAO dao) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		
		
		try {
			em.merge(ComandaMapper.toEntity(dao));
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
		
		Comanda comanda = em.find(Comanda.class, id);
		
		try {
			em.remove(comanda);
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

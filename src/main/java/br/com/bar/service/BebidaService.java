package br.com.bar.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bar.dao.BebidaDAO;
import br.com.bar.domain.Bebida;
import br.com.bar.interfaces.BebidaInterface;
import br.com.bar.mappers.BebidaMapper;

public class BebidaService implements BebidaInterface {

	@Override
	public void save(BebidaDAO dao) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		try {
			em.persist(BebidaMapper.toEntity(dao));
			
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
	public List<BebidaDAO> findAll() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		List<Bebida> bebidas = new ArrayList<Bebida>();
		
		try {
			bebidas = em.createQuery("select e from Bebida e where nome != 'Não consumiu'",Bebida.class).getResultList();
			
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		
		em.close();
		fabrica.close();
		return BebidaMapper.toDAO(bebidas);
	}

	@Override
	public BebidaDAO find(int id) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		Bebida bebida = null;
		
		try {
			bebida = em.find(Bebida.class, id);
			
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
		fabrica.close();
		return BebidaMapper.toDAO(bebida);
	}
	
	@Override
	public BebidaDAO find(String nome) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		Bebida bebida = null;
		
		try {
			bebida = em.createQuery("select e from Bebida e where nome = '"+nome+"'",Bebida.class).getSingleResult();
			
		}catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
		fabrica.close();
		return BebidaMapper.toDAO(bebida);
	}

	@Override
	public void update(BebidaDAO dao) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("barproject");
		EntityManager em = fabrica.createEntityManager();
		
		
		
		try {
			em.merge(BebidaMapper.toEntity(dao));
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
		
		Bebida bebida = em.find(Bebida.class, id);
		
		try {
			em.remove(bebida);
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

package br.com.algaworks.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Categoria;

public class RemoverCategoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Categoria categoria = manager.find(Categoria.class, 9L);
		manager.remove(categoria);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}

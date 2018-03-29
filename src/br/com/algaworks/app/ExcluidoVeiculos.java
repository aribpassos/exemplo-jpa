package br.com.algaworks.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Veiculo;

public class ExcluidoVeiculos {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Veiculo veiculo = manager.find(Veiculo.class, 1L);

		manager.remove(veiculo);

		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}

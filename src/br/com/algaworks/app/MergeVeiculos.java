package br.com.algaworks.app;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Veiculo;

public class MergeVeiculos {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		tx.commit();
		
		manager.close();
		veiculo.setValor(new BigDecimal(5_000));
		manager = JpaUtil.getEntityManager();
		tx = manager.getTransaction();
		tx.begin();
		// reanexamos o objeto ao novo EntityManager
		veiculo = manager.merge(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}

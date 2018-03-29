package br.com.algaworks.app;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Veiculo;

public class ConsultaVeiculos {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		List<Veiculo> veiculos = manager.createQuery("from Veiculo", Veiculo.class).getResultList();
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " - " + veiculo.getProprietario().getNome());
		}

		manager.close();
		JpaUtil.close();
	}

}

package br.com.algaworks.app;

import javax.persistence.EntityManager;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Veiculo;

public class ConsultaVeiculoPorIndent {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		System.out.println(veiculo.getModelo() + " - "
		+ veiculo.getProprietario().getNome());
		manager.close();
		JpaUtil.close();

	}

}

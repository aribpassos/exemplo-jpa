package br.com.algaworks.app;

import javax.persistence.EntityManager;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Acessorio;
import br.com.algaworks.veiculos.dominio.Veiculo;

public class ConsultandoAcessoriosVeiculo {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Veiculo veiculo = manager.find(Veiculo.class, 13L);
		System.out.println("Veículo: " + veiculo.getModelo());
		for (Acessorio acessorio : veiculo.getAcessorios()) {
		System.out.println("Acessório: " + acessorio.getDescricao());
		}
		manager.close();
		JpaUtil.close();

	}

}

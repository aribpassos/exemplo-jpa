package br.com.algaworks.app;

import javax.persistence.EntityManager;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Veiculo;

public class ContextPersistenciaVeiculo2 {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Veiculo veiculo1 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela primeira vez...");
		System.out.println("Gerenciado? " + manager.contains(veiculo1));
		manager.detach(veiculo1);
		System.out.println("E agora? " + manager.contains(veiculo1));
		Veiculo veiculo2 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela segunda vez...");
		System.out.println("Mesmo veículo? " + (veiculo1 == veiculo2));
		manager.close();
		JpaUtil.close();

	}

}

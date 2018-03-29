package br.com.algaworks.app;

import javax.persistence.EntityManager;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Proprietario;
import br.com.algaworks.veiculos.dominio.Veiculo;

public class ConsultaOneTomany {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Proprietario proprietario = manager.find(Proprietario.class, 1L);
		System.out.println("Propriet�rio: " + proprietario.getNome());
		
//		for (Veiculo veiculo : proprietario.getVeiculos()) {
//			System.out.println("Ve�culo: " + veiculo.getModelo());			
//			}
//			manager.close();
//			JpaUtil.close();

	}

}

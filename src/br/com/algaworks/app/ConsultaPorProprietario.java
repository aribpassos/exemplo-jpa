package br.com.algaworks.app;

import javax.persistence.EntityManager;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Proprietario;

public class ConsultaPorProprietario {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Proprietario proprietario = manager.find(Proprietario.class, 1L);
		
//		System.out.println(proprietario.getVeiculo().getModelo() + " - "
//				+ proprietario.getNome());
//		manager.close();
		JpaUtil.close();
	}

}

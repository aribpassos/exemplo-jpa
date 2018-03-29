package br.com.algaworks.app;

import javax.persistence.EntityManager;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Proprietario;
import br.com.algaworks.veiculos.dominio.Telefone;

public class ListarTelefones {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Proprietario proprietario = manager.find(Proprietario.class, 1L);
		System.out.println("Proprietário: " + proprietario.getNome());
		for (Telefone telefone : proprietario.getTelefones()) {
		System.out.println("Telefone: (" + telefone.getPrefixo() + ") "
		+ telefone.getNumero()
		+ (telefone.getRamal() != null ? " x" + telefone.getRamal() : ""));
		}
		manager.close();
		JpaUtil.close();
	}

}

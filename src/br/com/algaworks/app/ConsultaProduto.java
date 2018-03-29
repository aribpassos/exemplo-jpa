package br.com.algaworks.app;

import javax.persistence.EntityManager;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Categoria;
import br.com.algaworks.veiculos.dominio.Produto;

public class ConsultaProduto {

	public static void main(String[] args) {
		// EntityManager manager = JpaUtil.getEntityManager();
		// EntityTransaction tx = manager.getTransaction();
		// Produto produto = manager.find(Produto.class, 3L);
		// System.out.println("Nome: " + produto.getNome());
		// manager.close();
		// JpaUtil.close();

		// EntityManager manager = JpaUtil.getEntityManager();
		// EntityTransaction tx = manager.getTransaction();
		// Produto produto = manager.find(Produto.class, 3L);
		// System.out.println("Nome: " + produto.getNome());
		// System.out.println("Categoria: " + produto.getCategoria().getNome());
		// manager.close();
		// JpaUtil.close();

		// EntityManager manager = JpaUtil.getEntityManager();
		// EntityTransaction tx = manager.getTransaction();
		// Produto produto = manager.find(Produto.class, 3L);
		// System.out.println("Nome: " + produto.getNome());
		// // quando fechamos o EntityManager,
		// // todas as instâncias se tornam detached
		// manager.close();
		// System.out.println("Categoria: " + produto.getCategoria().getNome());
		// JpaUtil.close();

		EntityManager manager = JpaUtil.getEntityManager();
		Categoria categoria = manager.find(Categoria.class, 1L);
		System.out.println("Categoria: " + categoria.getNome());
		for (Produto produto : categoria.getProdutos()) {
			System.out.println("Produto: " + produto.getNome());
		}
		manager.close();
		JpaUtil.close();

	}

}

package br.com.algaworks.app;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Acessorio;
import br.com.algaworks.veiculos.dominio.TipoCombustivel;
import br.com.algaworks.veiculos.dominio.Veiculo;

public class CriarManyToMany {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		// instancia acessórios
		Acessorio alarme = new Acessorio();
		alarme.setDescricao("Alarme")
		;
		Acessorio arCondicionado = new Acessorio();
		arCondicionado.setDescricao("Ar condicionado");
		
		Acessorio bancosDeCouro = new Acessorio();
		bancosDeCouro.setDescricao("Bancos de couro");
		
		Acessorio direcaoHidraulica = new Acessorio();
		direcaoHidraulica.setDescricao("Direção hidráulica");
		
		// persiste acessórios
		manager.persist(alarme);
		manager.persist(arCondicionado);
		manager.persist(bancosDeCouro);
		manager.persist(direcaoHidraulica);
		
		// instancia veículos
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setFabricante("VW");
		veiculo1.setModelo("Gol");
		veiculo1.setAnoFabricacao(2010);
		veiculo1.setAnoModelo(2010);
		veiculo1.setValor(new BigDecimal(17_200));
		veiculo1.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo1.setDataCadastro(new Date());
		veiculo1.getAcessorios().add(alarme);
		veiculo1.getAcessorios().add(arCondicionado);
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setFabricante("Hyundai");
		veiculo2.setModelo("i30");
		veiculo2.setAnoFabricacao(2012);
		veiculo2.setAnoModelo(2012);
		veiculo2.setValor(new BigDecimal(53_500));
		veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo2.setDataCadastro(new Date());
		veiculo2.getAcessorios().add(alarme);		
		veiculo2.getAcessorios().add(arCondicionado);
		veiculo2.getAcessorios().add(bancosDeCouro);
		veiculo2.getAcessorios().add(direcaoHidraulica);
		veiculo2.getAcessorios().add(direcaoHidraulica);
		
		// persiste veículos
		manager.persist(veiculo1);
		manager.persist(veiculo2);
		
		tx.commit();
		manager.close();
		JpaUtil.close();

	}

}

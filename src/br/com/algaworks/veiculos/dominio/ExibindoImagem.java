package br.com.algaworks.veiculos.dominio;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.algaworks.util.JpaUtil;

public class ExibindoImagem {

	public static void main(String[] args) throws IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		if (veiculo.getFoto() != null) {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(veiculo.getFoto()));
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
		} else {
			System.out.println("Veículo não possui foto.");
		}
		manager.close();
		JpaUtil.close();
	}
}
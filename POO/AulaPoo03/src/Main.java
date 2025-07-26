import javax.swing.*;

public class Main {
	public static void main(String[] args) {

		Fisica pf1 = new Fisica(); // instanciando
		Juridica pj1 = new Juridica(); // instanciando com polimorfismo

		pj1.setNome(JOptionPane.showInputDialog("Digite o nome da pessoa PJ"));
		JOptionPane.showMessageDialog(null, "Razão Social: " + pj1.getNome());

	}
}
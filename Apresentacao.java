//Aluno: Martin Lange de Assis
//Curso: Ciência da Computação
//Universidade: FURB
package conta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Apresentacao {

	protected static final String Int = null;
	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfNumero;
	private JTextField tfAgencia;
	private JTextField tfSaldo;
	private JTextField tfData;
	private ArrayList<Conta> contas = new ArrayList<>();
	private JTextField tfSaque;
	private JTextField tfDeposito;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		tfNome = new JTextField();
		tfNome.setBounds(57, 8, 335, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Número:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		tfNumero = new JTextField();
		tfNumero.setBounds(57, 36, 86, 20);
		frame.getContentPane().add(tfNumero);
		tfNumero.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Agência:");
		lblNewLabel_2.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		tfAgencia = new JTextField();
		tfAgencia.setBounds(57, 67, 86, 20);
		frame.getContentPane().add(tfAgencia);
		tfAgencia.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Saldo:");
		lblNewLabel_3.setBounds(10, 98, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);

		tfSaldo = new JTextField();
		tfSaldo.setBounds(57, 95, 86, 20);
		frame.getContentPane().add(tfSaldo);
		tfSaldo.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Data de Abertura:");
		lblNewLabel_4.setBounds(10, 126, 94, 14);
		frame.getContentPane().add(lblNewLabel_4);

		tfData = new JTextField();
		tfData.setBounds(102, 123, 86, 20);
		frame.getContentPane().add(tfData);
		tfData.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Conta c1;
					c1 = new Conta();
					c1.setNome(tfNome.getText());
					c1.setNumero(Integer.parseInt(tfNumero.getText()));
					c1.setAgencia(tfAgencia.getText());
					c1.setSaldo(Double.parseDouble(tfSaldo.getText()));
					c1.setDataDeAbertura(LocalDate.parse(tfData.getText(), formatter));
					String str = "Nome: " + c1.getNome() + "\n" + "Número: " + c1.getNumero() + "\n" + c1.getAgencia()
							+ "\n" + c1.getSaldo() + "\n" + c1.getDataDeAbertura();
					JOptionPane.showMessageDialog(frame, str);

					contas.add(c1);
				} catch (DateTimeParseException data) {
					JOptionPane.showMessageDialog(frame, "Data inválida. Por favor, tente novamente.");
				} catch (IllegalArgumentException mensagem) {
					JOptionPane.showMessageDialog(frame, mensagem.getMessage());
				}
			}
		});
		btnNewButton.setBounds(54, 151, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorSaque = Double.parseDouble(tfSaque.getText());
				for (int i = 0; i < contas.size(); i++) {
					Conta c = contas.get(i);
					if (c.getSaldo() >= valorSaque) {
						c.setSaldo(c.getSaldo() - valorSaque);
						String str = "Saque efetuado com sucesso no valor de: " + valorSaque + "\n";
						str += "Nome: " + c.getNome() + "\n" + "Número: " + c.getNumero() + "\n" + c.getAgencia() + "\n"
								+ c.getSaldo() + "\n" + c.getDataDeAbertura();
						JOptionPane.showMessageDialog(frame, str);
					} else {
						String str = "Saldo insuficiente";
						str += "Nome: " + c.getNome() + "\n" + "Número: " + c.getNumero() + "\n" + c.getAgencia() + "\n"
								+ c.getSaldo() + "\n" + c.getDataDeAbertura();
						JOptionPane.showMessageDialog(frame, str);
					}
				}
			}
		});

		btnSacar.setBounds(153, 186, 89, 23);
		frame.getContentPane().add(btnSacar);

		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorDeposito = Double.parseDouble(tfDeposito.getText());
				for (int i = 0; i < contas.size(); i++) {
					Conta c = contas.get(i);
					c.setSaldo(c.getSaldo() + valorDeposito);
					String str = "Depósito efetuado com sucesso no valor de: " + valorDeposito + "\n";
					str += "Nome: " + c.getNome() + "\n" + "Número: " + c.getNumero() + "\n" + c.getAgencia() + "\n"
							+ c.getSaldo() + "\n" + c.getDataDeAbertura();
					JOptionPane.showMessageDialog(frame, str);
				}
			}
		});
		btnDepositar.setBounds(153, 220, 89, 23);
		frame.getContentPane().add(btnDepositar);

		JLabel lblNewLabel_5 = new JLabel("Saque:");
		lblNewLabel_5.setBounds(10, 190, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);

		tfSaque = new JTextField();
		tfSaque.setBounds(57, 187, 86, 20);
		frame.getContentPane().add(tfSaque);
		tfSaque.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Depósito:");
		lblNewLabel_6.setBounds(10, 224, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);

		tfDeposito = new JTextField();
		tfDeposito.setBounds(57, 221, 86, 20);
		frame.getContentPane().add(tfDeposito);
		tfDeposito.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Rendimento:");
		lblNewLabel_7.setBounds(252, 190, 73, 14);
		frame.getContentPane().add(lblNewLabel_7);

		JButton btnRendimento = new JButton("Calcular");
		btnRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double rendimento;
				for (int i = 0; i < contas.size(); i++) {
					Conta c = contas.get(i);
					rendimento = c.getSaldo() * 0.1;
					String str = "A conta possui um rendimento de: " + rendimento + "\n";
					JOptionPane.showMessageDialog(frame, str);
				}
			}
		});
		btnRendimento.setBounds(335, 186, 89, 23);
		frame.getContentPane().add(btnRendimento);

	}
}

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.ExameService;
import entities.Exames;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastroExame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField valorField;
	private JTextArea orientacoesField;
	private ExameService exameservice;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroExame frame = new CadastroExame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void cadastrarExame() {
		try {
			Exames exame = new Exames();
			exame.setCodigo(this.codigoField.getText());
			exame.setNome(this.nomeField.getText());
			exame.setOrientacoes(this.orientacoesField.getText());
			exame.setValor(Integer.parseInt(this.valorField.getText()));
			this.exameservice.cadastrar(exame);
		}catch(SQLException | IOException | NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo exame.", "Exame", JOptionPane.ERROR_MESSAGE);
		}
		this.setVisible(false);
		
	}

	/**
	 * Create the frame.
	 */
	public CadastroExame() {
		this.exameservice=new ExameService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Orientações");
		lblNewLabel_3.setBounds(10, 86, 58, 14);
		contentPane.add(lblNewLabel_3);
		
		codigoField = new JTextField();
		codigoField.setBounds(76, 8, 86, 20);
		contentPane.add(codigoField);
		codigoField.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setBounds(76, 33, 86, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		valorField = new JTextField();
		valorField.setBounds(76, 58, 86, 20);
		contentPane.add(valorField);
		valorField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarExame();
			}
		});
		btnNewButton.setBounds(10, 205, 89, 23);
		contentPane.add(btnNewButton);
		
		orientacoesField = new JTextArea();
		orientacoesField.setBounds(10, 111, 414, 83);
		contentPane.add(orientacoesField);
	}
}

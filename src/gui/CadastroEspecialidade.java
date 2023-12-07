package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Especialidades;
import service.EspecialidadeService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastroEspecialidade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codigoField;
	private JComboBox<String> nomeField;
	private EspecialidadeService especialidadeservice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEspecialidade frame = new CadastroEspecialidade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void cadastrarEspecialidade() {
		try {
			Especialidades especialidade = new Especialidades();
			especialidade.setCodigo(this.codigoField.getText());
			especialidade.setEspecialidade((String)this.nomeField.getSelectedItem());
			this.especialidadeservice.cadastrar(especialidade);
			
		}catch (SQLException | IOException | NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um nova especialidade.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		this.setVisible(false);
	}
	
	
	public CadastroEspecialidade() {
		this.especialidadeservice=new EspecialidadeService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo ");
		lblNewLabel.setBounds(10, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		codigoField = new JTextField();
		codigoField.setBounds(50, 37, 124, 20);
		contentPane.add(codigoField);
		codigoField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarEspecialidade();
			}
		});
		btnNewButton.setBounds(47, 144, 89, 23);
		contentPane.add(btnNewButton);
		
		this.nomeField = new JComboBox<String>();
		nomeField.setModel(new DefaultComboBoxModel<String>(new String[] {"Cardiologia", "Dermatologia", "Ortopedia", "Ginecologia e Obstetrícia", "Neurologia", "Oftalmologia", "Pediatria", "Psiquiatria", "Otorrinolaringologia", "Endocrinologia"}));
		nomeField.setBounds(50, 69, 124, 22);
		contentPane.add(nomeField);
	}
}

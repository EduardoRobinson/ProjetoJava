package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import entities.Pacientes;
import entities.Endereco;
import service.PacienteService;

public class CadastroPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField telefoneField;
	private JTextField cepField;
	private JTextField cidadeField;
	private JTextField bairroField;
	private JTextField ruaField;
	private JTextField dataField;
	private JComboBox<String> ufField;
	private JComboBox<String> sexoField;
	private JComboBox<String> pagamentoField;
	private PacienteService pacienteService;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPaciente frame = new CadastroPaciente();
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
	
	public void cadastrarPaciente() {
		try {
			Pacientes paciente = new Pacientes();
			paciente.setNome(this.nomeField.getText());
			paciente.setFoto("teste.png");
			paciente.setDatanasc(this.dataField.getText());
			paciente.setSexo((String)this.sexoField.getSelectedItem());
			paciente.setEndereco(new Endereco(this.ruaField.getText(),this.bairroField.getText(),this.cidadeField.getText(),(String)this.ufField.getSelectedItem(),this.cepField.getText()));
			paciente.setTelefone(this.telefoneField.getText());
			paciente.setFormapgt((String)this.pagamentoField.getSelectedItem());
			this.pacienteService.cadastrar(paciente);
			
		}catch(SQLException | IOException | NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo paciente.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		this.setVisible(false);
	}
	
	
	public CadastroPaciente() {
		this.pacienteService= new PacienteService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Foto");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(10, 61, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setBounds(10, 86, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Rua");
		lblNewLabel_4.setBounds(10, 111, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Bairro");
		lblNewLabel_5.setBounds(10, 136, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cidade");
		lblNewLabel_6.setBounds(10, 161, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("UF");
		lblNewLabel_7.setBounds(10, 189, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("CEP");
		lblNewLabel_8.setBounds(10, 214, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Telefone");
		lblNewLabel_9.setBounds(10, 239, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Forma de pagamento");
		lblNewLabel_10.setBounds(10, 264, 102, 14);
		contentPane.add(lblNewLabel_10);
		
		nomeField = new JTextField();
		nomeField.setBounds(46, 8, 86, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		telefoneField = new JTextField();
		telefoneField.setBounds(66, 236, 86, 20);
		contentPane.add(telefoneField);
		telefoneField.setColumns(10);
		
		cepField = new JTextField();
		cepField.setBounds(46, 211, 86, 20);
		contentPane.add(cepField);
		cepField.setColumns(10);
		
		cidadeField = new JTextField();
		cidadeField.setBounds(66, 158, 86, 20);
		contentPane.add(cidadeField);
		cidadeField.setColumns(10);
		
		bairroField = new JTextField();
		bairroField.setBounds(66, 133, 86, 20);
		contentPane.add(bairroField);
		bairroField.setColumns(10);
		
		ruaField = new JTextField();
		ruaField.setBounds(66, 108, 86, 20);
		contentPane.add(ruaField);
		ruaField.setColumns(10);
		
		dataField = new JTextField();
		dataField.setBounds(115, 58, 86, 20);
		contentPane.add(dataField);
		dataField.setColumns(10);
		
		this.ufField = new JComboBox<String>();
		ufField.setModel(new DefaultComboBoxModel<String>(new String[] {"Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		ufField.setBounds(46, 186, 86, 22);
		contentPane.add(ufField);
		
		this.sexoField = new JComboBox<String>();
		sexoField.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Feminino"}));
		sexoField.setBounds(46, 82, 86, 22);
		contentPane.add(sexoField);
		
		this.pagamentoField = new JComboBox<String>();
		pagamentoField.setModel(new DefaultComboBoxModel<String>(new String[] {"Boleto ", "Cartão de credito", "Cartão de debito", "PIX"}));
		pagamentoField.setBounds(122, 260, 122, 22);
		contentPane.add(pagamentoField);
		
		JButton fotoField = new JButton("Escolher");
		fotoField.setBounds(46, 32, 89, 23);
		contentPane.add(fotoField);
		
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 cadastrarPaciente();
			}
		});
		cadastrarButton.setBounds(10, 309, 89, 23);
		contentPane.add(cadastrarButton);
	}
}

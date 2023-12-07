package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Endereco;
import entities.Especialidades;
import entities.Medicos;
import service.EspecialidadeService;
import service.MedicoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastroMedico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField crmField;
	private JTextField nomeField;
	private JTextField ruaField;
	private JTextField bairroField;
	private JTextField cidadeField;
	private JTextField cepField;
	private JTextField telefoneField;
	private JComboBox<String> ufField;
	private JComboBox<String> especialidadeField;
	private EspecialidadeService especialidadeservice;
	private MedicoService medicoService;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMedico frame = new CadastroMedico();
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
	
	public void cadastrarMedico() {
		try {
			Medicos medico = new Medicos();
			medico.setCRM(this.crmField.getText());
			medico.setNome(this.nomeField.getText());
			medico.setEndereco(new Endereco(this.ruaField.getText(),this.bairroField.getText(),this.cidadeField.getText(),(String)this.ufField.getSelectedItem(),this.cepField.getText()));
			medico.setEspecialidade((String)this.especialidadeField.getSelectedItem());
			medico.setTelefone(this.telefoneField.getText());
			this.medicoService.cadastrar(medico);
		}catch (SQLException | IOException | NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo paciente.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		this.setVisible(false);
		
	}
	
	public void buscarEspecialidades() {
		try {
			List<Especialidades> lista=this.especialidadeservice.buscarTodas();

			for(Especialidades especialidade:lista) {
				this.especialidadeField.addItem(especialidade.getEspecialidade());
			}
			
		}catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar os dados das especialidades.", "Busca de especialidades", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public CadastroMedico() {
		this.medicoService = new MedicoService();
		this.especialidadeservice= new EspecialidadeService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CRM");
		lblNewLabel.setBounds(10, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 40, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rua");
		lblNewLabel_2.setBounds(10, 65, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Bairro");
		lblNewLabel_3.setBounds(10, 90, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cidade");
		lblNewLabel_4.setBounds(10, 115, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("UF");
		lblNewLabel_5.setBounds(10, 140, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CEP");
		lblNewLabel_6.setBounds(10, 168, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		crmField = new JTextField();
		crmField.setBounds(54, 12, 86, 20);
		contentPane.add(crmField);
		crmField.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setBounds(54, 37, 143, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		ruaField = new JTextField();
		ruaField.setBounds(54, 62, 143, 20);
		contentPane.add(ruaField);
		ruaField.setColumns(10);
		
		bairroField = new JTextField();
		bairroField.setBounds(54, 87, 143, 20);
		contentPane.add(bairroField);
		bairroField.setColumns(10);
		
		cidadeField = new JTextField();
		cidadeField.setBounds(54, 112, 143, 20);
		contentPane.add(cidadeField);
		cidadeField.setColumns(10);
		
		this.ufField = new JComboBox<String>();
		ufField.setModel(new DefaultComboBoxModel<String>(new String[] {"Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		ufField.setBounds(54, 136, 86, 22);
		contentPane.add(ufField);
		
		cepField = new JTextField();
		cepField.setBounds(54, 165, 86, 20);
		contentPane.add(cepField);
		cepField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarMedico();
			}
		});
		btnNewButton.setBounds(44, 273, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Telefone");
		lblNewLabel_7.setBounds(10, 193, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		telefoneField = new JTextField();
		telefoneField.setBounds(54, 190, 143, 20);
		contentPane.add(telefoneField);
		telefoneField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Especialidade");
		lblNewLabel_8.setBounds(10, 224, 64, 14);
		contentPane.add(lblNewLabel_8);
		
		this.especialidadeField = new JComboBox<String>();
		this.especialidadeservice= new EspecialidadeService();
		this.buscarEspecialidades();
		especialidadeField.setBounds(85, 221, 198, 22);
		contentPane.add(especialidadeField);
	}
}

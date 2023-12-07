package gui;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Medicos;
import entities.Pacientes;
import entities.Exames;
import entities.PedidoExame;

import service.MedicoService;
import service.ExameService;
import service.PacienteService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControleExames extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dataField;
	private JTextField valorField;
	private JComboBox <String> nomeField;
	private JComboBox <String>codigoField;
	private JComboBox <String>crmField;
	private MedicoService medicoservice;
	private ExameService exameservice;
	private PacienteService pacienteservice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleExames frame = new ControleExames();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void cadastrarExame() {
		try {
			PedidoExame pedidoexame= new PedidoExame();
			pedidoexame.setCodigoexame((String) this.codigoField.getSelectedItem());
			pedidoexame.setCrmMedico((String) this.crmField.getSelectedItem());
			pedidoexame.setNomepaciente((String) this.nomeField.getSelectedItem());
			pedidoexame.setDataRealizacao(this.dataField.getText());
			pedidoexame.setValorPago(this.valorField.getText());
			this.exameservice.cadastrarPedidoExame(pedidoexame);
		}catch(SQLException | IOException | NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo paciente.", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		this.setVisible(false);
		
	}
	
	
	
	
	public void buscarMedicos() {
		try {
			List<Medicos> lista=this.medicoservice.buscarTodos();
			for(Medicos medico:lista) {
				this.crmField.addItem(medico.getCRM());
			}
			
			
		}catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar os medicos.", "Busca por medicos", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
 public void buscarPaciente() {
		try {
			List<Pacientes> lista = this.pacienteservice.buscarTodos();
			for(Pacientes paciente:lista) {
				this.nomeField.addItem(paciente.getNome());
			}
			
		}catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar os pacientes.", "Busca por pacientes", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
 
 
 public void buscarExame() {
	 try {
		 List<Exames> lista=this.exameservice.buscarTodos();
		 for(Exames exame:lista) {
			 this.codigoField.addItem(exame.getCodigo());
		 }
		 
	 }catch (SQLException | IOException e) {
		 System.out.println(e.getMessage());
		 JOptionPane.showMessageDialog(null, "Erro ao buscar os exames.", "Busca por exames", JOptionPane.ERROR_MESSAGE);
	 }
 }
	
	
	
	

	/**
	 * Create the frame.
	 */
	public ControleExames() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo do exame");
		lblNewLabel.setBounds(52, 42, 83, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do paciente");
		lblNewLabel_1.setBounds(52, 67, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CRM médico");
		lblNewLabel_2.setBounds(52, 92, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data da realização");
		lblNewLabel_3.setBounds(52, 164, 103, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Valor Pago");
		lblNewLabel_4.setBounds(52, 199, 83, 14);
		contentPane.add(lblNewLabel_4);
		
		this.codigoField = new JComboBox<String>();
		this.exameservice=new ExameService();
		this.buscarExame();
		codigoField.setBounds(173, 38, 68, 22);
		contentPane.add(codigoField);
		
		this.nomeField = new JComboBox<String>();
		this.pacienteservice= new PacienteService();
		this.buscarPaciente();
		nomeField.setBounds(173, 63, 68, 22);
		contentPane.add(nomeField);
		
		this.crmField = new JComboBox<String>();
		this.medicoservice= new MedicoService();
		this.buscarMedicos();
		crmField.setBounds(173, 92, 68, 22);
		contentPane.add(crmField);
		
		dataField = new JTextField();
		dataField.setBounds(155, 161, 86, 20);
		contentPane.add(dataField);
		dataField.setColumns(10);
		
		valorField = new JTextField();
		valorField.setBounds(155, 196, 86, 20);
		contentPane.add(valorField);
		valorField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarExame();
			}
		});
		btnNewButton.setBounds(52, 268, 89, 23);
		contentPane.add(btnNewButton);
	}
}

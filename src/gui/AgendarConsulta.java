package gui;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import service.MedicoService;
import service.PacienteService;
import service.ConsultaService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import entities.Medicos;
import entities.Pacientes;
import entities.Consulta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgendarConsulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dataField;
	private JTextField horaField;
	private MedicoService medicoservice;
	private PacienteService pacienteservice;
	private ConsultaService consultaservice;
	private JComboBox<String> medicoField; 
	private JComboBox<String> pacienteField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendarConsulta frame = new AgendarConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void agendarConsulta() {
		try {
			Consulta consulta = new Consulta();
			consulta.setNomemedico((String)this.medicoField.getSelectedItem());
			consulta.setNomepaciente((String)this.pacienteField.getSelectedItem());
			consulta.setData(this.dataField.getText());
			consulta.setHora(this.horaField.getText());
			this.consultaservice.agendar(consulta);
			
		}catch (SQLException | IOException | NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Erro ao agendar consulta.", "Consulta", JOptionPane.ERROR_MESSAGE);	
		}
		this.setVisible(false);
	}
	
	public void buscarMedicos() {
		try {
			List<Medicos> lista=this.medicoservice.buscarTodos();
			for(Medicos medico:lista) {
				this.medicoField.addItem(medico.getNome());
			}
			
			
		}catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar os medicos.", "Busca por medicos", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
 public void buscarPaciente() {
		try {
			List<Pacientes> lista = this.pacienteservice.buscarTodos();
			for(Pacientes paciente:lista) {
				this.pacienteField.addItem(paciente.getNome());
			}
			
		}catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao buscar os pacientes.", "Busca por pacientes", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	

	/**
	 * Create the frame.
	 */
	public AgendarConsulta() {
		this.consultaservice= new ConsultaService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do paciente");
		lblNewLabel.setBounds(10, 11, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do medico");
		lblNewLabel_1.setBounds(10, 36, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hora");
		lblNewLabel_3.setBounds(10, 86, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Solicitar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendarConsulta();
			}
		});
		btnNewButton.setBounds(7, 134, 89, 23);
		contentPane.add(btnNewButton);
		
		this.pacienteField = new JComboBox<String>();
		this.pacienteservice=new PacienteService();
		this.buscarPaciente();
		pacienteField.setBounds(106, 7, 86, 22);
		contentPane.add(pacienteField);
		
		this.medicoField = new JComboBox<String>();
		this.medicoservice = new MedicoService();
		this.buscarMedicos();
		medicoField.setBounds(106, 32, 86, 22);
		contentPane.add(medicoField);
		
		dataField = new JTextField();
		dataField.setBounds(106, 58, 86, 20);
		contentPane.add(dataField);
		dataField.setColumns(10);
		
		horaField = new JTextField();
		horaField.setBounds(106, 83, 86, 20);
		contentPane.add(horaField);
		horaField.setColumns(10);
	}

}

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Consulta;
import entities.PedidoExame;
import service.PacienteService;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class RelatorioPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pacienteField;
	private JTable tableConsultas;
	private JTable tableExames;
	private PacienteService pacienteservice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioPaciente frame = new RelatorioPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void buscarDadosPaciente() {
		try {
			List<Consulta> lista1=this.pacienteservice.montarRelatorioConsulta(this.pacienteField.getText());
			DefaultTableModel consultas = (DefaultTableModel) this.tableConsultas.getModel();
			for(Consulta consulta:lista1) {
				Object[]dados= {consulta.getNomepaciente(),consulta.getNomemedico(),consulta.getData(),consulta.getHora()};
				consultas.addRow(dados);
			}
			List<PedidoExame> lista2=this.pacienteservice.montarRelatorioExame(this.pacienteField.getText());
			DefaultTableModel exames = (DefaultTableModel) this.tableExames.getModel();
			for(PedidoExame exame:lista2) {
				Object[]dados= {exame.getCodigoexame(),exame.getNomepaciente(),exame.getCrmMedico(),exame.getDataRealizacao(),exame.getValorPago()};
				exames.addRow(dados);
			}
			
			
		}catch(SQLException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar consultas do paciente", "Paciente", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void fecharJanela() {
		this.setVisible(false);
	}
	

	/**
	 * Create the frame.
	 */
	public RelatorioPaciente() {
		this.pacienteservice=new PacienteService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente");
		lblNewLabel.setBounds(59, 33, 60, 14);
		contentPane.add(lblNewLabel);
		
		pacienteField = new JTextField();
		pacienteField.setBounds(129, 30, 86, 20);
		contentPane.add(pacienteField);
		pacienteField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarDadosPaciente();
			}
		});
		btnNewButton.setBounds(243, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 116, 465, 246);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 465, 246);
		panel.add(scrollPane);
		
		tableConsultas = new JTable();
		scrollPane.setViewportView(tableConsultas);
		tableConsultas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Paciente", "Medico", "Data", "Hora"
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("Consultas");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(207, 90, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 427, 465, 239);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 465, 239);
		panel_1.add(scrollPane_1);
		
		tableExames = new JTable();
		scrollPane_1.setViewportView(tableExames);
		tableExames.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo exame", "Paciente", "CRM Medico", "Data", "Valor"
			}
		));
		
		JLabel lblNewLabel_2 = new JLabel("Exames");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(219, 394, 64, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});
		btnNewButton_1.setBounds(194, 685, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}

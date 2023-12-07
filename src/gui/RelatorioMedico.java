package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Consulta;
import service.MedicoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class RelatorioMedico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomemedicoField;
	private MedicoService medicoservice;
	private JTable tableConsultas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioMedico frame = new RelatorioMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void buscarDadosMedico() {
		try {
			List<Consulta> lista=this.medicoservice.montarRelatorio(this.nomemedicoField.getText());
			DefaultTableModel consultas = (DefaultTableModel) this.tableConsultas.getModel();
			for(Consulta consulta:lista) {
				Object[]dados= {consulta.getNomemedico(),consulta.getNomepaciente(),consulta.getData(),consulta.getHora()};
				consultas.addRow(dados);
			}
		}catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar consultas do medico", "Medico", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void fecharJanela() {
		this.setVisible(false);
	}
	

	/**
	 * Create the frame.
	 */
	public RelatorioMedico() {
		this.medicoservice= new MedicoService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeField = new JLabel("Médico");
		nomeField.setBounds(64, 11, 33, 14);
		contentPane.add(nomeField);
		
		nomemedicoField = new JTextField();
		nomemedicoField.setBounds(107, 8, 86, 20);
		contentPane.add(nomemedicoField);
		nomemedicoField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarDadosMedico();
			}
		});
		btnNewButton.setBounds(203, 7, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});
		btnNewButton_1.setBounds(168, 458, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 107, 389, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 389, 326);
		panel.add(scrollPane);
		
		tableConsultas = new JTable();
		scrollPane.setViewportView(tableConsultas);
		tableConsultas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome Medico", "Nome Paciente", "Data", "Hora"
			}
		));
	}
}

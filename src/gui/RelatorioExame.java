package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.PedidoExame;
import service.ExameService;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class RelatorioExame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codigoField;
	private JTable tableExames;
	private JButton btnNewButton;
	private ExameService exameservice;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioExame frame = new RelatorioExame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void buscarDadosExame() {
		try {
			List<PedidoExame> lista=this.exameservice.montarRelatorio(this.codigoField.getText());
			DefaultTableModel exames = (DefaultTableModel) this.tableExames.getModel();
			for(PedidoExame pedidoexame:lista) {
				Object[]dados= {pedidoexame.getCodigoexame(),pedidoexame.getNomepaciente(),pedidoexame.getCrmMedico(),pedidoexame.getDataRealizacao(),pedidoexame.getValorPago()};
				exames.addRow(dados);
			}
		}catch (SQLException | IOException e){
			JOptionPane.showMessageDialog(null, "Erro ao buscar consultas do medico", "Medico", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void fecharJanela() {
		this.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	public RelatorioExame() {
		this.exameservice= new ExameService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo do exame");
		lblNewLabel.setBounds(57, 11, 83, 14);
		contentPane.add(lblNewLabel);
		
		codigoField = new JTextField();
		codigoField.setBounds(150, 8, 86, 20);
		contentPane.add(codigoField);
		codigoField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 114, 390, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 390, 391);
		panel.add(scrollPane);
		
		tableExames = new JTable();
		scrollPane.setViewportView(tableExames);
		tableExames.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Exame", "Paciente", "CRM", "Data Realizacao", "Valor pago"
			}
		));
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarDadosExame();
			}
		});
		btnNewButton.setBounds(256, 7, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});
		btnNewButton_1.setBounds(161, 525, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}

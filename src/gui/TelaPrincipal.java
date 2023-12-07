package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastro de Paciente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPaciente cadastropaciente = new CadastroPaciente();
				cadastropaciente.setVisible(true);
			}
		});
		btnNewButton.setBounds(128, 43, 159, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastro de Especialidade");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroEspecialidade cadastroespecialidade = new CadastroEspecialidade();
				cadastroespecialidade.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(128, 77, 159, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastro de Medico");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroMedico cadastromedico= new CadastroMedico();
				cadastromedico.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(128, 111, 159, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Agendar Consulta");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendarConsulta agendarconsulta = new AgendarConsulta();
				agendarconsulta.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(128, 145, 159, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cadastro de exame");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroExame cadastroexame= new CadastroExame();
				cadastroexame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(128, 179, 159, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Pedidos de Exames");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleExames controleexame= new ControleExames();
				controleexame.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(128, 213, 159, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Médico");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioMedico relatoriomedico=new RelatorioMedico();
				relatoriomedico.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(128, 296, 159, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Exame");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioExame relatorioexame= new RelatorioExame();
				relatorioexame.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(128, 330, 159, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Paciente");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioPaciente relatoriopaciente= new RelatorioPaciente();
				relatoriopaciente.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(128, 364, 159, 23);
		contentPane.add(btnNewButton_8);
		
		JLabel lblNewLabel = new JLabel("Funcionalidades");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(162, 11, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Relatorios");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(178, 271, 82, 14);
		contentPane.add(lblNewLabel_1);
	}
}

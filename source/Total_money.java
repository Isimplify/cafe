package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Total_money extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Total_money(int money) {
		setTitle("��Ӫҵ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel();
		message.setFont(new Font("����", Font.PLAIN, 24));
		message.setBounds(68, 28, 366, 88);
		contentPane.add(message);
		message.setText("���յ���Ӫҵ��Ϊ��" + money + "Ԫ��");
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(149, 126, 105, 42);
		contentPane.add(btnNewButton);
		
		this.setVisible(true);
	}

}

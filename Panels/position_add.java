package Panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import source.Manager_UI;
import DataBaseUtil.ConnectDataBase;

public class position_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	position_add position_add_frame = this;
	public position_add() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 5, 240,176);
		getContentPane().setLayout(null);

		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/13.png"));
		
		
		
		JLabel lposition = new JLabel("职称名");
		lposition.setHorizontalAlignment(SwingConstants.CENTER);
		lposition.setBounds(25, 5, 100, 35);
		lposition.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lposition);
		
		
		JLabel lsalary = new JLabel("薪水");
		lsalary.setHorizontalAlignment(SwingConstants.CENTER);
		lsalary.setBounds(125, 5, 70, 35);
		lsalary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lsalary);
		
		
		
		JFormattedTextField Jposition = new JFormattedTextField();
		Jposition.setHorizontalAlignment(SwingConstants.CENTER);
		Jposition.setBounds(25, 40, 100, 35);
		Jposition.setEditable(true);
		getContentPane().add(Jposition);
		
		JFormattedTextField Jsalary = new JFormattedTextField();
		Jsalary.setHorizontalAlignment(SwingConstants.CENTER);
		Jsalary.setBounds(125, 40, 70, 35);
		Jsalary.setEditable(true);
		getContentPane().add(Jsalary);
		
		
		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Jposition.getText().length() == 0 ||  Jsalary.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "请在文本框中输入内容", "错误", JOptionPane.ERROR_MESSAGE);
				else{
					String SQLstatement = "insert into position (p_name, p_salary) "
							+ "values( '" + Jposition.getText() 
							+ "' ,'" +Jsalary.getText() +"')";
					try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
					Manager_UI.showMap("position");
					position_add_frame.dispose();
				}
			}
		});
		confirm.setBounds(25, 90, 80, 30);
		getContentPane().add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position_add_frame.dispose();
			}
		});
		cancel.setBounds(115, 90, 80, 30);
		getContentPane().add(cancel);
		
		
		this.setVisible(true);
	}

}

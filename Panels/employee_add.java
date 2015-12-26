package Panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class employee_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	employee_add employ_add_frame = this;
	public employee_add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 342,176);
		getContentPane().setLayout(null);
		
		
		JLabel lname = new JLabel("����");
		lname.setHorizontalAlignment(SwingConstants.CENTER);
		lname.setBounds(25, 5, 60, 35);
		lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lname);
		
		
		JLabel lsex = new JLabel("�Ա�");
		lsex.setHorizontalAlignment(SwingConstants.CENTER);
		lsex.setBounds(85, 5, 40, 35);
		lsex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lsex);
		
		JLabel lage = new JLabel("����");
		lage.setHorizontalAlignment(SwingConstants.CENTER);
		lage.setBounds(125, 5, 40, 35);
		lage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lage);
		
		JLabel ltel = new JLabel("�绰");
		ltel.setHorizontalAlignment(SwingConstants.CENTER);
		ltel.setBounds(165, 5, 70, 35);
		ltel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(ltel);
		
		JLabel lpassw = new JLabel("ְ��");
		lpassw.setHorizontalAlignment(SwingConstants.CENTER);
		lpassw.setBounds(235, 5, 40, 35);
		lpassw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lpassw);
		
		JButton add = new JButton("���");
		add.setBounds(405, 5, 60, 35);
		add.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	new supplier_add();
		       }
		} );
		getContentPane().add(add);
		
		JFormattedTextField Jname = new JFormattedTextField();
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(25, 40, 60, 35);
		Jname.setEditable(true);
		getContentPane().add(Jname);
		
		
		
		JFormattedTextField Jsex = new JFormattedTextField();
		Jsex.setHorizontalAlignment(SwingConstants.CENTER);
		Jsex.setBounds(85, 40, 40, 35);
		Jsex.setEditable(true);
		getContentPane().add(Jsex);
		
		JFormattedTextField Jage = new JFormattedTextField();
		Jage.setHorizontalAlignment(SwingConstants.CENTER);
		Jage.setBounds(125, 40, 40, 35);
		Jage.setEditable(true);
		getContentPane().add(Jage);
		
		JFormattedTextField Jtel = new JFormattedTextField();
		Jtel.setHorizontalAlignment(SwingConstants.CENTER);
		Jtel.setBounds(165, 40, 70, 35);
		Jtel.setEditable(true);
		getContentPane().add(Jtel);
		
		JFormattedTextField Jpid = new JFormattedTextField();
		Jpid.setHorizontalAlignment(SwingConstants.CENTER);
		Jpid.setBounds(235, 40, 40, 35);
		Jpid.setEditable(true);
		getContentPane().add(Jpid);
		
		JButton confirm = new JButton("ȷ��");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Jname.getText().length() == 0 ||  Jsex.getText().length() == 0 || Jage.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "�����ı�������������", "����", JOptionPane.ERROR_MESSAGE);
				else{
					String SQLstatement = "insert into employee (w_name, w_sex, w_age,w_tel,p_id) "
							+ "values( '" + Jname.getText() 
							+ "' ,'" +Jsex.getText()
							+ "' ,'" +Jage.getText()
							+ "' ,'" +Jtel.getText()
							+ "' ,'" +Jpid.getText()
							+"')";
					try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
					Manager_UI.showMap("employee");
					employ_add_frame.dispose();
				}
			}
		});
		confirm.setBounds(60, 97, 80, 30);
		getContentPane().add(confirm);
		
		JButton cancel = new JButton("ȡ��");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employ_add_frame.dispose();
			}
		});
		cancel.setBounds(189, 97, 80, 30);
		getContentPane().add(cancel);
		
		
		this.setVisible(true);
	}

}

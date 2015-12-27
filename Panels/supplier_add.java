package Panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import source.Manager_UI;
import DataBaseUtil.ConnectDataBase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class supplier_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	supplier_add supplier_add_frame = this;
	public supplier_add() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 5, 308,176);
		getContentPane().setLayout(null);
		
		JLabel lname = new JLabel("姓名");
		lname.setHorizontalAlignment(SwingConstants.CENTER);
		lname.setBounds(5, 5, 80, 35);
		lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lname);
		
		
		
		JLabel lcity = new JLabel("城市");
		lcity.setHorizontalAlignment(SwingConstants.CENTER);
		lcity.setBounds(85, 5, 70, 35);
		lcity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lcity);
		
		JLabel ltel = new JLabel("电话号码");
		ltel.setHorizontalAlignment(SwingConstants.CENTER);
		ltel.setBounds(155, 5, 120, 35);
		ltel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(ltel);
		
		
		
		JFormattedTextField Jname = new JFormattedTextField();
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(5, 40, 80, 35);
		Jname.setEditable(true);
		getContentPane().add(Jname);
		
		
		
		JFormattedTextField Jcity = new JFormattedTextField();
		Jcity.setHorizontalAlignment(SwingConstants.CENTER);
		Jcity.setBounds(85, 40, 70, 35);
		Jcity.setEditable(true);
		getContentPane().add(Jcity);
		
		JFormattedTextField Jtel = new JFormattedTextField();
		Jtel.setHorizontalAlignment(SwingConstants.CENTER);
		Jtel.setBounds(155, 40, 120, 35);
		Jtel.setEditable(true);
		getContentPane().add(Jtel);
		
		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Jname.getText().length() == 0 ||  Jcity.getText().length() == 0 || Jtel.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "请在文本框中输入内容", "错误", JOptionPane.ERROR_MESSAGE);
				else{
					String SQLstatement = "insert into supplier (s_name,  s_addr, s_tele) "
							+ "values( '" + Jname.getText()  
							+ "' ,'" +Jcity.getText()
							+ "' ,'" +Jtel.getText()+"')";
					try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
					Manager_UI.showMap("supplier");
					supplier_add_frame.dispose();
				}
			}
		});
		confirm.setBounds(55, 97, 80, 30);
		getContentPane().add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supplier_add_frame.dispose();
			}
		});
		cancel.setBounds(145, 97, 80, 30);
		getContentPane().add(cancel);
		
		
		this.setVisible(true);
	}
}

/*that is is is a test*/

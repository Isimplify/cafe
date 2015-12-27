package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DataBaseUtil.ConnectDataBase;

public class supplier_title extends JPanel {

	/**
	 * Create the panel.
	 */
	public supplier_title() {
		setLayout(null);
		JLabel Jid = new JLabel("ID");
		Jid.setHorizontalAlignment(SwingConstants.CENTER);
		Jid.setBounds(5, 5, 50, 35);
		Jid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		
		add(Jid);
		
		JLabel Jname = new JLabel("姓名");
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(55, 5, 80, 35);
		Jname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jname);
		
		
		JLabel Jcity = new JLabel("城市");
		Jcity.setHorizontalAlignment(SwingConstants.CENTER);
		Jcity.setBounds(135, 5, 70, 35);
		Jcity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jcity);
		
		JLabel Jtel = new JLabel("电话号码");
		Jtel.setHorizontalAlignment(SwingConstants.CENTER);
		Jtel.setBounds(205, 5, 100, 35);
		Jtel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jtel);
		
		
		JButton add = new JButton("添加");
		add.setBounds(405, 5, 60, 35);
		add.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	new supplier_add();
		       }
		} );
		add(add);
		
		this.setVisible(true);
	}

}

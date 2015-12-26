package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class employee_title extends JPanel {

	/**
	 * Create the panel.
	 */
	public employee_title() {
		JLabel Jid = new JLabel("ID");
		Jid.setHorizontalAlignment(SwingConstants.CENTER);
		Jid.setBounds(5, 5, 40, 35);
		Jid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		
		add(Jid);
		
		JLabel Jname = new JLabel("姓名");
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(45, 5, 60, 35);
		Jname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jname);
		
		
		JLabel Jsex = new JLabel("性别");
		Jsex.setHorizontalAlignment(SwingConstants.CENTER);
		Jsex.setBounds(105, 5, 40, 35);
		Jsex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jsex);
		
		JLabel Jage = new JLabel("年龄");
		Jage.setHorizontalAlignment(SwingConstants.CENTER);
		Jage.setBounds(145, 5, 40, 35);
		Jage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jage);
		
		JLabel Jtel = new JLabel("电话");
		Jtel.setHorizontalAlignment(SwingConstants.CENTER);
		Jtel.setBounds(185, 5, 70, 35);
		Jtel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jtel);
		
		JLabel Jpassw = new JLabel("职称");
		Jpassw.setHorizontalAlignment(SwingConstants.CENTER);
		Jpassw.setBounds(255, 5, 40, 35);
		Jpassw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jpassw);
		
		JButton add = new JButton("添加");
		add.setBounds(405, 5, 60, 35);
		add.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	new employee_add();
		       }
		} );
		add(add);
		
		this.setVisible(true);
	}

}

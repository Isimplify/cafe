package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class position_title extends JPanel {

	/**
	 * Create the panel.
	 */
	public position_title() {
		setLayout(null);
		JLabel Jid = new JLabel("职称编号");
		Jid.setHorizontalAlignment(SwingConstants.CENTER);
		Jid.setBounds(5, 5, 70, 35);
		Jid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		
		add(Jid);
		
		JLabel Jname = new JLabel("职称名");
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(75, 5, 100, 35);
		Jname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jname);
		
		JLabel Jsalary = new JLabel("薪水");
		Jsalary.setHorizontalAlignment(SwingConstants.CENTER);
		Jsalary.setBounds(175, 5, 70, 35);
		Jsalary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jsalary);
		
		
		JButton add = new JButton("添加");
		add.setBounds(405, 5, 60, 35);
		add.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	new position_add();
		       }
		} );
		add(add);
		
		this.setVisible(true);
	}

}

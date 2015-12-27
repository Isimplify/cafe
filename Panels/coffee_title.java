package Panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class coffee_title extends JPanel {

	/**
	 * Create the panel.
	 */
	public coffee_title() {
		setLayout(null);
		JLabel Jid = new JLabel("ID");
		Jid.setFont(new Font("Droid Serif", Font.BOLD, 12));
		Jid.setHorizontalAlignment(SwingConstants.CENTER);
		Jid.setBounds(5, 5, 50, 35);
		Jid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jid);
		
		
		JLabel Jprice = new JLabel("�۸�");
		Jprice.setHorizontalAlignment(SwingConstants.CENTER);
		Jprice.setBounds(135, 5, 70, 35);
		Jprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jprice);
		
		JLabel Jname = new JLabel("����");
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(55, 5, 80, 35);
		Jname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jname);
		
		JLabel Jnum = new JLabel("����");
		Jnum.setHorizontalAlignment(SwingConstants.CENTER);
		Jnum.setBounds(205, 5, 70, 35);
		Jnum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jnum);
		
		JButton add = new JButton("���");
		add.setBounds(405, 5, 60, 35);
		add.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	new coffee_add();
		       }
		} );
		add(add);
		
		this.setVisible(true);
	}

}

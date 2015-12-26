package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class material_title extends JPanel {

	/**
	 * Create the panel.
	 */
	public material_title() {
		JLabel Jid = new JLabel("ID");
		Jid.setHorizontalAlignment(SwingConstants.CENTER);
		Jid.setBounds(5, 5, 50, 35);
		Jid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		
		add(Jid);
		
		JLabel Jname = new JLabel("ÐÕÃû");
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(55, 5, 80, 35);
		Jname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jname);
		
		
		JLabel Jcity = new JLabel("¿â´æ");
		Jcity.setHorizontalAlignment(SwingConstants.CENTER);
		Jcity.setBounds(135, 5, 70, 35);
		Jcity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jcity);
		
		
		JButton add = new JButton("Ìí¼Ó");
		add.setBounds(405, 5, 60, 35);
		add.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	new material_add();
		       }
		} );
		add(add);
		
		this.setVisible(true);
	}

}

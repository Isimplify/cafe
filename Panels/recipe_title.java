package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class recipe_title extends JPanel {

	/**
	 * Create the panel.
	 */
	public recipe_title() {
		
		
		
		JLabel Jcid = new JLabel("����ID");
		Jcid.setHorizontalAlignment(SwingConstants.CENTER);
		Jcid.setBounds(5, 5, 80, 35);
		Jcid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jcid);
		
		JLabel Jmid = new JLabel("ԭ��ID");
		Jmid.setHorizontalAlignment(SwingConstants.CENTER);
		Jmid.setBounds(85, 5, 80, 35);
		Jmid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jmid);
		
		JLabel Jdosage = new JLabel("����");
		Jdosage.setHorizontalAlignment(SwingConstants.CENTER);
		Jdosage.setBounds(165, 5, 80, 35);
		Jdosage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jdosage);
		
		
		JButton add = new JButton("���");
		add.setBounds(405, 5, 60, 35);
		add.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	new recipe_add();
		       }
		} );
		add(add);
		
		this.setVisible(true);
	}

}

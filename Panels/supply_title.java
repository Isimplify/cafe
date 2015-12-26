package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class supply_title extends JPanel {

	/**
	 * Create the panel.
	 */
	public supply_title() {
		JLabel Jsid = new JLabel("供应商ID");
		Jsid.setHorizontalAlignment(SwingConstants.CENTER);
		Jsid.setBounds(5, 5, 60, 35);
		Jsid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		
		add(Jsid);
		
		JLabel Jmid = new JLabel("原料ID");
		Jmid.setHorizontalAlignment(SwingConstants.CENTER);
		Jmid.setBounds(65, 5, 60, 35);
		Jmid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jmid);
		
		JLabel Jamount = new JLabel("数量");
		Jamount.setHorizontalAlignment(SwingConstants.CENTER);
		Jamount.setBounds(125, 5, 80, 35);
		Jamount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jamount);
		
		JLabel Jprice = new JLabel("总价");
		Jprice.setHorizontalAlignment(SwingConstants.CENTER);
		Jprice.setBounds(205, 5, 80, 35);
		Jprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jprice);
		
		JButton add = new JButton("添加");
		add.setBounds(405, 5, 60, 35);
		add.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	new supply_add();
		       }
		} );
		add(add);
		
		this.setVisible(true);
	}

}

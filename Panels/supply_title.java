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
		JLabel Jsuid = new JLabel("��ӦID");
		Jsuid.setHorizontalAlignment(SwingConstants.CENTER);
		Jsuid.setBounds(5, 5, 40, 35);
		Jsuid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jsuid);
		
		JLabel Jsid = new JLabel("��Ӧ��ID");
		Jsid.setHorizontalAlignment(SwingConstants.CENTER);
		Jsid.setBounds(45, 5, 40, 35);
		Jsid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jsid);
		
		JLabel Jmid = new JLabel("ԭ��ID");
		Jmid.setHorizontalAlignment(SwingConstants.CENTER);
		Jmid.setBounds(85, 5, 40, 35);
		Jmid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jmid);
		
		JLabel Jamount = new JLabel("����");
		Jamount.setHorizontalAlignment(SwingConstants.CENTER);
		Jamount.setBounds(125, 5, 80, 35);
		Jamount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jamount);
		
		JLabel Jprice = new JLabel("�ܼ�");
		Jprice.setHorizontalAlignment(SwingConstants.CENTER);
		Jprice.setBounds(205, 5, 80, 35);
		Jprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jprice);
		
		JButton add = new JButton("���");
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

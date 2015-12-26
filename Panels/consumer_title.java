package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class consumer_title extends JPanel {

	/**
	 * Create the panel.
	 */
	public consumer_title() {
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
		
		JLabel Jconsume = new JLabel("单次消费");
		Jconsume.setHorizontalAlignment(SwingConstants.CENTER);
		Jconsume.setBounds(145, 5, 70, 35);
		Jconsume.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jconsume);
		
		JLabel JifMember = new JLabel("会员");
		JifMember.setHorizontalAlignment(SwingConstants.CENTER);
		JifMember.setBounds(215, 5, 40, 35);
		JifMember.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(JifMember);
		
		JLabel Jconsume_total = new JLabel("消费总额");
		Jconsume_total.setHorizontalAlignment(SwingConstants.CENTER);
		Jconsume_total.setBounds(255, 5, 70, 35);
		Jconsume_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		add(Jconsume_total);
		
		JButton add = new JButton("添加");
		add.setBounds(405, 5, 60, 35);
		add.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	new consumer_add();
		       }
		} );
		add(add);
		
		this.setVisible(true);
	}

}

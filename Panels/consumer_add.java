package Panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import source.Manager_UI;
import DataBaseUtil.ConnectDataBase;

public class consumer_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	consumer_add consumer_add_frame = this;
	public consumer_add() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 10, 349,176);
		getContentPane().setLayout(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/13.png"));
		
	
		
		JLabel lname = new JLabel("姓名");
		lname.setHorizontalAlignment(SwingConstants.CENTER);
		lname.setBounds(25, 10, 60, 35);
		lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lname);
		
		
		JLabel lsex = new JLabel("性别");
		lsex.setHorizontalAlignment(SwingConstants.CENTER);
		lsex.setBounds(85, 10, 40, 35);
		lsex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lsex);
		
		JLabel lconsume = new JLabel("单次消费");
		lconsume.setHorizontalAlignment(SwingConstants.CENTER);
		lconsume.setBounds(125, 10, 70, 35);
		lconsume.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lconsume);
		
		JLabel lifMember = new JLabel("是否会员");
		lifMember.setHorizontalAlignment(SwingConstants.CENTER);
		lifMember.setBounds(195, 10, 40, 35);
		lifMember.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lifMember);
		
		JLabel lconsume_total = new JLabel("消费总额");
		lconsume_total.setHorizontalAlignment(SwingConstants.CENTER);
		lconsume_total.setBounds(235, 10, 70, 35);
		lconsume_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lconsume_total);
		
		
		
		JFormattedTextField Jname = new JFormattedTextField();
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(25, 45, 60, 35);
		Jname.setEditable(true);
		getContentPane().add(Jname);
		
		
		JFormattedTextField Jsex = new JFormattedTextField();
		Jsex.setHorizontalAlignment(SwingConstants.CENTER);
		Jsex.setBounds(85, 45, 40, 35);
		Jsex.setEditable(true);
		getContentPane().add(Jsex);
		
		JFormattedTextField Jconsume = new JFormattedTextField();
		Jconsume.setHorizontalAlignment(SwingConstants.CENTER);
		Jconsume.setBounds(125, 45, 70, 35);
		Jconsume.setEditable(true);
		getContentPane().add(Jconsume);
		
		JFormattedTextField JifMember = new JFormattedTextField();
		JifMember.setHorizontalAlignment(SwingConstants.CENTER);
		JifMember.setBounds(195, 45, 40, 35);
		JifMember.setEditable(true);
		getContentPane().add(JifMember);
		
		JFormattedTextField Jconsume_total = new JFormattedTextField();
		Jconsume_total.setHorizontalAlignment(SwingConstants.CENTER);
		Jconsume_total.setBounds(235, 45, 70, 35);
		Jconsume_total.setEditable(true);
		getContentPane().add(Jconsume_total);
		
		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Jname.getText().length() == 0 ||  Jsex.getText().length() == 0 || Jconsume.getText().length() == 0 || JifMember.getText().length() == 0 || Jconsume_total.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "请在文本框中输入内容", "错误", JOptionPane.ERROR_MESSAGE);
				else{
					String SQLstatement = "insert into user (u_name, u_sex, u_consume, u_ifMem, u_total) "
							+ "values( '" + Jname.getText() 
							+ "' ,'" +Jsex.getText()
							+ "' ,'" +Jconsume.getText()
							+ "' ,'" +JifMember.getText()
							+ "' ,'" +Jconsume_total.getText()+"')";
					try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
					Manager_UI.showMap("consumer");
					consumer_add_frame.dispose();
				}
			}
		});
		confirm.setBounds(72, 97, 80, 30);
		getContentPane().add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consumer_add_frame.dispose();
			}
		});
		cancel.setBounds(180, 97, 80, 30);
		getContentPane().add(cancel);
		
		
		this.setVisible(true);
	}

}

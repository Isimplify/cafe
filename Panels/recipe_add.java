package Panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class recipe_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	recipe_add recipe_add_frame = this;
	public recipe_add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 314,176);
		getContentPane().setLayout(null);
		
		JLabel lcid = new JLabel("咖啡ID");
		lcid.setHorizontalAlignment(SwingConstants.CENTER);
		lcid.setBounds(35, 5, 80, 35);
		lcid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lcid);
		
		
		
		JLabel lmid = new JLabel("原料ID");
		lmid.setHorizontalAlignment(SwingConstants.CENTER);
		lmid.setBounds(115, 5, 80, 35);
		lmid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lmid);
		
		
		JLabel ldosage = new JLabel("用量");
		ldosage.setHorizontalAlignment(SwingConstants.CENTER);
		ldosage.setBounds(195, 5, 70, 35);
		ldosage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(ldosage);
		
		JFormattedTextField Jcid = new JFormattedTextField();
		Jcid.setHorizontalAlignment(SwingConstants.CENTER);
		Jcid.setBounds(35, 40, 80, 35);
		Jcid.setEditable(true);
		getContentPane().add(Jcid);
		
		
		
		JFormattedTextField Jmid = new JFormattedTextField();
		Jmid.setHorizontalAlignment(SwingConstants.CENTER);
		Jmid.setBounds(115, 40, 80, 35);
		Jmid.setEditable(true);
		getContentPane().add(Jmid);
		
		JFormattedTextField Jdosage = new JFormattedTextField();
		Jdosage.setHorizontalAlignment(SwingConstants.CENTER);
		Jdosage.setBounds(195, 40, 70, 35);
		Jdosage.setEditable(true);
		getContentPane().add(Jdosage);
		
		
		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Jcid.getText().length() == 0 ||  Jmid.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "请在文本框中输入内容", "错误", JOptionPane.ERROR_MESSAGE);
				else{
					String SQLstatement = "insert into recipe (c_id, ml_id,dosage) "
							+ "values( '" + Jcid.getText() 
							+ "' ,'" +Jmid.getText() 
							+"','" +Jdosage.getText()+"')";
					try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
					Manager_UI.showMap("recipe");
					recipe_add_frame.dispose();
				}
			}
		});
		confirm.setBounds(62, 90, 80, 30);
		getContentPane().add(confirm);
		
		JButton button = new JButton("取消");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recipe_add_frame.dispose();
			}
		});
		button.setBounds(170, 90, 80, 30);
		getContentPane().add(button);
		
		
		this.setVisible(true);
	}

}

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

public class supply_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	supply_add supply_add_frame = this;
	public supply_add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 369,176);
		getContentPane().setLayout(null);
		
		JLabel lsid = new JLabel("供应商ID");
		lsid.setHorizontalAlignment(SwingConstants.CENTER);
		lsid.setBounds(35, 5, 60, 35);
		lsid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lsid);
		
		
		
		JLabel Imid = new JLabel("原料ID");
		Imid.setHorizontalAlignment(SwingConstants.CENTER);
		Imid.setBounds(95, 5, 60, 35);
		Imid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(Imid);
		
		JLabel Iamount = new JLabel("原料ID");
		Iamount.setHorizontalAlignment(SwingConstants.CENTER);
		Iamount.setBounds(155, 5, 80, 35);
		Iamount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(Iamount);
		
		JLabel lprice = new JLabel("原料ID");
		lprice.setHorizontalAlignment(SwingConstants.CENTER);
		lprice.setBounds(235, 5, 80, 35);
		lprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lprice);
		
		
		JFormattedTextField Jsid = new JFormattedTextField();
		Jsid.setHorizontalAlignment(SwingConstants.CENTER);
		Jsid.setBounds(35, 40, 60, 35);
		Jsid.setEditable(true);
		getContentPane().add(Jsid);
		
		
		
		JFormattedTextField Jmid = new JFormattedTextField();
		Jmid.setHorizontalAlignment(SwingConstants.CENTER);
		Jmid.setBounds(95, 40, 60, 35);
		Jmid.setEditable(true);
		getContentPane().add(Jmid);
		
		
		JFormattedTextField Jamount = new JFormattedTextField();
		Jamount.setHorizontalAlignment(SwingConstants.CENTER);
		Jamount.setBounds(155, 40, 80, 35);
		Jamount.setEditable(true);
		getContentPane().add(	Jamount);
		
		JFormattedTextField Jprice = new JFormattedTextField();
		Jprice.setHorizontalAlignment(SwingConstants.CENTER);
		Jprice.setBounds(235, 40, 80, 35);
		Jprice.setEditable(true);
		getContentPane().add(Jprice);
		
		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Jsid.getText().length() == 0 ||  Jmid.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "请在文本框中输入内容", "错误", JOptionPane.ERROR_MESSAGE);
				else{
					String SQLstatement = "insert into supply (su_id, m_id,amount,price) "
							+ "values( '" + Jsid.getText() 
							+"','" + Jmid.getText()
							+"','" + Jamount.getText()	
							+ "' ,'" +Jprice.getText() +"')";
					try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
					Manager_UI.showMap("supply");
					supply_add_frame.dispose();
				}
			}
		});
		confirm.setBounds(59, 100, 80, 30);
		getContentPane().add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supply_add_frame.dispose();
			}
		});
		cancel.setBounds(212, 100, 80, 30);
		getContentPane().add(cancel);
		
		
		this.setVisible(true);
	}

}

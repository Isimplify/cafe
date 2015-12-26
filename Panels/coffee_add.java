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

public class coffee_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	int num = 0;//咖啡余量
	coffee_add coffee_add_frame = this;
	public coffee_add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 244,176);
		getContentPane().setLayout(null);
		
		JLabel lname = new JLabel("名称");
		lname.setHorizontalAlignment(SwingConstants.CENTER);
		lname.setBounds(35, 5, 80, 35);
		lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lname);
		
		
		
		JLabel Iprice = new JLabel("价格");
		Iprice.setHorizontalAlignment(SwingConstants.CENTER);
		Iprice.setBounds(115, 5, 70, 35);
		Iprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(Iprice);
		
		/*咖啡的数量应该是算出来的。如果配方表中已经记录了该咖啡，则算出来，否则默认为0*/
		/*配方表中增添信息时，也要修改咖啡的量*/
		
		
		JFormattedTextField Jname = new JFormattedTextField();
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(35, 40, 80, 35);
		Jname.setEditable(true);
		getContentPane().add(Jname);
		
		
		
		JFormattedTextField Jprice = new JFormattedTextField();
		Jprice.setHorizontalAlignment(SwingConstants.CENTER);
		Jprice.setBounds(115, 40, 70, 35);
		Jprice.setEditable(true);
		getContentPane().add(Jprice);
		
		
		
		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Jname.getText().length() == 0 ||  Jprice.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "请在文本框中输入内容", "错误", JOptionPane.ERROR_MESSAGE);
				else{
					String SQLstatement = "insert into coffee (c_name, c_price,c_num) "
							+ "values( '" + Jname.getText() 
							+ "' ,'" +Jprice.getText() 
							+ "' ,'" +num 
							+"')";
					try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
					Manager_UI.showMap("coffee");
					coffee_add_frame.dispose();
				}
			}
		});
		confirm.setBounds(30, 100, 80, 30);
		getContentPane().add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee_add_frame.dispose();
			}
		});
		cancel.setBounds(120, 100, 80, 30);
		getContentPane().add(cancel);
		
		
		this.setVisible(true);
	}

}

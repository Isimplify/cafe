package Panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
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

public class employee_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	employee_add employ_add_frame = this;
	public employee_add() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 5, 342,176);
		getContentPane().setLayout(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/13.png"));
		
		
		JLabel lname = new JLabel("姓名");
		lname.setHorizontalAlignment(SwingConstants.CENTER);
		lname.setBounds(25, 5, 60, 35);
		lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lname);
		
		
		JLabel lsex = new JLabel("性别");
		lsex.setHorizontalAlignment(SwingConstants.CENTER);
		lsex.setBounds(85, 5, 40, 35);
		lsex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lsex);
		
		JLabel lage = new JLabel("年龄");
		lage.setHorizontalAlignment(SwingConstants.CENTER);
		lage.setBounds(125, 5, 40, 35);
		lage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lage);
		
		JLabel ltel = new JLabel("电话");
		ltel.setHorizontalAlignment(SwingConstants.CENTER);
		ltel.setBounds(165, 5, 70, 35);
		ltel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(ltel);
		
		JLabel lpassw = new JLabel("职称");
		lpassw.setHorizontalAlignment(SwingConstants.CENTER);
		lpassw.setBounds(235, 5, 40, 35);
		lpassw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lpassw);
		
		JButton add = new JButton("添加");
		add.setBounds(405, 5, 60, 35);
		add.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	new supplier_add();
		       }
		} );
		getContentPane().add(add);
		
		JFormattedTextField Jname = new JFormattedTextField();
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(25, 40, 60, 35);
		Jname.setEditable(true);
		getContentPane().add(Jname);
		
		
		
		JFormattedTextField Jsex = new JFormattedTextField();
		Jsex.setHorizontalAlignment(SwingConstants.CENTER);
		Jsex.setBounds(85, 40, 40, 35);
		Jsex.setEditable(true);
		getContentPane().add(Jsex);
		
		JFormattedTextField Jage = new JFormattedTextField();
		Jage.setHorizontalAlignment(SwingConstants.CENTER);
		Jage.setBounds(125, 40, 40, 35);
		Jage.setEditable(true);
		getContentPane().add(Jage);
		
		JFormattedTextField Jtel = new JFormattedTextField();
		Jtel.setHorizontalAlignment(SwingConstants.CENTER);
		Jtel.setBounds(165, 40, 70, 35);
		Jtel.setEditable(true);
		getContentPane().add(Jtel);
		
		JFormattedTextField Jpid = new JFormattedTextField();
		Jpid.setHorizontalAlignment(SwingConstants.CENTER);
		Jpid.setBounds(235, 40, 40, 35);
		Jpid.setEditable(true);
		getContentPane().add(Jpid);
		
		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Jname.getText().length() == 0 ||  Jsex.getText().length() == 0 || Jage.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "请在文本框中输入内容", "错误", JOptionPane.ERROR_MESSAGE);
				else{
					String id = getNextId(Jpid.getText());
					String SQLstatement = "insert into employee (w_id,w_name, w_sex, w_age,w_tel, w_password, p_id) "
							+ "values( '" +id
							+ "', '" +Jname.getText() 
							+ "' ,'" +Jsex.getText()
							+ "' ,'" +Jage.getText()
							+ "' ,'" +Jtel.getText()
							+ "' ,'" +"123"
							+ "' ,'" +Jpid.getText()
							+"')";
					try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
					Manager_UI.showMap("employee");
					employ_add_frame.dispose();
				}
			}
		});
		confirm.setBounds(60, 97, 80, 30);
		getContentPane().add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employ_add_frame.dispose();
			}
		});
		cancel.setBounds(189, 97, 80, 30);
		getContentPane().add(cancel);
		
		
		this.setVisible(true);
	}
	String getNextId(String pid){
		String SQLstatement1 = "select w_id from employee where p_id = "+pid;
		ResultSet rs1 = ConnectDataBase.Select(SQLstatement1);
		int max = 0;
		int p_id = Integer.parseInt(pid);
		try {
	              while(rs1.next()){
	              	System.out.println("* * *");
	              	if(Integer.parseInt(rs1.getString(1) ) / 1000 == p_id){
	              		if(Integer.parseInt(rs1.getString(1) ) % p_id >max)
	              			max = Integer.parseInt(rs1.getString(1) ) % p_id ;
	              	}
	              }
              } catch (NumberFormatException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
              } catch (SQLException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
              }
		max++;
		max = p_id*1000 + max;
		System.out.println("***** " + max +" ******");
		return ""+max;
	}
}

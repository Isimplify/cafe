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

public class coffee_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	coffee_add coffee_add_frame = this;
	public coffee_add() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 5, 244,176);
		getContentPane().setLayout(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/13.png"));
		
		JLabel lname = new JLabel("����");
		lname.setHorizontalAlignment(SwingConstants.CENTER);
		lname.setBounds(35, 5, 80, 35);
		lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lname);
		
		
		
		JLabel Iprice = new JLabel("�۸�");
		Iprice.setHorizontalAlignment(SwingConstants.CENTER);
		Iprice.setBounds(115, 5, 70, 35);
		Iprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(Iprice);
		
		/*���ȵ�����Ӧ����������ġ�����䷽�����Ѿ���¼�˸ÿ��ȣ��������������Ĭ��Ϊ0*/
		/*�䷽����������Ϣʱ��ҲҪ�޸Ŀ��ȵ���*/
		
		
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
		
		
		
		JButton confirm = new JButton("ȷ��");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Jname.getText().length() == 0 ||  Jprice.getText().length() == 0)
					JOptionPane.showMessageDialog(null, "�����ı�������������", "����", JOptionPane.ERROR_MESSAGE);
				else{
					String SQLstatement = "insert into coffee (c_name, c_price,c_num) "
							+ "values( '" + Jname.getText() 
							+ "' ,'" +Jprice.getText() 
							+ "' ,' 0 "  
							+"')";
					try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
					updateCoffeeNum(Jname.getText());
					Manager_UI.showMap("coffee");
					coffee_add_frame.dispose();
				}
			}
		});
		confirm.setBounds(30, 100, 80, 30);
		getContentPane().add(confirm);
		
		JButton cancel = new JButton("ȡ��");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee_add_frame.dispose();
			}
		});
		cancel.setBounds(120, 100, 80, 30);
		getContentPane().add(cancel);
		
		
		this.setVisible(true);
	}
	
	void updateCoffeeNum(String c_name){
       	String SQLstatement1 = "select c_id from coffee where c_name = '" + c_name +"'";
       	ResultSet rs1 = ConnectDataBase.Select(SQLstatement1);
       	int cid = 0;
       	try {
	              if(rs1.next())
	              	cid = rs1.getInt(1);
              } catch (SQLException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	              return;
              }
		ResultSet rs2 = null;
       	String SQLstatement2 = "select m_id,dosage from recipe where c_id = "+cid;
       	rs2 = ConnectDataBase.Select(SQLstatement2);
       	int min = -1;
       	try {
	              while(rs2.next()){
	              	ResultSet rs3 = null;
	              	int m_id = rs2.getInt(1);
	              	String SQLstatement3 = "select m_inventory from material where m_id = " + m_id;
	              	rs3 = ConnectDataBase.Select(SQLstatement3);
	              	int inventory = 0;
	              	if(rs3.next())
	              		inventory = rs3.getInt(1);
	              	int dosage = rs2.getInt(2);
	              	int num = inventory / dosage;
	              	if(num < min || min == -1)
	              		min = num;
	              }
              } catch (SQLException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	              return;
              }
       	if(min == -1)
       		min = 0;
       	String SQLstatement4 = "update coffee set c_num = "+min +" where c_id = " + cid;
       	try {
	              ConnectDataBase.Update(SQLstatement4);
              } catch (SQLException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
              }
	}
}

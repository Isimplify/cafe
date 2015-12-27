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

public class material_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	material_add material_add_frame = this;
	public material_add() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 5, 244,176);
		getContentPane().setLayout(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/13.png"));
		
		JLabel lname = new JLabel("名称");
		lname.setHorizontalAlignment(SwingConstants.CENTER);
		lname.setBounds(35, 5, 80, 35);
		lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(lname);
		
		
		
		JLabel linventory = new JLabel("库存");
		linventory.setHorizontalAlignment(SwingConstants.CENTER);
		linventory.setBounds(115, 5, 70, 35);
		linventory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		getContentPane().add(linventory);
		
		
		
		
		JFormattedTextField Jname = new JFormattedTextField();
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(35, 40, 80, 35);
		Jname.setEditable(true);
		getContentPane().add(Jname);
		
		
		
		JFormattedTextField Jinventory = new JFormattedTextField();
		Jinventory.setHorizontalAlignment(SwingConstants.CENTER);
		Jinventory.setBounds(115, 40, 70, 35);
		Jinventory.setEditable(true);
		getContentPane().add(Jinventory);
		
		
		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Jname.getText().length() == 0 ||  Jinventory.getText().length() == 0 )
					JOptionPane.showMessageDialog(null, "请在文本框中输入内容", "错误", JOptionPane.ERROR_MESSAGE);
				else{
					String SQLstatement = "insert into material (m_name, m_inventory) "
							+ "values( '" + Jname.getText() 
							+ "' ,'" +Jinventory.getText() +"')";
					try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
	                                   
                                   }
					Manager_UI.showMap("material");
                                   material_add_frame.dispose();
				}
			}
		});
		confirm.setBounds(30, 100, 80, 30);
		getContentPane().add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				material_add_frame.dispose();
			}
		});
		cancel.setBounds(120, 100, 80, 30);
		getContentPane().add(cancel);
		
		
		this.setVisible(true);
	}

}

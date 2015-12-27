package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataBaseUtil.*;
import javax.swing.JTextField;

public class Password_change extends JFrame {

	private JPanel contentPane;
	private JPasswordField pw1;
	private JPasswordField pw2;
	private JLabel label2;
	private JPasswordField pw3;
	private JLabel label3;
	private JButton cancel;
	private JButton sure;
	private JLabel label;
	private JTextField user;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Password_change() {
		JFrame jframe = this;
		setTitle("密码重置");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("旧密码");
		label1.setFont(new Font("宋体", Font.PLAIN, 18));
		label1.setBounds(161, 90, 67, 30);
		contentPane.add(label1);
		
		pw1 = new JPasswordField();
		pw1.setBounds(238, 92, 140, 28);
		contentPane.add(pw1);
		
		pw2 = new JPasswordField();
		pw2.setBounds(238, 152, 140, 28);
		contentPane.add(pw2);
		
		label2 = new JLabel("新密码");
		label2.setFont(new Font("宋体", Font.PLAIN, 18));
		label2.setBounds(161, 150, 67, 30);
		contentPane.add(label2);
		
		pw3 = new JPasswordField();
		pw3.setBounds(238, 217, 140, 28);
		contentPane.add(pw3);
		
		label3 = new JLabel("请重新输入");
		label3.setFont(new Font("宋体", Font.PLAIN, 18));
		label3.setBounds(131, 213, 109, 30);
		contentPane.add(label3);
		
		user = new JTextField();
		user.setBounds(238, 33, 140, 30);
		contentPane.add(user);
		user.setColumns(10);
		
		cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframe.dispose();
			}
		});
		cancel.setFont(new Font("宋体", Font.PLAIN, 18));
		cancel.setBounds(130, 284, 93, 36);
		contentPane.add(cancel);
		
		sure = new JButton("确定");
		sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userid = Integer.parseInt(user.getText());
				String SQLstatement1 = "select w_password  from employee  where w_id = " + userid;
				ResultSet rs = DataBaseUtil.ConnectDataBase.Select(SQLstatement1);
				try {
					if(rs.next()){
						String password = new String (rs.getString(1));
						String password_old = new String(pw1.getPassword());
						if(password.equals(password_old)){
							String password_new1 = new String(pw2.getPassword());
							String password_new2 = new String(pw3.getPassword());
							if(password_new1.equals(password_new2)){
								String SQLstatement = "update  employee set w_password = '" + 
							password_new1 + "' where w_id = " + userid;
								DataBaseUtil.ConnectDataBase.Update(SQLstatement);
								JOptionPane.showMessageDialog(null, "更改密码成功", "成功",JOptionPane.PLAIN_MESSAGE);
								jframe.dispose();
							}
							else{
								JOptionPane.showMessageDialog(null, "两次新密码不同，请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "原密码输入错误，请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "用户名不存在", "错误", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sure.setFont(new Font("宋体", Font.PLAIN, 18));
		sure.setBounds(285, 284, 93, 36);
		contentPane.add(sure);
		
		label = new JLabel("用户名");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(161, 30, 67, 30);
		contentPane.add(label);
		
		
		
		this.setVisible(true);
	}
}

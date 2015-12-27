package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.SpringLayout;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataBaseUtil.*;
import java.awt.Color;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private JTextField usernametxt;
	private JPasswordField passwordtxt;
	private JButton login;
	private JButton changepwd;
	private static Welcome frame = new Welcome();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setFont(new Font("Dialog", Font.PLAIN, 17));
		setTitle("\u6B22\u8FCE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lab1 = new JLabel("Caf\u00E9 \u7BA1\u7406\u7CFB\u7EDF");
		lab1.setForeground(Color.WHITE);
		lab1.setFont(new Font("宋体", Font.BOLD, 24));
		lab1.setBounds(243, 26, 218, 77);
		contentPane.add(lab1);
		
		JLabel label2 = new JLabel("\u7528\u6237\u540D");
		label2.setFont(new Font("宋体", Font.PLAIN, 16));
		label2.setBounds(168, 113, 66, 36);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("密码");
		label3.setFont(new Font("宋体", Font.PLAIN, 16));
		label3.setBounds(168, 173, 66, 36);
		contentPane.add(label3);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(265, 120, 131, 25);
		contentPane.add(usernametxt);
		usernametxt.setColumns(10);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(265, 180, 131, 25);
		contentPane.add(passwordtxt);
		
		login = new JButton("登录");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usernametxt.getText().length() == 0 || passwordtxt.getPassword().length == 0){
					if(usernametxt.getText().length() == 0 && passwordtxt.getPassword().length != 0)
						JOptionPane.showMessageDialog(null, "用户名不能为空", "错误", JOptionPane.ERROR_MESSAGE);
					else if(usernametxt.getText().length() != 0 && passwordtxt.getPassword().length == 0)
						JOptionPane.showMessageDialog(null, "密码不能为空", "错误", JOptionPane.ERROR_MESSAGE);
					else
					JOptionPane.showMessageDialog(null, "用户名和密码不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else{
					
					String user_id = usernametxt.getText();
					//int user_id = Integer.parseInt(username);
					String password = new String (passwordtxt.getPassword());
					String SQLstatement = "select w_password ,p_id from employee where w_id = '" + user_id + "'";
					ResultSet rs = DataBaseUtil.ConnectDataBase.Select(SQLstatement);
					try {
						if(rs.next()){
							int permission = rs.getInt(2);
							String pw = rs.getString(1);
							if(pw.equals(password)){
								if(permission ==1 || permission == 2) {///1表明是管理者权限
								frame.dispose();
								new Manager_UI().setVisible(true);
								}
								else{
									frame.dispose();
									new Waiter_UI(user_id).setVisible(true);
								}
							}
							else
								JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(null, "用户名无效", "错误", JOptionPane.ERROR_MESSAGE);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		login.setFont(new Font("宋体", Font.PLAIN, 16));
		login.setBounds(162, 256, 93, 41);
		contentPane.add(login);
		
		changepwd = new JButton("重置");
		changepwd.setFont(new Font("宋体", Font.PLAIN, 16));
		changepwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int userID = Integer.parseInt(usernametxt.getText());
				//String password = new String (passwordtxt.getPassword());
				new Password_change();
				
			}
		});
		changepwd.setBounds(346, 256, 93, 41);
		contentPane.add(changepwd);
		
		ImageIcon icon=new ImageIcon("images/8.jpg");
		icon.setImage(icon.getImage().getScaledInstance(87,77,Image.SCALE_DEFAULT));
		JLabel picture = new JLabel(icon);
		picture.setOpaque(true);
		picture.setBounds(120,26,87,77);
		contentPane.add(picture,new Integer(Integer.MIN_VALUE));
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/13.png"));
		
		JLabel jlpic = new JLabel();
		ImageIcon icon3 = new ImageIcon("images/19.jpg");  
        icon3.setImage(icon3.getImage().getScaledInstance(575,  
                381, Image.SCALE_DEFAULT));  
        //System.out.println(icon3.getIconHeight() + "" + icon3.getIconWidth());  
        jlpic.setBounds(0, 0,575,381);  
        jlpic.setHorizontalAlignment(0);  
        jlpic.setIcon(icon3);  
        getContentPane().add(jlpic);  
	}
}

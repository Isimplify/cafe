package Panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import source.Manager_UI;
import DataBaseUtil.ConnectDataBase;

public class employee_item extends JPanel {

	private JPanel contentPane;

	

	/**
	 * Create the panel.
	 */
	int id;
	String name;
	String sex;
	int age;
	String tel;
	int pid;
	public employee_item(int id, String name, String sex, int age, String tel, int pid) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.pid = pid;
		setLayout(null);
		JFormattedTextField Jid = new JFormattedTextField();
		Jid.setHorizontalAlignment(SwingConstants.CENTER);
		Jid.setBounds(5, 5, 40, 35);
		Jid.setEditable(false);
		Jid.setText(""+id);
		add(Jid);
		
		JFormattedTextField Jname = new JFormattedTextField();
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(45, 5, 60, 35);
		Jname.setEditable(false);
		Jname.setText(name);
		add(Jname);
		
		
		JFormattedTextField Jsex = new JFormattedTextField();
		Jsex.setHorizontalAlignment(SwingConstants.CENTER);
		Jsex.setBounds(105, 5, 40, 35);
		Jsex.setEditable(false);
		Jsex.setText("" + sex);
		add(Jsex);
		
		JFormattedTextField Jage = new JFormattedTextField();
		Jage.setHorizontalAlignment(SwingConstants.CENTER);
		Jage.setBounds(145, 5, 40, 35);
		Jage.setEditable(false);
		Jage.setText(""+ age);
		add(Jage);
		
		JFormattedTextField Jtel = new JFormattedTextField();
		Jtel.setHorizontalAlignment(SwingConstants.CENTER);
		Jtel.setBounds(185, 5, 70, 35);
		Jtel.setEditable(false);
		Jtel.setText(""+ tel);
		add(Jtel);
		
		JFormattedTextField Jpid = new JFormattedTextField();
		Jpid.setHorizontalAlignment(SwingConstants.CENTER);
		Jpid.setBounds(255, 5, 40, 35);
		Jpid.setEditable(false);
		Jpid.setText(""+ pid);
		add(Jpid);
		
		
		
		JButton modify = new JButton("修改");
		modify.setFont(new Font("黑体", Font.PLAIN, 12));
		modify.setBounds(335, 5, 60, 35);
		modify.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
			       if(arg0.getActionCommand().equals("修改")){
			       	modify.setText("保存");
			       	//Jid.setEditable(true);
			       	Jname.setEditable(true);
			       	Jsex.setEditable(true);
			       	Jage.setEditable(true);
			       	Jtel.setEditable(true);
			       	Jpid.setEditable(true);
			       }
			       else if(arg0.getActionCommand().equals("保存")){
			       	modify.setText("修改");
			       	Jname.setEditable(false);
			       	Jsex.setEditable(false);
			       	Jage.setEditable(false);
			       	Jtel.setEditable(false);
			       	Jpid.setEditable(false);
			       	String SQLstatement = "Update employee set w_name = ' "+ Jname.getText()
			       			+ " ' ,w_sex = ' "+ Jsex.getText()
			       			+ " ' ,w_age=' " + Jage.getText()
			       			+ " ' ,w_tel=' " + Jtel.getText()
			       			+ " ' ,w_password=' " + Jpid.getText()
			       			+ " '  where w_id = " + id;
			       	try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
			       }
		       }
		} );
		add(modify);
		
		JButton delete = new JButton("删除");
		delete.setBounds(405, 5, 60, 35);
		delete.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
		       	int rt = JOptionPane.showConfirmDialog(null,"确认要删除吗？","删除",JOptionPane.YES_NO_OPTION);
		       	if (rt == 0){
		       		String SQLstatement = "delete from employee where w_id = " + id;
		       		try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
		       		Manager_UI.showMap("employee");
		       	}
		       }
		} );
		add(delete);
		this.setVisible(true);
	}
	

}

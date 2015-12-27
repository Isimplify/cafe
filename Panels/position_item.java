package Panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import source.Manager_UI;
import DataBaseUtil.ConnectDataBase;

public class position_item extends JPanel {

	/**
	 * Create the panel.
	 */
	int id;
	String position;
	int salary;
	public position_item(int id, String position, int salary) {
		this.id = id;
		this.position = position;
		this.salary = salary;
		setLayout(null);
		JFormattedTextField Jid = new JFormattedTextField();
		Jid.setHorizontalAlignment(SwingConstants.CENTER);
		Jid.setBounds(5, 5, 70, 35);
		Jid.setEditable(false);
		Jid.setText(""+id);
		add(Jid);
		
		JFormattedTextField Jposition = new JFormattedTextField();
		Jposition.setHorizontalAlignment(SwingConstants.CENTER);
		Jposition.setBounds(75, 5, 100, 35);
		Jposition.setEditable(false);
		Jposition.setText("" + position);
		add(Jposition);
		
		
		JFormattedTextField Jsalary = new JFormattedTextField();
		Jsalary.setHorizontalAlignment(SwingConstants.CENTER);
		Jsalary.setBounds(175, 5, 70, 35);
		Jsalary.setEditable(false);
		Jsalary.setText("" + salary);
		add(Jsalary);
		
		
		
		
		JButton modify = new JButton("修改");
		modify.setFont(new Font("黑体", Font.PLAIN, 12));
		modify.setBounds(335, 5, 60, 35);
		modify.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
			       if(arg0.getActionCommand().equals("修改")){
			       	modify.setText("保存");
			       	//Jid.setEditable(true);
			       	Jid.setEditable(true);
			       	Jposition.setEditable(true);
			       	Jsalary.setEditable(true);
			       }
			       else if(arg0.getActionCommand().equals("保存")){
			       	modify.setText("修改");
			       	Jid.setEditable(false);
			       	Jposition.setEditable(false);
			       	Jsalary.setEditable(false);
			       	String SQLstatement = "Update new_schema1.position set p_name = ' "+ Jposition.getText()
			       			+ " ' ,p_salary = ' "+ Jsalary.getText()
			       			+ " '  where p_id = " + id;
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
		       		String SQLstatement = "delete from position where p_id = " + id ;
		       		try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
		       		Manager_UI.showMap("position");
		       	}
		       }
		} );
		add(delete);
		this.setVisible(true);
	}
}

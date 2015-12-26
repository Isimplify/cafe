package Panels;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;

import DataBaseUtil.ConnectDataBase;
import source.Manager_UI;

public class supplier_item extends JPanel {

	/**
	 * Create the panel.
	 */
	int id;
	String name;
	String city; 
	String tele;
	public supplier_item(int id, String name,  String city, String tele) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.tele = tele;
		setLayout(null);
		JFormattedTextField Jid = new JFormattedTextField();
		Jid.setHorizontalAlignment(SwingConstants.CENTER);
		Jid.setBounds(5, 5, 50, 35);
		Jid.setEditable(false);
		Jid.setText(""+id);
		add(Jid);
		
		JFormattedTextField Jname = new JFormattedTextField();
		Jname.setHorizontalAlignment(SwingConstants.CENTER);
		Jname.setBounds(55, 5, 80, 35);
		Jname.setEditable(false);
		Jname.setText(name);
		add(Jname);
		
		
		JFormattedTextField Jcity = new JFormattedTextField();
		Jcity.setHorizontalAlignment(SwingConstants.CENTER);
		Jcity.setBounds(135, 5, 70, 35);
		Jcity.setEditable(false);
		Jcity.setText(city);
		add(Jcity);
		
		JFormattedTextField Jtel = new JFormattedTextField();
		Jtel.setHorizontalAlignment(SwingConstants.CENTER);
		Jtel.setBounds(205, 5, 100, 35);
		Jtel.setEditable(false);
		Jtel.setText(tele);
		add(Jtel);
		
		
		JButton modify = new JButton("修改");
		modify.setFont(new Font("黑体", Font.PLAIN, 12));
		modify.setBounds(335, 5, 60, 35);
		modify.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
			       if(arg0.getActionCommand().equals("修改")){
			       	modify.setText("保存");
			       	//Jid.setEditable(true);
			       	Jname.setEditable(true);
			       	Jcity.setEditable(true);
			       	Jtel.setEditable(true);
			       }
			       else if(arg0.getActionCommand().equals("保存")){
			       	modify.setText("修改");
			       	Jname.setEditable(false);
			       	Jcity.setEditable(false);
			       	Jtel.setEditable(false);
			       	String SQLstatement = "Update new_schema1.supplier set s_name = ' "+ Jname.getText()
			       			+ " ' ,s_addr = ' "+ Jcity.getText()
			       			+ " ' ,s_tele=' " + Jtel.getText()
			       			+ " '  where s_id = " + id;
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
		       		String SQLstatement = "delete from supplier where s_id = " + id;
		       		try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
		       		Manager_UI.showMap("supplier");
		       	}
		       }
		} );
		add(delete);
		this.setVisible(true);
	}
}


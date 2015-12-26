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

public class coffee_item extends JPanel {

	/**
	 * Create the panel.
	 */
	
	int id;
	String name;
	double price;
	int num;
	public coffee_item(int id, String name, double price, int num) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
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
		
		
		JFormattedTextField Jprice = new JFormattedTextField();
		Jprice.setHorizontalAlignment(SwingConstants.CENTER);
		Jprice.setBounds(135, 5, 70, 35);
		Jprice.setEditable(false);
		Jprice.setText("" + Jprice);
		add(Jprice);
		
		JFormattedTextField Jnum = new JFormattedTextField();
		Jnum.setHorizontalAlignment(SwingConstants.CENTER);
		Jnum.setBounds(205, 5, 70, 35);
		Jnum.setEditable(false);
		Jnum.setText("" + Jnum);
		add(Jnum);
		
		JButton modify = new JButton("修改");
		modify.setFont(new Font("黑体", Font.PLAIN, 12));
		modify.setBounds(335, 5, 60, 35);
		modify.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
			       if(arg0.getActionCommand().equals("修改")){
			       	modify.setText("保存");
			       	//Jid.setEditable(true);
			       	Jname.setEditable(true);
			       	Jprice.setEditable(true);
			       }
			       else if(arg0.getActionCommand().equals("保存")){
			       	modify.setText("修改");
			       	Jname.setEditable(false);
			       	Jprice.setEditable(false);
			       	String SQLstatement = "Update coffee set c_name = ' "+ Jname.getText()
			       			+ " ' ,c_price = ' "+ Jprice.getText()
			       			+ " ' ,c_num = ' " + Jnum.getText()
			       			+ " '  where c_id = " + id;
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
		       	}
		       	Manager_UI.showMap("coffee");
		       }
		} );
		add(delete);
		this.setVisible(true);
	}

}

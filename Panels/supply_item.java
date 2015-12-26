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

public class supply_item extends JPanel {

	/**
	 * Create the panel.
	 */
	int supply_id;
	int supplier_id;
	int material_id;
	int amount;
	int price;
	public supply_item(int supply_id, int supplier_id,	int material_id, int amount, int price) {
		this.supply_id = supplier_id;
		this.supplier_id = supplier_id;
		this.material_id = material_id;
		this.amount = amount;
		this.price = price;
		setLayout(null);
		JFormattedTextField Jsuid = new JFormattedTextField();
		Jsuid.setHorizontalAlignment(SwingConstants.CENTER);
		Jsuid.setBounds(5, 5, 40, 35);
		Jsuid.setEditable(false);
		Jsuid.setText(""+supply_id);
		add(Jsuid);
		
		JFormattedTextField Jsid = new JFormattedTextField();
		Jsid.setHorizontalAlignment(SwingConstants.CENTER);
		Jsid.setBounds(45, 5, 40, 35);
		Jsid.setEditable(false);
		Jsid.setText(""+supplier_id);
		add(Jsid);
		
		JFormattedTextField Jmid = new JFormattedTextField();
		Jmid.setHorizontalAlignment(SwingConstants.CENTER);
		Jmid.setBounds(85, 5, 40, 35);
		Jmid.setEditable(false);
		Jmid.setText(""+material_id);
		add(Jmid);
		
		JFormattedTextField Jamount = new JFormattedTextField();
		Jamount.setHorizontalAlignment(SwingConstants.CENTER);
		Jamount.setBounds(125, 5, 80, 35);
		Jamount.setEditable(false);
		Jamount.setText(""+amount);
		add(Jamount);
		
		JFormattedTextField Jprice = new JFormattedTextField();
		Jprice.setHorizontalAlignment(SwingConstants.CENTER);
		Jprice.setBounds(205, 5, 80, 35);
		Jprice.setEditable(false);
		Jprice.setText(""+price);
		add(Jprice);
		
		
		
		
		
		JButton modify = new JButton("修改");
		modify.setFont(new Font("黑体", Font.PLAIN, 12));
		modify.setBounds(335, 5, 60, 35);
		modify.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
			       if(arg0.getActionCommand().equals("修改")){
			       	modify.setText("保存");
			       	//Jid.setEditable(true);
			       	Jsid.setEditable(true);
			       	Jmid.setEditable(true);
			       }
			       else if(arg0.getActionCommand().equals("保存")){
			       	modify.setText("修改");
			       	Jsid.setEditable(false);
			       	Jmid.setEditable(false);
			       	String SQLstatement = "Update new_schema1.supply set supplier_id = ' "+ Jsid.getText()
			       			+ " ' ,material_id = ' "+ Jmid.getText()
			       			+ " ' ,amount = ' "+ Jamount.getText()
			       			+ " ' ,price = ' "+ Jprice.getText()
			       			+ " '  where su_id = " + Jsuid.getText();
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
		       		String SQLstatement = "delete from supply where su_id = " + supply_id ;
		       		try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
		       		Manager_UI.showMap("supply");
		       		
		       	}
		       }
		} );
		add(delete);
		this.setVisible(true);
	}

}

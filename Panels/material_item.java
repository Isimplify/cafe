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

public class material_item extends JPanel {

	/**
	 * Create the panel.
	 */
	int id;
	String name;
	int inventory;
	public material_item(int id, String name, int inventory) {
		this.id = id;
		this.name = name;
		this.inventory = inventory;
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
		
		
		JFormattedTextField Jinventory = new JFormattedTextField();
		Jinventory.setHorizontalAlignment(SwingConstants.CENTER);
		Jinventory.setBounds(135, 5, 70, 35);
		Jinventory.setEditable(false);
		Jinventory.setText(""+inventory);
		add(Jinventory);
		
		JButton modify = new JButton("修改");
		modify.setFont(new Font("黑体", Font.PLAIN, 12));
		modify.setBounds(335, 5, 60, 35);
		modify.addActionListener(new ActionListener(){
		       public void actionPerformed(ActionEvent arg0) {
			       if(arg0.getActionCommand().equals("修改")){
			       	modify.setText("保存");
			       	//Jid.setEditable(true);
			       	Jname.setEditable(true);
			       	Jinventory.setEditable(true);
			       }
			       else if(arg0.getActionCommand().equals("保存")){
			       	modify.setText("修改");
			       	Jname.setEditable(false);
			       	Jinventory.setEditable(false);
			       	String SQLstatement = "Update material set m_name = ' "+ Jname.getText()
			       			+ " ' ,m_inventory = ' "+ Jinventory.getText()
			       			+ " '  where m_id = " + id;
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
		       		String SQLstatement = "delete from material where m_id = " + id;
		       		try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
		       		Manager_UI.showMap("material");
		       	}
		       }
		} );
		add(delete);
		this.setVisible(true);
	}
	
}

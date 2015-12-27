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

public class recipe_item extends JPanel {

	/**
	 * Create the panel.
	 */
	int coffee_id;
	int material_id;
	int dosage;
	recipe_item recipe_item_obj = this;
	public recipe_item(int coffee_id, int material_id, int dosage) {
		this.coffee_id = coffee_id;
		this.material_id = material_id;
		this.dosage = dosage;
		setLayout(null);

		JFormattedTextField Jcid = new JFormattedTextField();
		Jcid.setHorizontalAlignment(SwingConstants.CENTER);
		Jcid.setBounds(5, 5, 80, 35);
		Jcid.setEditable(false);
		Jcid.setText("" + coffee_id);
		add(Jcid);
		
		JFormattedTextField Jmid = new JFormattedTextField();
		Jmid.setHorizontalAlignment(SwingConstants.CENTER);
		Jmid.setBounds(85, 5, 80, 35);
		Jmid.setEditable(false);
		Jmid.setText(""+material_id);
		add(Jmid);
		
		JFormattedTextField Jdosage = new JFormattedTextField();
		Jdosage.setHorizontalAlignment(SwingConstants.CENTER);
		Jdosage.setBounds(165, 5, 80, 35);
		Jdosage.setEditable(false);
		Jdosage.setText("" + dosage);
		add(Jdosage);
		
		
		
		
		JButton modify = new JButton("修改");
		modify.setFont(new Font("黑体", Font.PLAIN, 12));
		modify.setBounds(335, 5, 60, 35);
		modify.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			       if(arg0.getActionCommand().equals("修改")){
			       	modify.setText("保存");
			       	//Jid.setEditable(true);
			       	Jmid.setEditable(true);
			       	Jcid.setEditable(true);
			       	Jdosage.setEditable(true);
			       }
			       else if(arg0.getActionCommand().equals("保存")){
			       	modify.setText("修改");
			       	Jmid.setEditable(false);
			       	Jcid.setEditable(false);
			       	Jdosage.setEditable(false);

			       	String SQLstatement = "Update new_schema1.recipe set c_id = ' "+ Jcid.getText()
			       			+ " ' ,m_id = ' "+ Jmid.getText()
			       			+ " ' ,dosage=' " + Jdosage.getText()
			       			+ " '  where c_id = " + recipe_item_obj.coffee_id + " and m_id = " + recipe_item_obj.material_id;

			       	try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
			       	recipe_item_obj.coffee_id = Integer.parseInt( Jcid.getText() );
			       	recipe_item_obj.material_id = Integer.parseInt( Jmid.getText() );
			 
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

		       		String SQLstatement = "delete from recipe where _id = " + recipe_item_obj.coffee_id + " and m_id = " + recipe_item_obj.material_id;

		       		try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
		       		Manager_UI.showMap("recipe");
		       	}
		       }
		} );
		add(delete);
		this.setVisible(true);
	}

}

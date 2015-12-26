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
	int material_id;
	int coffee_id;
	int dosage;
	public recipe_item(int coffee_id, int material_id, int dosage) {
		this.material_id = material_id;
		this.coffee_id = coffee_id;
		this.dosage = dosage;
		setLayout(null);
		JFormattedTextField Jmid = new JFormattedTextField();
		Jmid.setHorizontalAlignment(SwingConstants.CENTER);
		Jmid.setBounds(5, 5, 50, 35);
		Jmid.setEditable(false);
		Jmid.setText(""+Jmid);
		add(Jmid);
		
		JFormattedTextField Jcid = new JFormattedTextField();
		Jcid.setHorizontalAlignment(SwingConstants.CENTER);
		Jcid.setBounds(55, 5, 80, 35);
		Jcid.setEditable(false);
		Jcid.setText("" + Jcid);
		add(Jcid);
		
		
		JFormattedTextField Jdosage = new JFormattedTextField();
		Jdosage.setHorizontalAlignment(SwingConstants.CENTER);
		Jdosage.setBounds(135, 5, 70, 35);
		Jdosage.setEditable(false);
		Jdosage.setText("" + Jdosage);
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
			       	String SQLstatement = "Update new_schema1.recipe set m_id = ' "+ Jmid.getText()
			       			+ " ' ,c_id = ' "+ Jcid.getText()
			       			+ " ' ,dosage=' " + Jdosage.getText()
			       			+ " '  where m_id = " + material_id + "and c_id = " + coffee_id;
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
		       		String SQLstatement = "delete from recipe where m_id = " + material_id + "and c_id = " + coffee_id;
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

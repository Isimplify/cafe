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

public class consumer_item extends JPanel {

	/**
	 * Create the panel.
	 */
	
	String id;
	String name;
	String sex;
	double consume;
	int ifMember;
	double consume_total;
	
	public consumer_item(String id, String name, String sex, double consume, int ifMember, double consume_total) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.consume = consume;
		this.ifMember = ifMember;
		this.consume_total = consume_total;
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
		Jsex.setText(sex);
		add(Jsex);
		
		JFormattedTextField Jconsume = new JFormattedTextField();
		Jconsume.setHorizontalAlignment(SwingConstants.CENTER);
		Jconsume.setBounds(145, 5, 70, 35);
		Jconsume.setEditable(false);
		Jconsume.setText(""+consume);
		add(Jconsume);
		
		JFormattedTextField JifMember = new JFormattedTextField();
		JifMember.setHorizontalAlignment(SwingConstants.CENTER);
		JifMember.setBounds(215, 5, 40, 35);
		JifMember.setEditable(false);
		JifMember.setText(""+ifMember);
		add(JifMember);
		
		JFormattedTextField Jconsume_total = new JFormattedTextField();
		Jconsume_total.setHorizontalAlignment(SwingConstants.CENTER);
		Jconsume_total.setBounds(255, 5, 70, 35);
		Jconsume_total.setEditable(false);
		Jconsume_total.setText(""+consume_total);
		add(Jconsume_total);
		
		
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
			       	Jconsume.setEditable(true);
			       	JifMember.setEditable(true);
			       	Jconsume_total.setEditable(true);
			       }
			       else if(arg0.getActionCommand().equals("保存")){
			       	modify.setText("修改");
			       	Jname.setEditable(false);
			       	Jsex.setEditable(false);
			       	Jconsume.setEditable(false);
			       	JifMember.setEditable(false);
			       	Jconsume_total.setEditable(false);
			       	String SQLstatement = "Update consumer set u_name = ' "+ Jname.getText()
			       			+ " ' ,u_sex = ' "+ Jsex.getText()
			       			+ " ' ,u_comsume=' " + Jconsume.getText()
			       			+ " ' ,ifMember=' " + JifMember.getText()
			       			+ " ' ,u_comsume_total=' " + Jconsume_total.getText()
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
		       		String SQLstatement = "delete from consumer where s_id = " + id;
		       		try {
	                                   ConnectDataBase.Update(SQLstatement);
                                   } catch (SQLException e) {
	                                   // TODO Auto-generated catch block
	                                   e.printStackTrace();
                                   }
		       		Manager_UI.showMap("consumer");
		       	}
		       }
		} );
		add(delete);
		this.setVisible(true);
	}
}

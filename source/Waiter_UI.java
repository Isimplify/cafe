package source;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTable;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JRadioButton;

public class Waiter_UI extends JFrame {

	private JPanel layout;
	private JTextField Total_money;
	private JTextField coffee_rest_num;
	private JTextField coffee_price;
	private JTable table;
	private JTable table_list;
	private JTextField discount_number;
	private JTextField w_id;
	private JTextField w_name;
	private JTextField customer_id;
	private int total;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Waiter_UI frame = new Waiter_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Waiter_UI(int user_id) {
		setTitle("�µ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 592);
		layout = new JPanel();
		layout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layout);
		layout.setLayout(null);
		
		//��ͷ
		JScrollPane tabletop = new JScrollPane();
		tabletop.setBounds(27, 124, 370, 40);
		layout.add(tabletop);
		DefaultTableModel dt = new DefaultTableModel(null,new String[]{"��������","ʣ������","����","�������"});
		table = new JTable(dt);
		//table.setBounds(27, 10, 371, 39);
		Dimension size = table.getTableHeader().getPreferredSize();
		size.height = 39;//�����µı�ͷ�߶�40
		table.getTableHeader().setPreferredSize(size);
		int[] width={147,90,90,90};
		//table.setColumnModel(getColumn(table, width));
		TableColumnModel columns = table.getTableHeader().getColumnModel();  
		for (int i = 0; i < width.length; i++) {  
		    TableColumn column = columns.getColumn(i);  
		       column.setPreferredWidth(width[i]);  
	    }  
		table.getTableHeader().setColumnModel(columns);
		table.setFont(new Font("����", Font.PLAIN, 13));
		table.setForeground(Color.BLACK);
		table.setFillsViewportHeight(true);
		tabletop.setViewportView(table);
		
		JComboBox coffee_type = new JComboBox();
		coffee_type.setBounds(27, 163, 130, 32);
		coffee_type.setFont(new Font("����", Font.PLAIN, 15));
		layout.add(coffee_type);
		String SQLstatement = "select c_name from coffee";
		ResultSet rs = DataBaseUtil.ConnectDataBase.Select(SQLstatement);
		try{
			while(rs.next()){
				coffee_type.addItem(rs.getString(1));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		coffee_rest_num = new JTextField();
		coffee_rest_num.setBounds(157, 163, 80, 32);
		layout.add(coffee_rest_num);
		coffee_rest_num.setColumns(10);
		coffee_rest_num.setText("10");
		coffee_rest_num.setHorizontalAlignment(JTextField.CENTER);
		coffee_rest_num.setEditable(false);
		
		coffee_price = new JTextField();
		coffee_price.setColumns(10);
		coffee_price.setBounds(236, 163, 81, 32);
		layout.add(coffee_price);
		coffee_price.setHorizontalAlignment(JTextField.CENTER);
		coffee_price.setText("10");
		coffee_price.setEditable(false);
		
		JComboBox add_num = new JComboBox();
		add_num.setBounds(315, 163, 81, 32);
		layout.add(add_num);
		
		//���ݿ����������õ���ͬ������
		coffee_type.addItemListener(
				new ItemListener(){

					@Override
					public void itemStateChanged(ItemEvent e) {
						String coffee_name = coffee_type.getSelectedItem().toString();
						@SuppressWarnings("unused")
						String SQLstatement = "select c_num,c_price from coffee where c_name = '"
								+ coffee_name +"'";
						ResultSet rs = DataBaseUtil.ConnectDataBase.Select(SQLstatement);
						try{
							while(rs.next()){
								add_num.removeAllItems();
								coffee_rest_num.setText(rs.getInt(1) + "");
								coffee_rest_num.setHorizontalAlignment(JTextField.CENTER);
								coffee_price.setText(rs.getInt(2) + "");
								coffee_price.setHorizontalAlignment(JTextField.CENTER);
								for(int i = 0;i <= Integer.parseInt(coffee_rest_num.getText());i++)
									add_num.addItem(i);
							}
						}
						catch(SQLException e1){
							e1.printStackTrace();
						}
					}
			
		});
		
		//���ö�������
		JScrollPane order_list = new JScrollPane();
		order_list.setBounds(10, 251, 555, 229);
		order_list.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		layout.add(order_list);
		DefaultTableModel dt1 = new DefaultTableModel(null,
				new String[]{"��������","����","����","���(Ԫ)","����"});
		table_list = new JTable(dt1){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.setFillsViewportHeight(true);
		order_list.setViewportView(table_list);
		//�����µı�ͷ�߶�40
		Dimension size1 = table_list.getTableHeader().getPreferredSize();
		size1.height = 39;
		table_list.getTableHeader().setPreferredSize(size1);
		//���ñ�ͷ�Ŀ��
		int[] width1={147,90,90,90,90};
		TableColumnModel columns1 = table_list.getTableHeader().getColumnModel();  
		for (int i = 0; i < width.length; i++) {  
		    TableColumn column = columns1.getColumn(i);  
		       column.setPreferredWidth(width[i]);  
	    }  
		table_list.getTableHeader().setColumnModel(columns1);
		//����table���и�
		table_list.setRowHeight(40);
		//����table�е��������
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		table_list.setDefaultRenderer(Object.class,r);

		total = 0;
		
		//�ۿ�text
				discount_number = new JTextField();
				discount_number.setBounds(262, 210, 74, 25);
				layout.add(discount_number);
				discount_number.setColumns(10);
				discount_number.setHorizontalAlignment(JTextField.CENTER);
				discount_number.setEditable(false);
				
		//�ܼƽ��text
				Total_money = new JTextField();
				Total_money.setBounds(118, 501, 74, 27);
				Total_money.setToolTipText("total_money");
				layout.add(Total_money);
				Total_money.setColumns(10);
				Total_money.setHorizontalAlignment(JTextField.CENTER);
				Total_money.setEditable(false);
				
		//���button
		JButton add_order = new JButton("���");
		add_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//objectת��Ϊint
				if(add_num.getSelectedItem() == null ){
					JOptionPane.showMessageDialog(null, "�µ���������Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				}
				else{
					int num = Integer.parseInt(String.valueOf(add_num.getSelectedItem()));
					if(num == 0){
						JOptionPane.showMessageDialog(null, coffee_type.getSelectedItem() +"�Ѿ�����", "����", JOptionPane.ERROR_MESSAGE);
					}
					else{
						int price = Integer.parseInt(coffee_price.getText());
						String SQLstatement = "select c_num,c_id from coffee where c_name = '" + coffee_type.getSelectedItem() + "'";
						ResultSet rs = DataBaseUtil.ConnectDataBase.Select(SQLstatement);
						try {
							if(rs.next()){
								int coffee_rn = rs.getInt(1) - num;
								String SQLstatement2 = "update coffee  set c_num  = "+ coffee_rn + " where c_id = "
								+ rs.getInt(2) ;
								DataBaseUtil.ConnectDataBase.Update(SQLstatement2);
								coffee_rest_num.setText(coffee_rn+"");
								int money = num * price;
								if(!(discount_number.getText().equals("��"))){
									money = (int) (money * 0.7);
								}
								total = total + money;
								Total_money.setText(total+"");
								//��������ӵ�table��
								dt1.addRow(new Object[]{coffee_type.getSelectedItem(),
										add_num.getSelectedItem(),coffee_price.getText(),money,"ɾ��"});
								table_list.setModel(dt1);
								add_num.removeAllItems();
								for(int i = 0;i <= coffee_rn;i++)
									add_num.addItem(i);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		add_order.setBounds(457, 163, 93, 32);
		layout.add(add_order);
		
		
		JLabel label_discount = new JLabel("�ۿۣ�");
		label_discount.setFont(new Font("����", Font.PLAIN, 15));
		label_discount.setBounds(218, 206, 61, 30);
		layout.add(label_discount);
		
		
		//������Ƭ
		ImageIcon icon=new ImageIcon("images/11.jpg");
		icon.setImage(icon.getImage().getScaledInstance(116,128,Image.SCALE_DEFAULT));
		JLabel picture = new JLabel(icon);
		picture.setOpaque(true);
		picture.setBounds(438,10,116,128);
		layout.add(picture,new Integer(Integer.MIN_VALUE));
		
		
		
		JLabel w_id_label = new JLabel("Ա�����");
		w_id_label.setFont(new Font("����", Font.PLAIN, 15));
		w_id_label.setBounds(45, 59, 69, 23);
		layout.add(w_id_label);
		
		JLabel w_name_label = new JLabel("Ա������");
		w_name_label.setFont(new Font("����", Font.PLAIN, 15));
		w_name_label.setBounds(218, 59, 72, 23);
		layout.add(w_name_label);
		
		//Ա������
		w_name = new JTextField();
		w_name.setColumns(10);
		w_name.setBounds(283, 57, 74, 27);
		layout.add(w_name);
		w_name.setEditable(false);
		w_name.setHorizontalAlignment(JTextField.CENTER);
		
		//�Զ���ȡԱ�����
		w_id = new JTextField();
		w_id.setBounds(106, 57, 74, 27);
		layout.add(w_id);
		w_id.setColumns(10);
		w_id.setEditable(false);
		w_id.setHorizontalAlignment(JTextField.CENTER);
		w_id.setText(user_id+"");
		String SQLstatement1 = "select w_name from employee where w_id = " + user_id;
		ResultSet rs1 = DataBaseUtil.ConnectDataBase.Select(SQLstatement1);
		try {
			if(rs1.next()){
				w_name.setText(rs1.getString(1));
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		customer_id = new JTextField();
		customer_id.setColumns(10);
		customer_id.setBounds(102, 209, 74, 25);
		layout.add(customer_id);
		customer_id.setHorizontalAlignment(JTextField.CENTER);
		customer_id.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int user_id = Integer.parseInt(customer_id.getText());
				String SQLstatement = "select u_ifMem from user where u_id = "
						+ user_id;
				ResultSet rs = DataBaseUtil.ConnectDataBase.Select(SQLstatement);
				try {
					if(rs.next()){
						int if_member = rs.getInt(1);
						if(if_member == 1){
							discount_number.setText("7��");
						}
						else{
							discount_number.setText("��");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "�û���������", "����", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
		JLabel label_customer_id = new JLabel("\u987E\u5BA2\u7F16\u53F7\uFF1A");
		label_customer_id.setFont(new Font("����", Font.PLAIN, 15));
		label_customer_id.setBounds(27, 205, 87, 30);
		layout.add(label_customer_id);
		
		JLabel total_money_label = new JLabel("\u603B\u91D1\u989D");
		total_money_label.setBounds(67, 501, 90, 27);
		total_money_label.setFont(new Font("����", Font.PLAIN, 15));
		layout.add(total_money_label);
				
		JButton btnNewButton = new JButton("�ύ����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rt = JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�ύ������","�ύ����",JOptionPane.YES_NO_OPTION);
				if(rt == 0){
					total = 0;
					Total_money.setText(total+"");
					//int row = table_list.getRowCount();
					//int total = 0; //�ܼ�
					//for(int i = 0;i < row;i++)
					//	total = total + Integer.parseInt(String.valueOf(table_list.getValueAt(i, 3)));
					//Total_money.setText(total+"");
					//for(int i = 0;i < row;i++)
						//table_list.remover
					dt1.setRowCount(0);
					table_list.setModel(dt1);
					Total_money.setText(null);
				}
			}
			
		});
		btnNewButton.setBounds(411, 490, 93, 39);
		layout.add(btnNewButton);
		
		JLabel label_1 = new JLabel("(\u5143)");
		label_1.setFont(new Font("����", Font.PLAIN, 15));
		label_1.setBounds(200, 501, 90, 27);
		layout.add(label_1);
		
		
		
	}
}

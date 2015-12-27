package source;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
import javax.swing.Timer;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.*;

import javax.swing.JRadioButton;
import javax.swing.JProgressBar;

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
	private JTextField time;
	private Vector money_list;

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
	public Waiter_UI(String user_id) {
		money_list = new Vector();
		setTitle("下单");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 657);
		layout = new JPanel();
		layout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layout);
		layout.setLayout(null);
		
		//表头
		JScrollPane tabletop = new JScrollPane();
		tabletop.setBounds(27, 166, 370, 40);
		layout.add(tabletop);
		DefaultTableModel dt = new DefaultTableModel(null,new String[]{"咖啡种类","剩余数量","单价","点餐数量"});
		table = new JTable(dt);
		//table.setBounds(27, 10, 371, 39);
		Dimension size = table.getTableHeader().getPreferredSize();
		size.height = 39;//设置新的表头高度40
		table.getTableHeader().setPreferredSize(size);
		int[] width={147,90,90,90};
		//table.setColumnModel(getColumn(table, width));
		TableColumnModel columns = table.getTableHeader().getColumnModel();  
		for (int i = 0; i < width.length; i++) {  
		    TableColumn column = columns.getColumn(i);  
		       column.setPreferredWidth(width[i]);  
	    }  
		table.getTableHeader().setColumnModel(columns);
		table.setFont(new Font("宋体", Font.PLAIN, 13));
		table.setForeground(Color.BLACK);
		table.setFillsViewportHeight(true);
		tabletop.setViewportView(table);
		
		JComboBox coffee_type = new JComboBox();
		coffee_type.setBounds(27, 205, 130, 32);
		coffee_type.setFont(new Font("宋体", Font.PLAIN, 15));
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
		coffee_rest_num.setBounds(157, 205, 80, 32);
		layout.add(coffee_rest_num);
		coffee_rest_num.setColumns(10);
		coffee_rest_num.setText("10");
		coffee_rest_num.setHorizontalAlignment(JTextField.CENTER);
		coffee_rest_num.setEditable(false);
		
		coffee_price = new JTextField();
		coffee_price.setColumns(10);
		coffee_price.setBounds(236, 205, 81, 32);
		layout.add(coffee_price);
		coffee_price.setHorizontalAlignment(JTextField.CENTER);
		coffee_price.setText("10");
		coffee_price.setEditable(false);
		
		JComboBox add_num = new JComboBox();
		add_num.setBounds(315, 205, 81, 32);
		layout.add(add_num);
		
		//根据咖啡种类来得到不同的数据
		coffee_type.addActionListener (new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String coffee_name = coffee_type.getSelectedItem().toString();
						//@SuppressWarnings("unused")
						String SQLstatement = "select c_num,c_price from coffee where c_name = '"
								+ coffee_name +"'";
						ResultSet rs = DataBaseUtil.ConnectDataBase.Select(SQLstatement);
						try{
							if(rs.next()){
								int coffee_num = rs.getInt(1);
								add_num.removeAllItems();
								coffee_rest_num.setText(coffee_num + "");
								coffee_rest_num.setHorizontalAlignment(JTextField.CENTER);
								coffee_price.setText(rs.getInt(2) + "");
								coffee_price.setHorizontalAlignment(JTextField.CENTER);
								for(int i = 0;i <= coffee_num;i++)
									add_num.addItem(i);
							}
						}
						catch(SQLException e1){
							e1.printStackTrace();
						}
					}
			
		});
		
		//设置订单界面
		JScrollPane order_list = new JScrollPane();
		order_list.setBounds(10, 314, 582, 229);
		order_list.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		layout.add(order_list);
		DefaultTableModel dt1 = new DefaultTableModel(null,
				new String[]{"咖啡种类","数量","单价","金额(元)"});
		table_list = new JTable(dt1){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.setFillsViewportHeight(true);
		order_list.setViewportView(table_list);
		//设置新的表头高度40
		Dimension size1 = table_list.getTableHeader().getPreferredSize();
		size1.height = 39;
		table_list.getTableHeader().setPreferredSize(size1);
		//设置表头的宽度
		int[] width1={147,90,90,90};
		TableColumnModel columns1 = table_list.getTableHeader().getColumnModel();  
		for (int i = 0; i < width.length; i++) {  
		    TableColumn column = columns1.getColumn(i);  
		       column.setPreferredWidth(width[i]);  
	    }  
		table_list.getTableHeader().setColumnModel(columns1);
		//设置table的行高
		table_list.setRowHeight(40);
		//设置table中的字体居中
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		table_list.setDefaultRenderer(Object.class,r);

		total = 0;
		
		//折扣text
				discount_number = new JTextField();
				discount_number.setBounds(262, 256, 74, 25);
				layout.add(discount_number);
				discount_number.setColumns(10);
				discount_number.setHorizontalAlignment(JTextField.CENTER);
				discount_number.setEditable(false);
				
		//总计金额text
				Total_money = new JTextField();
				Total_money.setBounds(121, 564, 74, 27);
				Total_money.setToolTipText("total_money");
				layout.add(Total_money);
				Total_money.setColumns(10);
				Total_money.setHorizontalAlignment(JTextField.CENTER);
				Total_money.setEditable(false);
				
		//添加button
		JButton add_order = new JButton("添加");
		add_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//object转换为int
				if(add_num.getSelectedItem() == null ){
					JOptionPane.showMessageDialog(null, "下单数量不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else{
					int num = Integer.parseInt(String.valueOf(add_num.getSelectedItem()));
					if(num == 0){
						JOptionPane.showMessageDialog(null, coffee_type.getSelectedItem() +" 下单量不能为0", "错误", JOptionPane.ERROR_MESSAGE);
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
								String SQLstatement3 = "select m_id , dosage from recipe where c_id =  " + rs.getInt(2);
								ResultSet rs1 = DataBaseUtil.ConnectDataBase.Select(SQLstatement3);
								while(rs1.next()){
									String SQLstatement4 = "update material set m_inventory = m_inventory - " + num 
											+" * " + rs1.getInt(2) + " where m_id = " + rs1.getInt(1);
									DataBaseUtil.ConnectDataBase.Update(SQLstatement4);
								}
								
								coffee_rest_num.setText(coffee_rn+"");
								int money = num * price;
								if(discount_number.getText().equals("7折")){
									money = (int) (money * 0.7);
								}
								//total = Integer.parseInt(Total_money.getText());
								total = total + money;
								Total_money.setText(total+"");
								//将订单添加到table中
								dt1.addRow(new Object[]{coffee_type.getSelectedItem(),
										add_num.getSelectedItem(),coffee_price.getText(),money});
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
		add_order.setBounds(457, 205, 93, 32);
		layout.add(add_order);
		
		
		JLabel label_discount = new JLabel("折扣：");
		label_discount.setFont(new Font("宋体", Font.PLAIN, 15));
		label_discount.setBounds(218, 252, 61, 30);
		layout.add(label_discount);
		
		
		//设置照片
		ImageIcon icon=new ImageIcon("images/14.png");
		icon.setImage(icon.getImage().getScaledInstance(116,128,Image.SCALE_DEFAULT));
		JLabel picture = new JLabel(icon);
		picture.setOpaque(true);
		picture.setBounds(438,10,116,128);
		layout.add(picture,new Integer(Integer.MIN_VALUE));
		
		
		
		JLabel w_id_label = new JLabel("员工编号");
		w_id_label.setFont(new Font("宋体", Font.PLAIN, 15));
		w_id_label.setBounds(215, 92, 69, 23);
		layout.add(w_id_label);
		
		JLabel w_name_label = new JLabel("员工姓名");
		w_name_label.setFont(new Font("宋体", Font.PLAIN, 15));
		w_name_label.setBounds(27, 92, 72, 23);
		layout.add(w_name_label);
		
		//员工名字
		w_name = new JTextField();
		w_name.setColumns(10);
		w_name.setBounds(92, 90, 74, 27);
		layout.add(w_name);
		w_name.setEditable(false);
		w_name.setHorizontalAlignment(JTextField.CENTER);
		
		//自动获取员工编号
		w_id = new JTextField();
		w_id.setBounds(276, 90, 74, 27);
		layout.add(w_id);
		w_id.setColumns(10);
		w_id.setEditable(false);
		w_id.setHorizontalAlignment(JTextField.CENTER);
		w_id.setText(user_id);
		String SQLstatement1 = "select w_name from employee where w_id = '" + user_id + "'";
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
		customer_id.setBounds(102, 255, 74, 25);
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
							discount_number.setText("7折");
						}
						else{
							discount_number.setText("无");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "用户名不存在", "错误", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
		JLabel label_customer_id = new JLabel("\u987E\u5BA2\u7F16\u53F7\uFF1A");
		label_customer_id.setFont(new Font("宋体", Font.PLAIN, 15));
		label_customer_id.setBounds(27, 251, 87, 30);
		layout.add(label_customer_id);
		
		JLabel total_money_label = new JLabel("\u603B\u91D1\u989D");
		total_money_label.setBounds(70, 564, 90, 27);
		total_money_label.setFont(new Font("宋体", Font.PLAIN, 15));
		layout.add(total_money_label);
				
		JButton btnNewButton = new JButton("提交订单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rt = JOptionPane.showConfirmDialog(null,"确认要提交订单吗？","提交订单",JOptionPane.YES_NO_OPTION);
				if(rt == 0){
					money_list.add(total);
					total = 0;
					Total_money.setText(total+"");
					dt1.setRowCount(0);
					table_list.setModel(dt1);
					Total_money.setText(null);
				}
			}
			
		});
		btnNewButton.setBounds(472, 553, 93, 39);
		layout.add(btnNewButton);
		
		JLabel yuan = new JLabel("(\u5143)");
		yuan.setFont(new Font("宋体", Font.PLAIN, 15));
		yuan.setBounds(203, 564, 90, 27);
		layout.add(yuan);
		
		//
		DefaultTableModel model = (DefaultTableModel) table_list.getModel();//获取defaulttablemodel
		JButton delete_button = new JButton("删除");
		delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rt = JOptionPane.showConfirmDialog(null,"确认要删除吗？","删除订单",JOptionPane.YES_NO_OPTION);
				if(rt == 0){
					int row = table_list.getSelectedRow();
					int minus = (int) table_list.getValueAt(row, 3);
					int buy_num = (int) table_list.getValueAt(row, 1);
					String coffee_name = (String) table_list.getValueAt(row, 0);
					String SQLstatement2 = "select c_num,c_id  from coffee  where c_name = '" + coffee_name+"'";
					ResultSet rs = DataBaseUtil.ConnectDataBase.Select(SQLstatement2);
					int coffee_num_old = 0;
					int coffee_id_now = 0;
					try {
						if(rs.next()){
							coffee_id_now = rs.getInt(2);
							coffee_num_old = rs.getInt(1);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String SQLstatement5 = "select m_id , dosage from recipe where c_id = " + coffee_id_now;
					ResultSet rs1 = DataBaseUtil.ConnectDataBase.Select(SQLstatement5);
					try {
						while(rs1.next()){
							String SQLstatement4 = "update material set m_inventory = m_inventory + " + buy_num 
									+" * " + rs1.getInt(2) + " where m_id = " + rs1.getInt(1);
							try {
								DataBaseUtil.ConnectDataBase.Update(SQLstatement4);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					int coffee_num_new = buy_num + coffee_num_old;
					//coffee_rest_num.setText(coffee_num_new+ "");
					int  money = Integer.parseInt(Total_money.getText()) - minus;
					total = money;
					Total_money.setText(money + "");
					String SQLstatement3 = "update coffee  set c_num  = "+ coffee_num_new+ " where c_name =  '"
							+ coffee_name+ "'" ;
					try {
						DataBaseUtil.ConnectDataBase.Update(SQLstatement3);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//add_num.removeAllItems();
					//for(int i = 0;i <= coffee_num_new;i++)
					//	add_num.addItem(i);
					model.removeRow(row);
					table_list.setModel(model);
					
				}
			}
		});
		delete_button.setBounds(457, 252, 93, 32);
		layout.add(delete_button);
		
		JLabel JlTime = new JLabel("New label");
		JlTime.setFont(new Font("宋体", Font.PLAIN, 23));
		JlTime.setBounds(106, 20, 291, 60);
		layout.add(JlTime);
		
		JButton exit = new JButton("退出系统");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rt = JOptionPane.showConfirmDialog(null,"确认要退出吗？","退出系统",JOptionPane.YES_NO_OPTION);
				if(rt == 0){
					int all_money = 0;
					for(int i = 0; i < money_list.size();i++){
						all_money = all_money + Integer.parseInt(String.valueOf(money_list.get(i)));
					}
					new Total_money(all_money);
				}
			}
		});
		exit.setBounds(358, 553, 93, 39);
		layout.add(exit);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 146, 602, 10);
		layout.add(progressBar);
		
		ImageIcon icon2=new ImageIcon("images/10.png");
		icon2.setImage(icon2.getImage().getScaledInstance(71,71,Image.SCALE_DEFAULT));
		JLabel picture2 = new JLabel(icon2);
		picture2.setOpaque(true);
		picture2.setBounds(20,10,71,71);
		layout.add(picture2,new Integer(Integer.MIN_VALUE));
		
		JLabel jlpic = new JLabel();
		ImageIcon icon3 = new ImageIcon("images/6.jpg");  
        icon3.setImage(icon3.getImage().getScaledInstance(icon3.getIconWidth(),  
                icon3.getIconHeight(), Image.SCALE_DEFAULT));  
        //System.out.println(icon3.getIconHeight() + "" + icon3.getIconWidth());  
        jlpic.setBounds(0, 0, 592, 608);  
        jlpic.setHorizontalAlignment(0);  
        jlpic.setIcon(icon3);  
        //layout.add(jlpic);  
        
		ActionListener listener = new ActionListener(){
		            public void actionPerformed(ActionEvent e){
		            	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		                Date date = new Date();  
		                JlTime.setText(format.format(date));    
		                 
			        }
		};
		Timer timer = new Timer(500,listener);	
		timer.start();
		
		//URL url = this.getClass().getResource("/images/8.jpg");
		//Image img = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/13.png"));
	}
}

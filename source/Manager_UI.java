package source;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import Panels.coffee_title;
import Panels.consumer_title;
import Panels.employee_title;
import Panels.material_title;
import Panels.position_title;
import Panels.recipe_title;
import Panels.supplier_item;
import Panels.supplier_title;
import Panels.supply_title;

import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Manager_UI<T> extends JFrame {
	static Map map = null;
	JPanel buttonList = new JPanel();
	JButton JSupplier = new JButton("供应商");
	JButton JMaterial = new JButton("原料");
	JButton JCoffee = new JButton("咖啡");
	JButton JSupply = new JButton("供应关系");
	JButton JFormula = new JButton("配方");
	JButton JStaff = new JButton("职工");
	JButton JCustomer = new JButton("客户");
	JButton JRank = new JButton("职称");
	JButton JPersonalInfo = new JButton("个人信息");
	
	static JScrollPane scrollPane = new JScrollPane();
	public static JPanel InfoListPanel = new JPanel();
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_UI frame = new Manager_UI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Manager_UI() {
		setTitle("管理员界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 420);
		getContentPane().setLayout(null);
		
		
		buttonList.setBounds(5, 5, 120, 371);
		getContentPane().add(buttonList);
		buttonList.setLayout(null);
		
		
		JSupplier.setBounds(10,10, 100, 30);
		JSupplier.addActionListener(new InfoListOpener());
		buttonList.add(JSupplier);
		
		
		JMaterial.setBounds(10, 50, 100, 30);
		JMaterial.addActionListener(new InfoListOpener());
		buttonList.add(JMaterial);
		
		
		JCoffee.setBounds(10, 90, 100, 30);
		JCoffee.addActionListener(new InfoListOpener());
		buttonList.add(JCoffee);
		
		
		JSupply.setBounds(10, 130, 100, 30);
		JSupply.addActionListener(new InfoListOpener());
		buttonList.add(JSupply);
		
		
		JFormula.setBounds(10, 170, 100, 30);
		JFormula.addActionListener(new InfoListOpener());
		buttonList.add(JFormula);
		
		
		JStaff.setBounds(10, 210, 100, 30);
		JStaff.addActionListener(new InfoListOpener());
		buttonList.add(JStaff);
		
		
		JCustomer.setBounds(10, 250, 100, 30);
		JCustomer.addActionListener(new InfoListOpener());
		buttonList.add(JCustomer);
		
		
		JRank.setBounds(10, 290, 100, 30);
		JRank.addActionListener(new InfoListOpener());
		buttonList.add(JRank);
		
		
		JPersonalInfo.setBounds(10, 330, 100, 30);
		JPersonalInfo.addActionListener(new InfoListOpener());
		buttonList.add(JPersonalInfo);
		
		
		
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(135, 10, 495, 362);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(InfoListPanel);
		
		InfoListPanel.setLayout(null);
		
		
		//supplier_item si1= new supplier_item(this);
		//si1.setBounds(5, 5, 475, 45);
		//InfoListPanel.add(si1);
		
		
		
		
	}
	
	/*public static void delete(String type,Object id){
		if(type.equals("supplier")){
			InfoListPanel.remove(suppliers.get(id));
			InfoListPanel.repaint();
			suppliers.remove(id);
		}
	}*/
	public static void showMap(String type){
		InfoListPanel.removeAll();
		switch (type){
		case "coffee":
			map = DataBaseUtil.InfoList.getCoffeeMap();
			coffee_title title1 = new coffee_title();
			title1.setBounds(5, 5, 475, 40);
			InfoListPanel.add(title1);
			break;
		case "consumer":
			consumer_title title2 = new consumer_title();
			title2.setBounds(5, 5, 475, 40);
			InfoListPanel.add(title2);
			map = DataBaseUtil.InfoList.getConsumerMap();
			break;
		case "employee":
			employee_title title3 = new employee_title();
			title3.setBounds(5, 5, 475, 40);
			InfoListPanel.add(title3);
			map = DataBaseUtil.InfoList.getEmployeeMap();
			break;
		case "material":
			material_title title4 = new material_title();
			title4.setBounds(5, 5, 475, 40);
			InfoListPanel.add(title4);
			map = DataBaseUtil.InfoList.getMaterialMap();
			break;
		case "position":
			position_title title5 = new position_title();
			title5.setBounds(5, 5, 475, 40);
			InfoListPanel.add(title5);
			map = DataBaseUtil.InfoList.getPositionMap();
			break;
		case "recipe":
			recipe_title title6 = new recipe_title();
			title6.setBounds(5, 5, 475, 40);
			InfoListPanel.add(title6);
			map = DataBaseUtil.InfoList.getRecipeMap();
			break;
		case "supplier":
			supplier_title title7 = new supplier_title();
			title7.setBounds(5, 5, 475, 40);
			InfoListPanel.add(title7);
			map = DataBaseUtil.InfoList.getSupplierMap();
			break;
		case "supply":
			supply_title title8 = new supply_title();
			title8.setBounds(5, 5, 475, 40);
			InfoListPanel.add(title8);
			map = DataBaseUtil.InfoList.getSupplyMap();
			break;
		}
		int height = 40;
		Set set =map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			@SuppressWarnings("unchecked")
                     Map.Entry<?,?> entry = (Map.Entry<?,?>)it.next();
			((Component) entry.getValue()).setBounds(5,height,475,45);
			InfoListPanel.add((Component) entry.getValue());
			//entry.getValue().setFather(this);
			height += 45;
		}
		InfoListPanel.repaint();
		height += 5;
		InfoListPanel.setPreferredSize(new Dimension(485,height));
	}
	
	class InfoListOpener implements ActionListener{

		@Override
              public void actionPerformed(ActionEvent arg0) {
	            if(arg0.getActionCommand().equals("咖啡")){
	              	showMap("coffee");
	              }
	              else if(arg0.getActionCommand().equals("客户")){
	              	showMap("consumer");
	              }
	              else if(arg0.getActionCommand().equals("职工")){
	              	showMap("employee");
	              }
	              else if(arg0.getActionCommand().equals("原料")){
	              	showMap("material");
	              }
	              else if(arg0.getActionCommand().equals("职称")){
	              	showMap("position");
	              }
	              else if(arg0.getActionCommand().equals("配方")){
	              	showMap("recipe");
	              }
	              else if(arg0.getActionCommand().equals("供应商")){
	              	showMap("supplier");
	              }
	              else if(arg0.getActionCommand().equals("供应关系")){
	              	showMap("supply");
	              }
	              /*else if(arg0.equals("原材料")){
	              	materials = DataBaseUtil.InfoList.getMaterialList();
	              	showMaterials;
	              }*/
              }
		
	}
}

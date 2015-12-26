package DataBaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Panels.coffee_item;
import Panels.consumer_item;
import Panels.employee_item;
import Panels.material_item;
import Panels.position_item;
import Panels.recipe_item;
import Panels.supplier_item;
import Panels.supply_item;

public class InfoList {
	static Map<Integer, supplier_item> suppliers = null; 
	static Map<Integer, coffee_item> coffee = null; 
	static Map<String, consumer_item> consumers = null; 
	static Map<Integer, employee_item> employees = null; 
	static Map<Integer, material_item> materials= null; 
	static Map<Integer, position_item> positions = null; 
	static Map<Integer, recipe_item> recipes = null; 
	static Map<Integer, supply_item> supplies = null; 
	/**
	 * @wbp.parser.entryPoint
	 */
	public static Map<Integer, supplier_item> getSupplierMap(){
		String SQLstatement = "select * from supplier";
		ResultSet rs = ConnectDataBase.Select(SQLstatement);
		suppliers = new HashMap<Integer, supplier_item>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String city =rs.getString(4);
				String tele = rs.getString(5);
				supplier_item temp = new supplier_item(id, name, city, tele);
				suppliers.put(new Integer(id), temp);
				System.out.println(id +" "+ name +" "+city+" "+tele);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InfoList");
			e.printStackTrace();
		}
		return suppliers;
	}
	public static Map<Integer, coffee_item> getCoffeeMap(){
		String SQLstatement = "select * from coffee";
		ResultSet rs = ConnectDataBase.Select(SQLstatement);
		coffee = new HashMap<Integer, coffee_item>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price =rs.getInt(3);
				int num = rs.getInt(4);
				coffee_item temp = new coffee_item(id, name, price, num);
				coffee.put(new Integer(id), temp);
				System.out.println(id +" "+ name +" "+price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InfoList");
			e.printStackTrace();
		}
		return coffee;
	}
	public static Map<String, consumer_item> getConsumerMap(){
		String SQLstatement = "select * from user";
		ResultSet rs = ConnectDataBase.Select(SQLstatement);
		consumers = new HashMap<String, consumer_item>();
		try {
			while(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				String sex =rs.getString(3);
				double consume = rs.getDouble(4);
				int ifMember = rs.getInt(5);
				double consume_total = rs.getDouble(6);
				consumer_item temp = new consumer_item(id, name, sex,consume,ifMember,consume_total);
				consumers.put(id, temp);
				System.out.println(id +" "+ name +" "+sex+ "" +consume+ "" +ifMember + "" +consume_total);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InfoList");
			e.printStackTrace();
		}
		return consumers;
	}
	public static Map<Integer, employee_item> getEmployeeMap(){
		String SQLstatement = "select * from employee";
		ResultSet rs = ConnectDataBase.Select(SQLstatement);
		employees = new HashMap<Integer, employee_item>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sex =rs.getString(3);
				int age = rs.getInt(4);
				int tel = rs.getInt(5);
				int pid = rs.getInt(7);
				employee_item temp = new employee_item(id, name, sex, age,tel,pid);
				employees.put(id, temp);
				System.out.println(id +" "+ name +" "+sex+ "" + age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InfoList");
			e.printStackTrace();
		}
		return employees;
	}
	public static Map<Integer, material_item> getMaterialMap(){
		String SQLstatement = "select * from material";
		ResultSet rs = ConnectDataBase.Select(SQLstatement);
		materials = new HashMap<Integer, material_item>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int inventory = rs.getInt(3);
				material_item temp = new material_item(id, name, inventory);
				materials.put(id, temp);
				System.out.println(id +" "+ name +" "+inventory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InfoList");
			e.printStackTrace();
		}
		return materials;
	}
	public static Map<Integer, position_item> getPositionMap(){
		String SQLstatement = "select * from position";
		ResultSet rs = ConnectDataBase.Select(SQLstatement);
		positions = new HashMap<Integer, position_item>();
		try {
			while(rs.next()){
				int id = rs.getInt(1);
				String position = rs.getString(2);
				int salary = rs.getInt(3);
				position_item temp = new position_item(id, position, salary);
				positions.put(new Integer(id), temp);
				System.out.println(id +" "+ position +" "+salary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InfoList");
			e.printStackTrace();
		}
		return positions;
	}
	public static Map<Integer, recipe_item> getRecipeMap(){
		String SQLstatement = "select * from recipe";
		ResultSet rs = ConnectDataBase.Select(SQLstatement);
		recipes = new HashMap<Integer, recipe_item>();
		try {
			while(rs.next()){
				int c_id = rs.getInt(1);
				int m_id = rs.getInt(2);
				int dosage = rs.getInt(3);
				recipe_item temp = new recipe_item(c_id, m_id, dosage);
				recipes.put(new Integer(m_id*1000+c_id), temp);
				System.out.println(c_id +" "+ m_id +" "+dosage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InfoList");
			e.printStackTrace();
		}
		return recipes;
	}
	public static Map<Integer, supply_item> getSupplyMap(){
		String SQLstatement = "select * from supply";
		ResultSet rs = ConnectDataBase.Select(SQLstatement);
		supplies = new HashMap<Integer, supply_item>();
		try {
			while(rs.next()){
				int su_id = rs.getInt(1);
				int s_id = rs.getInt(2);
				int m_id = rs.getInt(3);
				int amount = rs.getInt(4);
				int price = rs.getInt(5);
				supply_item temp = new supply_item(su_id, s_id, m_id, amount, price);
				supplies.put(new Integer(su_id), temp);
				//System.out.println(m_id +" "+ s_id );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InfoList");
			e.printStackTrace();
		}
		return supplies;
	}
	//public static ArrayList<Entity.Material> getMaterialList(){}
}

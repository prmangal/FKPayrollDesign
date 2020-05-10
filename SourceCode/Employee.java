import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject; 
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;
interface Emp{
	int get_employee_id();
	void set_employee_id(int i);
	String get_name();
	void set_name(String name);
	int get_hour_rate();
	void set_hour_rate(int rate);
	double get_com_rate();
	void set_com_rate(double rate);
	int get_dues();
	void set_dues(int dues);
	int get_monthly_salary();
	void set_monthly_salary(int salary);
	double get_total_salary();
	void calculate_salary(int overtime, int sales);
}
public class Employee implements Emp{
	private int employee_id;
	private String name;
	//public boolean is_active;
	public boolean is_hourly;
	private int hour_rate;
	private double com_rate;
	private int monthly_salary;
	private double total_salary;
	public String method_of_payment;
	private int dues;



	//constructor
	public Employee(String name, boolean is_hourly, int salary, double com_rate, String method_of_payment){
		this.name = name;
		//this.is_active = true;
		this.is_hourly = is_hourly;
		if(is_hourly){ 
			this.hour_rate = salary; 
			this.monthly_salary=0;
		}
		else { 
			this.monthly_salary = salary; 
			this.hour_rate = 0;
		}
		this.com_rate=com_rate;
		this.total_salary = 0;
		this.method_of_payment = method_of_payment;
		this.dues = 0;

	}
	public Employee(int id){
		try{ 
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("employees.json"));
			JSONObject a = (JSONObject)obj;

			JSONObject emp = (JSONObject)a.get(String.valueOf(id));
			this.name = emp.get("name").toString();
			this.employee_id = id;
			this.is_hourly = Boolean.parseBoolean(emp.get("is_hourly").toString());
			this.hour_rate = Integer.parseInt(emp.get("hour_rate").toString());
			this.com_rate = Integer.parseInt(emp.get("com_rate").toString());
			this.monthly_salary = Integer.parseInt(emp.get("monthly_salary").toString());
			this.total_salary = Double.parseDouble(emp.get("total_salary").toString());
			this.method_of_payment = emp.get("method_of_payment").toString();
			this.dues = Integer.parseInt(emp.get("dues").toString());
            FileWriter fileWriter = new FileWriter("employees.json");         // writing back to the file
            fileWriter.write(a.toJSONString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	public int get_employee_id(){
		return employee_id;
	}
	public void set_employee_id(int i){
		this.employee_id = i;
	}
	public String get_name(){
		return this.name;
	}
	public void set_name(String name){
		this.name = name;
	}
	public int get_hour_rate(){
		return hour_rate;
	}
	public void set_hour_rate(int rate){
		this.hour_rate = hour_rate;
	}
	public double get_com_rate(){
		return com_rate;
	}
	public void set_com_rate(double com_rate){
		this.com_rate = com_rate;
	}
	public int get_monthly_salary(){
		return monthly_salary;
	}
	public void set_monthly_salary(int salary){
		this.monthly_salary = salary;
	}
	public double get_total_salary(){
		return total_salary;
	}
	public int get_dues(){
		return dues;
	}
	public void set_dues(int dues){
		this.dues = dues;
	}
	public void calculate_salary(int overtime, int sales){
		if(is_hourly){
			if(overtime>=0){
				total_salary += overtime*1.5*hour_rate + 8*hour_rate + sales*com_rate/100-dues;
 			}
 			else{
 				total_salary += (8+overtime)*hour_rate + sales*com_rate/100-dues;
 			}
		}
		else{
			double h_rate = monthly_salary/(30*8);
			if(overtime>=0){
				total_salary += overtime*1.5*h_rate + 8*h_rate + sales*com_rate/100-dues;
 			}
 			else{
 				total_salary += (8+overtime)*h_rate + sales*com_rate/100-dues;
 			}
		}

	}
}
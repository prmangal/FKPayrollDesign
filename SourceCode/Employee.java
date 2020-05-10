interface Emp{
	int get_employee_id();
	void set_employee_id(int i);
	String get_name();
	void set_name(String name);
	int get_hour_rate();
	void set_hour_rate(int rate);
	double get_com_rate();
	void set_com_rate(double rate);
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
	public void calculate_salary(int overtime, int sales){
		if(is_hourly){
			if(overtime>=0){
				total_salary += overtime*1.5*hour_rate + 8*hour_rate + sales*com_rate/100;
 			}
 			else{
 				total_salary += (8+overtime)*hour_rate + sales*com_rate/100;
 			}
		}
		else{
			double h_rate = monthly_salary/(30*8);
			if(overtime>=0){
				total_salary += overtime*1.5*h_rate + 8*h_rate + sales*com_rate/100;
 			}
 			else{
 				total_salary += (8+overtime)*h_rate + sales*com_rate/100;
 			}
		}

	}
}
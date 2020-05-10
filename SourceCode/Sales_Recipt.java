import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Sales_Recipt{
	public static void sales_recipt(){
		try{
			System.out.println("Please provide employee_id and amount of sales");
			Scanner scan = new Scanner(System.in);
			String id = new String();
			String sales = new String();
			id = scan.next();
			sales = scan.next();

			File file = new File("Sales_Recipt.txt");
			FileWriter fw=new FileWriter(file,true);
			fw.write(id + " " + sales+"\n");
			fw.close();
			System.out.println("Sales Recipt Posted Successfully");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
package lab_13122023;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

class Employee{
	int Id;
	String Name;
	String Address;
	String Tel;
	int NumOfDate;
	float Salary;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public int getNumOfDate() {
		return NumOfDate;
	}
	public void setNumOfDate(int numOfDate) {
		NumOfDate = numOfDate;
	}
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	public int calSalary() {
		return (int) (Salary+ 3* NumOfDate);
	}
	public Employee(int id, String name, String address, String tel, int numOfDate, float salary) {
		super();
		Id = id;
		Name = name;
		Address = address;
		Tel = tel;
		NumOfDate = numOfDate;
		Salary = salary;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	void input() {
		Scanner objSc= new Scanner(System.in);
		System.out.print("Id: ");
		this.setId(objSc.nextInt());
		
		System.out.print("Name: ");
		this.setName(objSc.nextLine());
		
		System.out.print("Address: ");
		this.setAddress(objSc.nextLine());
		
		System.out.print("Tel: ");
		this.setTel(objSc.nextLine());
		
		System.out.print("NumOfDate: ");
		this.setNumOfDate(objSc.nextInt());
		
		System.out.print("Salary: ");
		this.setSalary(objSc.nextInt());
	}
	
	void output() {
		System.out.println(this.Id+ " "+ this.getId()+ " "+ 
				this.Name+ " "+ this.getName()+ " "+
				this.Address+ " "+ this.getAddress()+ " "+ 
				this.Tel+ " "+ this.getTel()+ " "+ 
				this.NumOfDate+ " "+ this.getNumOfDate()+ " "+ 
				this.Salary+ " "+ this.getSalary());
	}
}
class EmpList{
	private OutputStreamWriter fw;
	void input(Employee[] emp) {
		for(int i= 0; i<emp.length; i++) {
			emp[i]= new Employee();
			emp[i].input();
		}
	}
	void output(Employee[] emp) {
		for(int i= 0; i<emp.length; i++) {
			emp[i].output();
		}
	}
	void SortEmpList(Employee[] emp) throws IOException{
		File f= new File("D:\\test.txt");
		FileWriter fw= new FileWriter(f);
		Employee tpm= null;
		for(int i= 0; i< emp.length- 1; i++) {
			for(int j= i+1; j< emp.length; i++) {
				if(emp[i].Salary> emp[j].Salary) {
					tpm= emp[i];
					emp[i]= emp[j];
					emp[j]= tpm;
				}
			}
		}
		try {
			for(int i= 0; i< emp.length; i++) 
				fw.write(emp[i].Id+ " "+ emp[i].Name+ " "+ emp[i].Address+ " "+ emp[i].Tel+ " "+ emp[i].NumOfDate+ ""+ emp[i].Salary+ "\n");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		fw.close();
	}
	void MaxSalaryToFile(Employee[] emp) throws IOException{
		File f= new File("D:\\test.txt");
		FileWriter tw= new FileWriter(f, true);
		float max= emp[0].Salary;
		int k= 0;
		for(int i= 0; i<emp.length; i++) {
			if(max< emp[i].Salary) {
				max= emp[i].Salary;
				k= 1;
			}
		}
		try {
			fw.write("Max Salary: "+ emp[k].Salary+ "\n");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		fw.close();
	}
	void SumSalaryToFile(Employee[] emp) throws IOException{
		File f= new File("D:\\test.txt");
		FileWriter tw= new FileWriter(f, true);
		float sum= 0;
		for(int i= 0; i< emp.length; i++) {
			sum+= emp[i].Salary;
		}
		try {
			fw.write("Sum Of Salary: "+ sum+ "\n");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		fw.close();
	}
	void outputFromFile(Employee[] emp) throws IOException{
		FileReader fr= new FileReader("D:\\test.txt");
		BufferedReader br= new BufferedReader(fr);
		String str= null;
		try {
			while((str= br.readLine()) !=null) {
				System.out.println(str);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		fr.close();
		br.close();
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		Employee[] emp= new Employee[3];
		EmpList List= new EmpList();
		List.input(emp);
		List.output(emp);
		List.SortEmpList(emp);
		List.outputFromFile(emp);
		List.MaxSalaryToFile(emp);
		List.SumSalaryToFile(emp);
	}

}

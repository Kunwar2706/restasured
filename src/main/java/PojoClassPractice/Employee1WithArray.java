package PojoClassPractice;

public class Employee1WithArray {
	String name;
	int id;
	int[]ph;
	public Employee1WithArray(String name, int id, int[] ph) {
		super();
		this.name = name;
		this.id = id;
		this.ph = ph;
	}
	public Employee1WithArray()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int[] getPh() {
		return ph;
	}
	public void setPh(int[] ph) {
		this.ph = ph;
	}

}

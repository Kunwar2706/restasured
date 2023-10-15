 package pojoClass;

public class Employee {
String name;
int phNo;
int id;
public Employee(String name, int phNo, int id) {
	super();
	this.name = name;
	this.phNo = phNo;
	this.id = id;
}
public Employee() {
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPhNo() {
	return phNo;
}
public void setPhNo(int phNo) {
	this.phNo = phNo;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
	}



 package pojoClass;

public class EmpoyeeWithArray {
String name;
int id;
int []phone;
public EmpoyeeWithArray(String name, int id, int[] phone) {
	super();
	this.name = name;
	this.id = id;
	this.phone = phone;
}
public EmpoyeeWithArray()
{}
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
public int[] getPhone() {
	return phone;
}
public void setPhone(int[] phone) {
	this.phone = phone;
}

}

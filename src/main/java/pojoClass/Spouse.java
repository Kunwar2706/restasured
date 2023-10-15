package pojoClass;

public class Spouse {
String name;
int id;
int phnNo;
public Spouse(String name, int id, int phnNo) {
	super();
	this.name = name;
	this.id = id;
	this.phnNo = phnNo;
}
public Spouse()
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
public int getPhnNo() {
	return phnNo;
}
public void setPhnNo(int phnNo) {
	this.phnNo = phnNo;
}

}

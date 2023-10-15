 package pojoClass;

public class EmployeeWithObject {
String ename;
int eId;
int[] ePhno;
Spouse espouse;
public EmployeeWithObject(String ename, int eId, int[] ePhno, Spouse espouse) {
	super();
	this.ename = ename;
	this.eId = eId;
	this.ePhno = ePhno;
	this.espouse = espouse;
}
public EmployeeWithObject()
{
	
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int geteId() {
	return eId;
}
public void seteId(int eId) {
	this.eId = eId;
}
public int[] getePhno() {
	return ePhno;
}
public void setePhno(int[] ePhno) {
	this.ePhno = ePhno;
}
public Spouse getEspouse() {
	return espouse;
}
public void setEspouse(Spouse espouse) {
	this.espouse = espouse;
}

}

package PojoClassPractice;

public class Employee1WithObject {
String ename;
int eid;
int[] ephNo;
Spause1 eSaouse;
public Employee1WithObject(String ename, int eid, int[] ephNo, Spause1 eSaouse) {
	super();
	this.ename = ename;
	this.eid = eid;
	this.ephNo = ephNo;
	this.eSaouse = eSaouse;
}
public Employee1WithObject()
{
	
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public int[] getEphNo() {
	return ephNo;
}
public void setEphNo(int[] ephNo) {
	this.ephNo = ephNo;
}
public Spause1 geteSaouse() {
	return eSaouse;
}
public void seteSaouse(Spause1 eSaouse) {
	this.eSaouse = eSaouse;
}

}

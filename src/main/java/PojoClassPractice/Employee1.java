package PojoClassPractice;

public class Employee1 {

String ename;
int eid;
int ePhno;
public Employee1(String ename, int eid, int ePhno) {
	super();
	this.ename = ename;
	this.eid = eid;
	this.ePhno = ePhno;
}
public Employee1()
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
public int getePhno() {
	return ePhno;
}
public void setePhno(int ePhno) {
	this.ePhno = ePhno;
}

}

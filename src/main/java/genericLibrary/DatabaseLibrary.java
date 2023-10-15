package genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseLibrary {
	
	Driver d;
	Connection con;
	
	
	public void connectToDB() throws Throwable
	{
		d=new Driver();
		DriverManager.registerDriver(d);
		con = DriverManager.getConnection(IPathConstant.DBURL, IPathConstant.DBUSERNAME, IPathConstant.DBPASSWORD);
	}
	
	
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	
	public String readDataFromDBAndValidate(String query, int columnIndex, String expData) throws Throwable
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			if (result.getString(columnIndex).equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		
		if (flag)
		{
			System.out.println("verified");
			return expData;
		}
		else
		{
			System.out.println("data not verified");
			return "";
		}	
	}
	public String creteProjThroughDB(String projId,String createdBy,String ddmyyyy,String projName,String status,int tSize) throws SQLException {
		String query1 = "insert into project values('"+projId+"','"+createdBy+"','"+ddmyyyy+"','"+projName+"','"+status+"','"+tSize+"')";
	int result = con.createStatement().executeUpdate(query1);
	if(result==1)
	{
		return "data is verfied";
	}
	return "data is not verfied";
	}
}







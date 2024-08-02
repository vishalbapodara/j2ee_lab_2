import java.sql.*;
public class Pcall2{
	public static void main(String args[]){
		Connection con;
		CallableStatement cst;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			cst = con.prepareCall("{call p_add3(?,?,?,?)}");
			cst.setInt(1,6);
			cst.setString(2,"Himanshu");
			cst.setString(3,"Peon");
			cst.setString(4,"New York");
			cst.execute();
			System.out.println("Record Inserted...");
			con.close();
			cst.close();
		} 
		catch(Exception e){
			System.out.println(e);
		}
	}
}


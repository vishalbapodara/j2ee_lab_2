import java.sql.*;
import java.util.*;
public class Pcall4{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Connection con;
		CallableStatement cst;
		ResultSet rs;
		try{
			System.out.println("Enter Designation:");
			String de = sc.nextLine();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			cst = con.prepareCall("{call p_add5(?)}");
			cst.setString(1,de);
			rs = cst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String desig = rs.getString("desig");
				String city = rs.getString("city");
				
				System.out.println("Id:" + id);
				System.out.println("Name:" + name);
				System.out.println("Designation:" + desig);
				System.out.println("City:" + city);
			}
			
			con.close();
			cst.close();
		} 
		catch(Exception e){
			System.out.println(e);
		}
	}
}
/*DELIMITER //

CREATE PROCEDURE p_add5(IN desigx varchar(10))
BEGIN
    SELECT * FROM emp2 WHERE desig = desigx;
END //

DELIMITER ;*/

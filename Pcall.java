import java.sql.*;
public class Pcall{
	public static void main(String args[]){
		Connection con;
		CallableStatement cst;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			cst = con.prepareCall("{call p_dj12()}");
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
/*DELIMITER //
CREATE PROCEDURE p_dj12()
BEGIN
INSERT INTO emp  VALUES (6,"Himnashu","xyz");
END //
DELIMITER ;*/

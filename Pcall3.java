import java.sql.*;
public class Pcall3{
	public static void main(String args[]){
		Connection con;
		CallableStatement cst;
		ResultSet rs;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			cst = con.prepareCall("{call p_add4(?)}");
			cst.setInt(1,6);
			rs = cst.executeQuery();
			while(rs.next()){
				String desig = rs.getString("desig");
				System.out.println("Designation:" + desig);
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

CREATE PROCEDURE p_add4(IN idx INT)
BEGIN
    SELECT desig FROM emp2 WHERE id = idx;
END //

DELIMITER ;
 ;*/

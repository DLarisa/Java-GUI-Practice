package serviciiJDBC;

import java.sql.*;
import java.util.List;

import animale.Zana;
import pachet.Service;

public class ZanaJDBC {
	
	public void creeazaTabela()
    {
		try {

	         Class.forName("com.mysql.cj.jdbc.Driver");
	   } catch (Exception ex) {
	            // handle the error
		   ex.getMessage();
	   }
		 
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
			Statement stmt = null;
			stmt = conn.createStatement();
			
			String sql = "CREATE TABLE IF NOT EXISTS zane("
		  			+ "nume VARCHAR(30) NOT NULL,"
		  			+ "culoare VARCHAR(30) NOT NULL,"
		  			+ "varsta DOUBLE NOT NULL,"
		  			+ "pret DOUBLE NOT NULL, "
		  			+ "element VARCHAR(30) NOT NULL,"
		  			+ "PRIMARY KEY (nume)) "; 
			
          stmt.execute(sql);
          conn.close();
 
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
	
	
	public void AddZana(Zana d)
    {
		try {

	         Class.forName("com.mysql.cj.jdbc.Driver");
	   } catch (Exception ex) {
	            // handle the error
		   ex.getMessage();
	   }
		 
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
			Statement stmt = null;
			stmt = conn.createStatement();		
			String sql = "INSERT INTO zane (nume,culoare,varsta,pret,element) VALUES ('"+
	                   d.getNume()+"','"+d.getCuloare()+"',"+d.getVarsta()+","+d.getPret()+",'"+d.getElement()+"');";
			stmt.execute(sql);
			conn.close();
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
	
	public void DeleteZana(Zana d)
    {
		try {

	         Class.forName("com.mysql.cj.jdbc.Driver");
	   } catch (Exception ex) {
	       ex.getMessage();
	   }
		 
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
			Statement stmt = null;
			stmt = conn.createStatement();
			String sql = "DELETE FROM zane WHERE nume ='"+d.getNume()+"';";
			stmt.execute(sql);
			conn.close();
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
	
	
	public void PrintZana()
    {
		try {

	         Class.forName("com.mysql.cj.jdbc.Driver");
	   } catch (Exception ex) {
	       ex.getMessage();
	   }
		 
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
			Statement stmt = null;
			stmt = conn.createStatement();
			String sql = "SELECT * FROM zane";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
		         //Retrieve by column name
				String nume = rs.getString("nume");
				String culoare = rs.getString("culoare");
				Double varsta = rs.getDouble("varsta");
				Double pret = rs.getDouble("pret");
				String element = rs.getString("element");
				
				System.out.print("Zana" + ": " + nume + ", " + varsta + " ani \nElement: " + element +
                "\nCulore: " + culoare
                + "\nPret: " + pret + " monede de aur\n------------------------------------\n");
		      }
		      rs.close();
			conn.close();
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
	
	public void UpdateZana(Zana d)
    {
		try {

	         Class.forName("com.mysql.cj.jdbc.Driver");
	   } catch (Exception ex) {
	            // handle the error
		   ex.getMessage();
	   }
		 
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
			Statement stmt = null;
			stmt = conn.createStatement();		
			String sql = "UPDATE zane " +
	                   "SET pret = 30 WHERE nume ='"+d.getNume()+"';";
			stmt.execute(sql);
			conn.close();
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}

	
}
package serviciiJDBC;

import java.sql.*;
import java.util.List;

import animale.Phoenix;
import pachet.Service;

public class PhoenixJDBC {
	
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
			
			String sql = "CREATE TABLE IF NOT EXISTS phoenixi("
		  			+ "nume VARCHAR(30) NOT NULL,"
		  			+ "culoare VARCHAR(30) NOT NULL,"
		  			+ "varsta DOUBLE NOT NULL,"
		  			+ "pret DOUBLE NOT NULL, "
		  			+ "tara VARCHAR(30) NOT NULL,"
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
	
	
	public void AddPhoenix(Phoenix d)
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
			String sql = "INSERT INTO phoenixi (nume,culoare,varsta,pret,tara) VALUES ('"+
	                   d.getNume()+"','"+d.getCuloare()+"',"+d.getVarsta()+","+d.getPret()+",'"+d.getTara()+"');";
			stmt.execute(sql);
			conn.close();
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
	
	public void DeletePhoenix(Phoenix d)
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
			String sql = "DELETE FROM phoenixi WHERE nume ='"+d.getNume()+"';";
			stmt.execute(sql);
			conn.close();
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
	
	
	public void PrintPhoenix()
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
			String sql = "SELECT * FROM phoenixi";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
		         //Retrieve by column name
				String nume = rs.getString("nume");
				String culoare = rs.getString("culoare");
				Double varsta = rs.getDouble("varsta");
				Double pret = rs.getDouble("pret");
				String tara = rs.getString("tara");
				
				System.out.print("Phoenix " + tara + ": " + nume + ", " + varsta + " ani \nCuloare: " + culoare +
						"\nPret: " + pret + " monede de aur\n------------------------------------\n");
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
	
	public void UpdatePhoenix(Phoenix d)
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
			String sql = "UPDATE phoenixi " +
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
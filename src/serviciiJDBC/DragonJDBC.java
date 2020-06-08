package serviciiJDBC;

import java.sql.*;
import java.util.List;

import animale.Dragon;
import pachet.Service;

public class DragonJDBC {
	
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
			
			String sql = "CREATE TABLE IF NOT EXISTS dragoni("
		  			+ "nume VARCHAR(30) NOT NULL,"
		  			+ "culoare VARCHAR(30) NOT NULL,"
		  			+ "varsta DOUBLE NOT NULL,"
		  			+ "pret DOUBLE NOT NULL, "
		  			+ "specie VARCHAR(30) NOT NULL,"
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
	
	
	public void AddDragon(Dragon d)
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
			String sql = "INSERT INTO dragoni (nume,culoare,varsta,pret,specie,element) VALUES ('"+
	                   d.getNume()+"','"+d.getCuloare()+"',"+d.getVarsta()+","+d.getPret()+",'"+d.getSpecie()+"','"+d.getElement()+"');";
			stmt.execute(sql);
			conn.close();
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
	
	public void DeleteDragon(Dragon d)
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
			String sql = "DELETE FROM dragoni WHERE nume ='"+d.getNume()+"';";
			stmt.execute(sql);
			conn.close();
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
	
	
	public void PrintDragon()
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
			String sql = "SELECT * FROM dragoni";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
		         //Retrieve by column name
				String nume = rs.getString("nume");
				String culoare = rs.getString("culoare");
				Double varsta = rs.getDouble("varsta");
				Double pret = rs.getDouble("pret");
				String specie = rs.getString("specie");
				String element = rs.getString("element");
				
				System.out.print("Dragon " + specie + ": " + nume + ", " + varsta + " ani \nElement: " + element +
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
	
	public void UpdateDragon(Dragon d)
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
			String sql = "UPDATE dragoni " +
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
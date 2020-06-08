package serviciiJDBC;

import java.sql.*;
import java.util.List;

import animale.Trol;
import pachet.Service;

public class TrolJDBC {
	
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
			
			String sql = "CREATE TABLE IF NOT EXISTS troli("
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
	
	
	public void AddTrol(Trol d)
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
			String sql = "INSERT INTO troli (nume,culoare,varsta,pret,element) VALUES ('"+
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
	
	public void DeleteTrol(Trol d)
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
			String sql = "DELETE FROM troli WHERE nume ='"+d.getNume()+"';";
			stmt.execute(sql);
			conn.close();
		}catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
	
	
	public void PrintTrol()
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
			String sql = "SELECT * FROM troli";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
		         //Retrieve by column name
				String nume = rs.getString("nume");
				String culoare = rs.getString("culoare");
				Double varsta = rs.getDouble("varsta");
				Double pret = rs.getDouble("pret");
				String element = rs.getString("element");
				
				System.out.print("Trol" + ": " + nume + ", " + varsta + " ani \nElement: " + element +
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
	
	public void UpdateTrol(Trol d)
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
			String sql = "UPDATE troli " +
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
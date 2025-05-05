package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.mysql.cj.xdevapi.Statement;

public class Ejercicio1 {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String contraseña = "Nuevacuenta13*";

		try (Connection con = DriverManager.getConnection(url, usuario, contraseña)) {
			
			Statement st=con.createStatement();
		
			//Query solo hace selects
			ResultSet res=st.executeQuery("select * from estudiantes");
			
			//update hace insert, update y delete
			//st.executeUpdate("insert....");

			
			while(!res.next()) {
				System.out.println();
			}
			
			
		} catch (SQLException e) {

			System.out.println("Error con la base de datos");
		}
	}

}

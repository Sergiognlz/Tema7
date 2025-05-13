package ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utiles.Constantes;

public class Ejercicio3 {
public static void main(String[] args) {
	
	// conexión con la base de datos dentro de un try catch
	try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {
		//hacemos delete de los nombres añadidos en el ejercicio 1
		String delete = "delete from estudiantes where nombre=? or nombre=? or nombre=?";

		// objeto PreparedStatment y le pasamos el delete
		PreparedStatement pst = con.prepareStatement(delete);
		// aplicamos donde el nombre sea los siguientes
		pst.setString(1, "Elva");
		pst.setString(2, "Manolo");
		pst.setString(3, "María");
		
		// guardamos cuantas filas se han modificado
		int res = pst.executeUpdate();

		// imprimimos la respuesta
		System.out.println("Fila modificada " + res);

		// capturamos excepción sql
	} catch (SQLException e) {
		// mensajito error
		System.out.println("Error con la base de datos " + e.getMessage());
	}
}

}

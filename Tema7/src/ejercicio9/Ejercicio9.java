package ejercicio9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utiles.Constantes;

public class Ejercicio9 {
	public static void main(String[] args) {

		// conexión con la base de datos dentro de un try catch
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {
			// consulta de media de nota donde tenemos en cuenta el id del curso y la nota
			String select = "select nombre, fecha_nacimiento from estudiantes";
		

			// sentencia paremetrizada creando objeto de tipo PreparedStantement
			PreparedStatement pst = con.prepareStatement(select);

			// guardamos el resultado de la consulta
			ResultSet rs = pst.executeQuery();

			// recorremos el resultado
			while (rs.next()) {

				// imprimimos la un getString de la respuesta y le indicamos la tabla nombre y
				// fecha de nacimiento
				System.out.println(rs.getString("nombre") + " " + rs.getString("fecha_nacimiento"));
			}

			// capturamos excepción sql
		} catch (SQLException e) {
			// mensajito error
			System.out.println("Error con la base de datos " + e.getMessage());
		}
	}

}

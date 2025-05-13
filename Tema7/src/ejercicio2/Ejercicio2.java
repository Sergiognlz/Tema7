package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utiles.Constantes;

public class Ejercicio2 {
	public static void main(String[] args) {

		// conexión con la base de datos dentro de un try catch
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {
			//hacemos update restando 4 a la nota
			String update = "UPDATE Calificaciones SET nota=nota-4 WHERE tipo_evaluacion=?";

			// objeto PreparedStatment y le pasamos el update
			PreparedStatement pst = con.prepareStatement(update);
			// aplicamos donde el tipo de la evaluación sea Examen
			pst.setString(1, "Examen");

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

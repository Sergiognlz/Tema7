package ejercicio10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utiles.Constantes;

public class Ejercicio10 {
	public static void main(String[] args) {
		boolean existe=false;
		// variable curso;
		String curso;
		// creamos escaner
		Scanner sc = new Scanner(System.in);

		// pedimos nombre curso
		System.out.println("Introduce el nombre del curso para mostrar alumnos y fecha de nacimiento");
		// guardamos nombre curso
		curso = sc.nextLine();

		// conexión con la base de datos dentro de un try catch
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {
			// consulta de media de nota donde tenemos en cuenta el id del curso y la nota
			String select = "select e.nombre, e.fecha_nacimiento from estudiantes e "
					+ "Join Matriculas m on e.id_estudiante=m.id_estudiante "
					+ "join Cursos c on m.id_curso=c.id_curso WHERE c.nombre=?";

			// objeto PreparedStatment y le pasamos el delete
			PreparedStatement pst = con.prepareStatement(select);
			// aplicamos donde el nombre sea los siguientes
			pst.setString(1, curso);

			// guardamos cuantas filas se han modificado
			ResultSet res = pst.executeQuery();
			
			

			// recorremos el resultado
			while (res.next()) {
				existe=true;
				// imprimimos la un getString de la respuesta y le indicamos la tabla nombre y
				// fecha de nacimiento
				System.out.println(res.getString("nombre") + " " + res.getString("fecha_nacimiento"));
			}
			if(!existe) {
				System.out.println("El curso que busca no existe");
			}

			// capturamos excepción sql
		} catch (SQLException e) {
			// mensajito error
			System.out.println("Error con la base de datos " + e.getMessage());
		}
	}

}
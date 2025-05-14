package ejercicio8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utiles.Constantes;

public class Ejercicio8 {
	public static void main(String[] args) {
		
		int idEs;
		Scanner sc=new Scanner(System.in);
		
		// conexión con la base de datos dentro de un try catch
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {
			//hacemos delete de los nombres añadidos en el ejercicio 1
			String delete = "delete from estudiantes where id_estudiante=?";
			
			
			System.out.println("Introduce el id del alumno a eliminar");
			idEs=sc.nextInt();

			// objeto PreparedStatment y le pasamos el delete
			PreparedStatement pst = con.prepareStatement(delete);
			// aplicamos donde el nombre sea los siguientes
			pst.setInt(1, idEs);
		
			
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

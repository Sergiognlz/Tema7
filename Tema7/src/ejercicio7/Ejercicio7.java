package ejercicio7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utiles.Constantes;

public class Ejercicio7 {
	public static void main(String[] args) {
		
		String nombre;
		String apellido;
		String fechaNacimiento;
		String email;
		String telefono;
		
		Scanner sc=new Scanner(System.in);
	
		// conexión con la base de datos dentro de un try catch
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {
		

			// guardamos la sentencia insert por agilizar con los datos que vamos a insertar
			String insert = "insert into estudiantes(nombre, apellido, fecha_nacimiento, email, telefono)"
					+ "values(?,?,?,?,?)";

			System.out.println("Introduce nombre de estudiante");
			nombre=sc.nextLine();
			
			System.out.println("Introduce apellido de estudiante");
			apellido=sc.nextLine();
			
			System.out.println("Introduce fecha de nacimiento de estudiante");
			fechaNacimiento=sc.nextLine();
			
			System.out.println("Introduce email de estudiante");
			email=sc.nextLine();
			
			System.out.println("Introduce teléfono estudiante");
			telefono=sc.nextLine();
			

			// objeto PreparedStatment y le pasamos el primer insert
			PreparedStatement pst = con.prepareStatement(insert);
			//valores de la inserción
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setString(3, fechaNacimiento);
			pst.setString(4, email);
			pst.setString(5, telefono);
			//guardamos cuantas filas se han modificado
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

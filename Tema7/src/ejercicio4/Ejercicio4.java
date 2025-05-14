package ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utiles.Constantes;

public class Ejercicio4 {
	public static void main(String[] args) {
		//array de int donde guardaremos las filas modificadas
		int res[];
		
		// conexión con la base de datos dentro de un try catch
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {
	

			// guardamos la sentencia insert por agilizar con los datos que vamos a insertar
			String insert = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES (?,?,?)";


			// sentencia paremetrizada creando objeto de tipo PreparedStantement y le pasamos la sentencia insert
			PreparedStatement pst = con.prepareStatement(insert);
		
			//valores de la inserción
			pst.setString(1, "Historia 1º");
			pst.setString(2, "Me gusta la historia porque es como una película");
			pst.setInt(3, 2025);
			//addBatch alamecena las sentencias para ejecutarlas al mismo tiempo
			pst.addBatch();
			
			
			//valores de la inserción
			pst.setString(1, "Biología 1º");
			pst.setString(2, "Es interesante pero se explica de manera muy aburrida");
			pst.setInt(3, 2025);
			//addBatch alamecena las sentencias para ejecutarlas al mismo tiempo
			pst.addBatch();
			
			
			//valores de la inserción
			pst.setString(1, "Educación física 1º");
			pst.setString(2, "Correr es de cobardes");
			pst.setInt(3, 2025);
			//addBatch alamecena las sentencias para ejecutarlas al mismo tiempo
			pst.addBatch();
		
			
			//valores de la inserción
			pst.setString(1, "Música 1º");
			pst.setString(2, "No he estudiado música en mi vida");
			pst.setInt(3, 2025);
			//addBatch alamecena las sentencias para ejecutarlas al mismo tiempo
			pst.addBatch();
	
			
			//valores de la inserción
			pst.setString(1, "Tecnología 1º");
			pst.setString(2, "Más enseñarnos a arreglar un enchufe y menos escuadra y cartabón");
			pst.setInt(3, 2025);
			//addBatch alamecena las sentencias para ejecutarlas al mismo tiempo
			pst.addBatch();
			
			
			//guardamos cuantas filas se han modificado
			res = pst.executeBatch();
			
			// imprimimos la respuesta
			System.out.println("Filas modificadas " + res.length);

			// capturamos excepción sql
		} catch (SQLException e) {
			// mensajito error
			System.out.println("Error con la base de datos " + e.getMessage());
		}
	}

}

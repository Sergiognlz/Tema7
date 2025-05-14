package ejercicio5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utiles.Constantes;

public class Ejercicio5 {
public static void main(String[] args) {
	//array de int donde guardaremos las filas modificadas
			int res[];
			
			// conexión con la base de datos dentro de un try catch
			try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {
		

				// guardamos la sentencia insert por agilizar con los datos que vamos a insertar
				String insert = "INSERT INTO Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion)" +""
						+ "VALUES (?, ?, ?, ?, ?, ?)";


				// sentencia paremetrizada creando objeto de tipo PreparedStantement y le pasamos la sentencia insert
				PreparedStatement pst = con.prepareStatement(insert);
			
				//valores de la inserción
				pst.setInt(1, 9);
				pst.setInt(2, 5);
				pst.setInt(3, 1);
				pst.setString(4,"Examen");
				pst.setDouble(5, 3.5);
				pst.setString(6,"2025-01-010");
				//addBatch alamecena las sentencias para ejecutarlas al mismo tiempo
				pst.addBatch();
				
				//valores de la inserción
				pst.setInt(1, 10);
				pst.setInt(2, 5);
				pst.setInt(3, 1);
				pst.setString(4,"Examen");
				pst.setDouble(5, 2.5);
				pst.setString(6,"2025-01-010");
				//addBatch alamecena las sentencias para ejecutarlas al mismo tiempo
				pst.addBatch();
				
				//valores de la inserción
				pst.setInt(1, 11);
				pst.setInt(2, 5);
				pst.setInt(3, 1);
				pst.setString(4,"Examen");
				pst.setDouble(5, 4.5);
				pst.setString(6,"2025-01-010");
				//addBatch alamecena las sentencias para ejecutarlas al mismo tiempo
				pst.addBatch();
				
				//valores de la inserción
				pst.setInt(1, 12);
				pst.setInt(2, 5);
				pst.setInt(3, 1);
				pst.setString(4,"Examen");
				pst.setDouble(5, 5.5);
				pst.setString(6,"2025-01-010");
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

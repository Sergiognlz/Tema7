package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
import utiles.Constantes;
=======
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.mysql.cj.xdevapi.Statement;
>>>>>>> branch 'master' of https://github.com/Sergiognlz/Tema7.git

public class Ejercicio1 {
	public static void main(String[] args) {

		// conexión con la base de datos dentro de un try catch
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASEÑA)) {
			// consulta de media de nota donde tenemos en cuenta el id del curso y la nota
			String mediaNotas = "select * from calificaciones where id_curso=? and nota>?";

			// guardamos la sentencia insert por agilizar con los datos que vamos a insertar
			String insert = "insert into estudiantes(nombre, apellido, fecha_nacimiento, email, telefono)"
					+ "values(?,?,?,?,?)";

			// sentencia delete
			String delete = "delete from estudiantes where nombre='Paco'";

			// sentencia paremetrizada creando objeto de tipo PreparedStantement
			PreparedStatement pst = con.prepareStatement(mediaNotas);
			// le indicamos que le primer interrogante que asignamos(el 1) y que el valor
			// que le corresponde es 2
			pst.setInt(1, 2);
			// le indicamos que le primer interrogante que asignamos(el 2) y que el valor
			// que le corresponde es 8
			pst.setDouble(2, 8);

			// guardamos el resultado de la consulta
			ResultSet rs = pst.executeQuery();

			// recorremos el resultado
			while (rs.next()) {
				// imprimimos el getInt(el tipo) de la columna 2 que equivale a la id de
				// estudiante
				System.out.print("ID estudiante: " + rs.getInt(2) + " ");
				// imprimimos el getInt (el tipo) de la columna 3 que equivale a la ide de curso
				System.out.print("ID curso: " + rs.getInt(3) + " ");
				// imprimimos el getDouble (el tipo) de la columna 6 la nota media
				System.out.println("Nota media: " + rs.getDouble(6));
			}

			// objeto PreparedStatment y le pasamos el primer insert
			pst = con.prepareStatement(insert);
			//valores de la inserción
			pst.setString(1, "Elva");
			pst.setString(2, "Ginón");
			pst.setString(3, "2005-04-18");
			pst.setString(4, "muchamarcha@gmail.com");
			pst.setString(5, "6547483823");
			//guardamos cuantas filas se han modificado
			int res = pst.executeUpdate();

			// objeto PreparedStatment y le pasamos el primer insert
			pst = con.prepareStatement(insert);
			//valores de la inserción
			pst.setString(1, "Manolo");
			pst.setString(2, "El del Bombo");
			pst.setString(3, "1095-03-10");
			pst.setString(4, "bombo@gmail.com");
			pst.setString(5, "652782663");
			
			//sumamos las filas modificadas
			res += pst.executeUpdate();

			// objeto PreparedStatment y le pasamos el primer insert
			pst = con.prepareStatement(insert);
			pst.setString(1, "María");
			pst.setString(2, "Unpajote");
			pst.setString(3, "2005-01-01");
			pst.setString(4, "maritrini@gmail.com");
			pst.setString(5, "736782663");
			
			//sumamos filas modificadas
			res += pst.executeUpdate();

			// imprimimos la respuesta
			System.out.println("Fila modificada " + res);

			// capturamos excepción sql
		} catch (SQLException e) {
			// mensajito error
			System.out.println("Error con la base de datos " + e.getMessage());
		}
	}

}

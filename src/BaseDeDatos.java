

import java.sql.Connection; //---se encarga de la conexion
import java.sql.DriverManager; //---se encarga de la administracion de los drivers (conexiones cn la BD)
import java.sql.PreparedStatement; //---relacionada a las consultas
import java.sql.SQLException; /*---se encarga de capturar las excepciones que pudieran ocurrir de tipo SQL 
								ej: en la insersion de un dato, en la busqueda de un dato, etc. Esta clase no indica dnd ocurre el prob */

public class BaseDeDatos {

	public static void agregarClienteALaTabla(String nombre, String apellido, String telefono, String mail,
			String direccion, String localidad) throws SQLException, ClassNotFoundException {
		/*----
		 * ese "throws" de ah� arriba se refiere a los problemas que se pueden
		 * presentar, ej que no encuentre la base de datos (mal escrito el nombre, no
		 * hay conexion, no encuentre la BD, etc.) cm son infinitos los problemas
		 * "dejo q se ocupe el programa", no puedo crear tantos ifs p resolverlo yo no
		 * simplifica el problema (la excepcion) q se puede llegar a generar.-- Me avisa
		 * por donde va el prob, de q tipo es y dps yo me encargo de encontrar el prob
		 * puntual, me orienta por donde
		 */

try { // ---un intento de ejecucion. Ejecuta el c�digo q puede llegar a generar una
				// excepci�n
				// Creo la conexi�n a la base de datos dando como par�metro el String de
				// conexi�n y el Driver
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/abm";
			Class.forName(myDriver);
			// Doy los par�metros necesarios para la conexi�n con la BD, usuario y
			// contrase�a
			Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
			String query = "insert into cliente (nombre, apellido, telefono, mail, direccion, localidad)"
					+ " values (?, ?, ?, ?, ?, ?)"; // estos valores no tienen nd q ver cn los parametros q tan +
													// arriba, estos son los de la BD

			// insert mediante preparedStatement donde doy como par�metro el query y los
			// valores del objeto cliente
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, nombre);
			preparedStmt.setString(2, apellido);
			preparedStmt.setString(3, telefono);
			preparedStmt.setString(4, mail);
			preparedStmt.setString(5, direccion);
			preparedStmt.setString(6, localidad);

			// --(Reci�n ac�)--Ejecuto el preparedStatement, de esta manera, inserto los valores
			// a la base
			// de datos. Todo lo de arriba es una preparaci�n
			preparedStmt.executeUpdate();
			// cierro la conexi�n.
			conn.close();
		} catch (SQLException e) { // lo que quiero q haga el c�digo en caso d q c genere la excepci�n
			// log the exception
			System.out.println("Se ha generado la siguiente excepci�n:");
			System.out.println(e.getMessage());
		}
	}

	// Realizamos update, sincronizamos valores de la tabla, con nuevos valores
	// dados como par�metro.
	public static void updateClientePorID(int id, String nombre, String apellido, String telefono, String mail,
			String direccion, String localidad) throws SQLException, ClassNotFoundException {
		try {
			// Creo la conexi�n a la base de datos dando como par�metro el String de
			// conexi�n y el Driver
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/abm";
			Class.forName(myDriver);
			// Doy los par�metros necesarios para la conexi�n con la BD, usuario y
			// contrase�a
			Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
			// Query de inserci�n de datos en la tabla cliente
			String query = "UPDATE cliente SET nombre = ?, apellido = ?, telefono=? , mail = ?, direccion = ?, localidad = ?  WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, telefono);
			ps.setString(4, mail);
			ps.setString(5, direccion);
			ps.setString(6, localidad);
			ps.setInt(7, id);

			ps.executeUpdate();
			ps.close();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Se ha generado la siguiente excepci�n:");
			System.out.println(e.getMessage());

		}
	}

	// borrar tabla contenido tabla Clientes
	public static void borrarTodosLosRegistrosDeLaTablaClientes() throws SQLException, ClassNotFoundException {
		try {
			// Creo la conexi�n a la base de datos dando como par�metro el String de
			// conexi�n y el Driver
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/abm";
			Class.forName(myDriver);
			// Doy los par�metros necesarios para la conexi�n con la BD, usuario y
			// contrase�a
			Connection conn = DriverManager.getConnection(myUrl, "root", "");

			String sql = "DELETE FROM cliente";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.executeUpdate();
			conn.close();

		} catch (SQLException s) {
			System.out.println("No se pudo ejecutar el SQL!");
		}
	}

	
}
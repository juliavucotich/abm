
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

public class Ejecutable {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Cliente c1 = new Cliente("Juan", "Perez", "4224620", "jp@live.com", "Av. Real 91", "Rosario");
		System.out.println("Nombre del cliente: " + c1.getNombre());

		BaseDeDatos bd = new BaseDeDatos();
		bd.agregarClienteALaTabla(c1.getNombre(), c1.getApellido(), c1.getTelefono(), c1.getMail(), c1.getDireccion(), c1.getLocalidad());
	}
}

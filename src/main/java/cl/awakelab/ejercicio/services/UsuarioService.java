package cl.awakelab.ejercicio.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.ejercicio.conexion.DBConnection;
import cl.awakelab.ejercicio.model.entity.Administrativo;
import cl.awakelab.ejercicio.model.entity.Cliente;
import cl.awakelab.ejercicio.model.entity.Profesional;
import cl.awakelab.ejercicio.model.entity.Usuario;

public class UsuarioService {

	public List<Usuario> getUsersByType(String tipoUsuario) {
		List<Usuario> usuarios = new ArrayList<>();
		DBConnection conexion = DBConnection.getInstance();
		String sql = "";

		switch (tipoUsuario) {
		case "cliente":
			sql = "SELECT * FROM usuarios u JOIN clientes c ON u.id_usuario = c.id_usuario";

			try {
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					String nombre = rs.getString("nombre");
					String fecha = rs.getString("fecha");
					int run = rs.getInt("run");
					String telefono = rs.getString("telefono");
					String afp = rs.getString("afp");
					String sistemaSalud = rs.getString("sistema_salud");
					String direccion = rs.getString("direccion");
					String comuna = rs.getString("comuna");

					Cliente cliente = new Cliente(nombre, fecha, run, telefono, afp, sistemaSalud, direccion, comuna);
					usuarios.add(cliente);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return usuarios;

		case "administrativo":
			sql = "SELECT * FROM usuarios u JOIN administrativos a ON u.id_usuario = a.id_usuario";
			System.out.println(sql);
			try {
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					String nombre = rs.getString("nombre");
					String fecha = rs.getString("fecha");
					int run = rs.getInt("run");
					String area = rs.getString("area");
					String experienciaPrevia = rs.getString("experiencia_previa");

					Administrativo administrativo = new Administrativo(nombre, fecha, run, area, experienciaPrevia);
					usuarios.add(administrativo);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return usuarios;
		case "profesional":
			sql = "SELECT * FROM usuarios u JOIN profesionales p ON u.id_usuario = p.id_usuario";

			try {
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					String nombre = rs.getString("nombre");
					String fecha = rs.getString("fecha");
					int run = rs.getInt("run");
					String titulo = rs.getString("titulo");
					String fechaIngreso = rs.getString("fecha_ingreso");

					Profesional profesional = new Profesional(nombre, fecha, run, titulo, fechaIngreso);
					usuarios.add(profesional);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(usuarios);
			return usuarios;

		default:
			throw new IllegalArgumentException("Tipo de usuario no válido");
		}
	}

	public void crearUsuario(Usuario usuario) {
		DBConnection conexion = DBConnection.getInstance();
		String sql = "INSERT INTO usuarios (nombre, fecha, run) VALUES (?, ?, ?)";

		try (PreparedStatement statement = conexion.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getFecha());
			statement.setInt(3, usuario.getRun());

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet generatedKeys = statement.getGeneratedKeys();
				int idUsuario = -1;
				if (generatedKeys.next()) {
					idUsuario = generatedKeys.getInt(1);
				}

				if (usuario instanceof Cliente) {
					Cliente cliente = (Cliente) usuario;
					sql = "INSERT INTO clientes (id_usuario, telefono, afp, sistema_salud, direccion, comuna) "
							+ "VALUES (?, ?, ?, ?, ?, ?)";
					try (PreparedStatement clienteStatement = conexion.getConnection().prepareStatement(sql)) {
						clienteStatement.setInt(1, idUsuario);
						clienteStatement.setString(2, cliente.getTelefono());
						clienteStatement.setString(3, cliente.getAfp());
						clienteStatement.setString(4, cliente.getSistemaSalud());
						clienteStatement.setString(5, cliente.getDireccion());
						clienteStatement.setString(6, cliente.getComuna());
						clienteStatement.executeUpdate();
					}
					System.out.println("Usuario cliente creado exitosamente");
				} else if (usuario instanceof Administrativo) {
					Administrativo administrativo = (Administrativo) usuario;
					sql = "INSERT INTO administrativos (id_usuario, area, experiencia_previa) " + "VALUES (?, ?, ?)";
					try (PreparedStatement administrativoStatement = conexion.getConnection().prepareStatement(sql)) {
						administrativoStatement.setInt(1, idUsuario);
						administrativoStatement.setString(2, administrativo.getArea());
						administrativoStatement.setString(3, administrativo.getExperienciaPrevia());
						administrativoStatement.executeUpdate();
					}
					System.out.println("Usuario administrativo creado exitosamente");
				} else if (usuario instanceof Profesional) {
					Profesional profesional = (Profesional) usuario;
					sql = "INSERT INTO profesionales (id_usuario, titulo, fecha_ingreso) " + "VALUES (?, ?, ?)";
					try (PreparedStatement profesionalStatement = conexion.getConnection().prepareStatement(sql)) {
						profesionalStatement.setInt(1, idUsuario);
						profesionalStatement.setString(2, profesional.getTitulo());
						profesionalStatement.setString(3, profesional.getFechaIngreso());
						profesionalStatement.executeUpdate();
					}
					System.out.println("Usuario profesional creado exitosamente");
				} else {
					throw new IllegalArgumentException("Tipo de usuario no válido");
				}
			} else {
				throw new SQLException("No se pudo crear el usuario en la base de datos");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

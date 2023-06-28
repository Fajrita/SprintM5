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
					int idUsuario = rs.getInt("id_cliente");

					Cliente cliente = new Cliente(nombre, fecha, run, telefono, afp, sistemaSalud, direccion, comuna,
							idUsuario);
					usuarios.add(cliente);

				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(usuarios);
			return usuarios;

		case "administrativo":
			sql = "SELECT * FROM usuarios u JOIN administrativos a ON u.id_usuario = a.id_usuario";

			try {
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {

					String nombre = rs.getString("nombre");
					String fecha = rs.getString("fecha");
					int run = rs.getInt("run");
					String area = rs.getString("area");
					String experienciaPrevia = rs.getString("experiencia_previa");
					int idUsuario = rs.getInt("id");

					Administrativo administrativo = new Administrativo(nombre, fecha, run, area, experienciaPrevia,
							idUsuario);
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
					int idUsuario = rs.getInt("id_profesional");

					Profesional profesional = new Profesional(nombre, fecha, run, titulo, fechaIngreso, idUsuario);
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
					sql = "INSERT INTO clientes (telefono, afp, sistema_salud, direccion, comuna, id_usuario) "
							+ "VALUES (?, ?, ?, ?, ?, ?)";
					try (PreparedStatement clienteStatement = conexion.getConnection().prepareStatement(sql)) {

						clienteStatement.setString(1, cliente.getTelefono());
						clienteStatement.setString(2, cliente.getAfp());
						clienteStatement.setString(3, cliente.getSistemaSalud());
						clienteStatement.setString(4, cliente.getDireccion());
						clienteStatement.setString(5, cliente.getComuna());
						clienteStatement.setInt(6, idUsuario);
						clienteStatement.executeUpdate();
					}
					System.out.println("Usuario cliente creado exitosamente");
				} else if (usuario instanceof Administrativo) {
					Administrativo administrativo = (Administrativo) usuario;
					sql = "INSERT INTO administrativos (area, experiencia_previa, id_usuario) " + "VALUES (?, ?, ?)";
					try (PreparedStatement administrativoStatement = conexion.getConnection().prepareStatement(sql)) {

						administrativoStatement.setString(1, administrativo.getArea());
						administrativoStatement.setString(2, administrativo.getExperienciaPrevia());
						administrativoStatement.setInt(3, idUsuario);
						administrativoStatement.executeUpdate();
					}
					System.out.println("Usuario administrativo creado exitosamente");
				} else if (usuario instanceof Profesional) {
					Profesional profesional = (Profesional) usuario;
					sql = "INSERT INTO profesionales (titulo, fecha_ingreso, id_usuario) " + "VALUES (?, ?, ?)";
					try (PreparedStatement profesionalStatement = conexion.getConnection().prepareStatement(sql)) {

						profesionalStatement.setString(1, profesional.getTitulo());
						profesionalStatement.setString(2, profesional.getFechaIngreso());
						profesionalStatement.setInt(3, idUsuario);
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

	public Usuario findByIdUsuario(int id, String type) {
		DBConnection conexion = DBConnection.getInstance();

		Usuario usuario = null;
		switch (type) {
		case "cliente": {
			String sql = "SELECT * FROM usuarios u JOIN clientes c ON u.id_usuario = c.id_usuario where id_cliente = ?";
			try {
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();

				if (rs.next()) {
					String nombre = rs.getString("nombre");
					String fecha = rs.getString("fecha");
					int run = rs.getInt("run");
					String telefono = rs.getString("telefono");
					String afp = rs.getString("afp");
					String sistemaSalud = rs.getString("sistema_salud");
					String direccion = rs.getString("direccion");
					String comuna = rs.getString("comuna");
					int idUsuario = rs.getInt("id_cliente");

					usuario = new Cliente(nombre, fecha, run, telefono, afp, sistemaSalud, direccion, comuna,
							idUsuario);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return usuario;
		}
		case "administrativo": {
			String sql = "SELECT * FROM usuarios u JOIN administrativos a ON u.id_usuario = a.id_usuario where id = ?";
			try {
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();

				if (rs.next()) {
					String nombre = rs.getString("nombre");
					String fecha = rs.getString("fecha");
					int run = rs.getInt("run");
					String area = rs.getString("area");
					String experienciaPrevia = rs.getString("experiencia_previa");
					int idUsuario = rs.getInt("id");
					System.out.println("el nombre es: " + nombre);

					usuario = new Administrativo(nombre, fecha, run, area, experienciaPrevia, idUsuario);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return usuario;

		}
		case "profesional": {
			String sql = "SELECT * FROM usuarios u JOIN profesionales p ON u.id_usuario = p.id_usuario where id_profesional = ?";
			try {
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();

				if (rs.next()) {
					String nombre = rs.getString("nombre");
					String fecha = rs.getString("fecha");
					int run = rs.getInt("run");
					String titulo = rs.getString("titulo");
					String fechaIngreso = rs.getString("fecha_ingreso");
					int idUsuario = rs.getInt("id_profesional");

					usuario = new Profesional(nombre, fecha, run, titulo, fechaIngreso, idUsuario);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return usuario;

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}

	}

	public void updateUsuario(Usuario usuario, int id) {
		DBConnection conexion = DBConnection.getInstance();
		String sql;

		if (usuario instanceof Cliente) {
			Cliente cliente = (Cliente) usuario;
			sql = "UPDATE clientes SET telefono = ?, afp = ?, sistema_salud = ?, direccion = ?, comuna = ? WHERE id_cliente = ?";
			try (PreparedStatement clienteStatement = conexion.getConnection().prepareStatement(sql)) {
				clienteStatement.setInt(6, id);
				clienteStatement.setString(1, cliente.getTelefono());
				clienteStatement.setString(2, cliente.getAfp());
				clienteStatement.setString(3, cliente.getSistemaSalud());
				clienteStatement.setString(4, cliente.getDireccion());
				clienteStatement.setString(5, cliente.getComuna());
				clienteStatement.setInt(6, cliente.getIdUsuario());
				clienteStatement.executeUpdate();

				sql = "UPDATE usuarios SET nombre = ?, fecha = ? WHERE run = ?";
				try (PreparedStatement statement = conexion.getConnection().prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS)) {

					statement.setString(1, usuario.getNombre());
					statement.setString(2, usuario.getFecha());
					statement.setInt(3, usuario.getRun());

					statement.executeUpdate();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Usuario cliente updated exitosamente");
		} else if (usuario instanceof Administrativo) {
			Administrativo administrativo = (Administrativo) usuario;
			sql = "UPDATE administrativos SET  area = ?, experiencia_previa = ? WHERE id = ?";

			try (PreparedStatement administrativoStatement = conexion.getConnection().prepareStatement(sql)) {

				administrativoStatement.setString(1, administrativo.getArea());
				administrativoStatement.setString(2, administrativo.getExperienciaPrevia());
				administrativoStatement.setInt(3, administrativo.getIdUsuario());
				administrativoStatement.executeUpdate();

				sql = "UPDATE usuarios SET nombre = ?, fecha = ? WHERE run = ?";
				try (PreparedStatement statement = conexion.getConnection().prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS)) {

					statement.setString(1, usuario.getNombre());
					statement.setString(2, usuario.getFecha());
					statement.setInt(3, usuario.getRun());

					statement.executeUpdate();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Usuario administrativo updated exitosamente");

		} else if (usuario instanceof Profesional) {
			Profesional profesional = (Profesional) usuario;
			sql = "UPDATE profesionales SET  titulo = ?, fecha_ingreso = ? WHERE id_profesional = ?";
			try (PreparedStatement profesionalStatement = conexion.getConnection().prepareStatement(sql)) {

				profesionalStatement.setString(1, profesional.getTitulo());
				profesionalStatement.setString(2, profesional.getFechaIngreso());
				profesionalStatement.setInt(3, profesional.getIdUsuario());
				profesionalStatement.executeUpdate();

				sql = "UPDATE usuarios SET nombre = ?, fecha = ? WHERE run = ?";
				try (PreparedStatement statement = conexion.getConnection().prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS)) {

					statement.setString(1, usuario.getNombre());
					statement.setString(2, usuario.getFecha());
					statement.setInt(3, usuario.getRun());

					statement.executeUpdate();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
			System.out.println("Usuario profesional updated exitosamente");

		} else

		{
			System.out.println("No se pudo crear el usuario en la base de datos");
		}

	}
}

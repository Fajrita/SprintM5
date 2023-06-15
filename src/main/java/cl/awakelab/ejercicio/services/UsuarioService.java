package cl.awakelab.ejercicio.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.ejercicio.conexion.DBConnection;
import cl.awakelab.ejercicio.model.entity.Administrativo;
import cl.awakelab.ejercicio.model.entity.Cliente;
import cl.awakelab.ejercicio.model.entity.Profesional;
import cl.awakelab.ejercicio.model.entity.Usuario;

public class UsuarioService {

	public List<Usuario> getUsersByType(String tipoUsuario) {

		System.out.println("list usuario");

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
					int sistemaSalud = rs.getInt("sistema_salud");
					String direccion = rs.getString("direccion");
					String comuna = rs.getString("comuna");

					Cliente cliente = new Cliente(nombre, fecha, run, telefono, afp, sistemaSalud, direccion,
							comuna);
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
}


/*

public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public List<Usuario> obtenerUsuariosPorTipo(String tipoUsuario) {
        // Aquí realizarás la lógica para obtener la lista de usuarios según el tipo
        // Puedes utilizar consultas SQL, JPA o cualquier otro mecanismo de persistencia
        
List<Usuario> usuarios = new ArrayList<>();
        
        // Ejemplo de implementación utilizando consultas SQL directas
        String query = "";
        switch (tipoUsuario) {
            case "cliente":
                query = "SELECT u.*, c.* FROM usuarios u JOIN clientes c ON u.id = c.usuario_id";
                break;
            case "administrativo":
                query = "SELECT u.*, a.* FROM usuarios u JOIN administrativos a ON u.id = a.usuario_id";
                break;
            case "profesional":
                query = "SELECT u.*, p.* FROM usuarios u JOIN profesionales p ON u.id = p.usuario_id";
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuario no válido");
        }
        
        // Ejecutar la consulta y obtener los resultados
        try (Connection conn = obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("u.id"));
                usuario.setNombre(rs.getString("u.nombre"));
                // ... setear el resto de las propiedades del usuario
                
                switch (tipoUsuario) {
                    case "cliente":
                        Cliente cliente = new Cliente();
                        cliente.setId(rs.getInt("c.id"));
                        // ... setear las propiedades adicionales de cliente
                        usuario.setCliente(cliente);
                        break;
                    case "administrativo":
                        Administrativo administrativo = new Administrativo();
                        administrativo.setId(rs.getInt("a.id"));
                        // ... setear las propiedades adicionales de administrativo
                        usuario.setAdministrativo(administrativo);
                        break;
                    case "profesional":
                        Profesional profesional = new Profesional();
                        profesional.setId(rs.getInt("p.id"));
                        // ... setear las propiedades adicionales de profesional
                        usuario.setProfesional(profesional);
                        break;
                }
                
                usuarios.add(usuario);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return usuarios;
    }
        private Connection obtenerConexion() throws SQLException {
        // Aquí obtén tu objeto de conexión a la base de datos
        return DriverManager.getConnection("tu_url_de_conexion", "usuario", "contraseña");
    }
}

*/
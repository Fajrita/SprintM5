package cl.awakelab.ejercicio.controller;

import java.util.List;
import java.sql.PreparedStatement;
import com.google.gson.Gson;

import cl.awakelab.ejercicio.controller.interfaces.ICapacitacionController;
import cl.awakelab.ejercicio.model.entity.Capacitacion;
import cl.awakelab.ejercicio.services.CapacitacionService;
import cl.awakelab.ejercicio.conexion.DBConnection;

public class CapacitacionController implements ICapacitacionController {

	CapacitacionService capacitacionService = new CapacitacionService();

	@Override
	public List<Capacitacion> findAllCapacitaciones() {
		return capacitacionService.findAllCapacitaciones();
	}

	public String createCapacitacion(String rutCliente, String dia, String hora, String lugar, int duracion,
			int cantidadAsistentes) {
		Gson gson = new Gson();
		DBConnection conexion = DBConnection.getInstance();

		String sql = "INSERT INTO capacitaciones (rut_cliente, dia, hora, lugar, duracion, cantidad_asistentes) VALUES (?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			statement.setString(1, rutCliente);
			statement.setString(2, dia);
			statement.setString(3, hora);
			statement.setString(4, lugar);
			statement.setInt(5, duracion);
			statement.setInt(6, cantidadAsistentes);

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected > 0) {
				Capacitacion capacitacion = new Capacitacion();
				return gson.toJson(capacitacion);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "false";
	}
}

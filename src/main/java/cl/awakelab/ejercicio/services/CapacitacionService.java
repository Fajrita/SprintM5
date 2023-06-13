package cl.awakelab.ejercicio.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cl.awakelab.ejercicio.conexion.DBConnection;
import cl.awakelab.ejercicio.model.entity.Capacitacion;

public class CapacitacionService {

	public List<Capacitacion> findAllCapacitaciones() {

		System.out.println("list capacitacion");

		List<Capacitacion> capacitaciones = new ArrayList<>();
		DBConnection conexion = DBConnection.getInstance();
		String sql = "SELECT * FROM capacitaciones";

		try {

			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");

				String rutCliente = rs.getString("rut_cliente");

				String dia = rs.getString("dia");
				String hora = rs.getString("hora");
				String lugar = rs.getString("lugar");
				int duracion = rs.getInt("duracion");

				int cantidadAsistentes = rs.getInt("cantidad_asistentes");

				Capacitacion capacitacion = new Capacitacion(id, rutCliente, dia, hora, lugar, duracion,
						cantidadAsistentes);
				capacitaciones.add(capacitacion);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return capacitaciones;
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

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
		return capacitacionService.createCapacitacion(rutCliente, dia, hora, lugar, duracion, cantidadAsistentes);
	}

}

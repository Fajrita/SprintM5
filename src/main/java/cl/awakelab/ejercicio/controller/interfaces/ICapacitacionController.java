package cl.awakelab.ejercicio.controller.interfaces;

import java.util.List;

import cl.awakelab.ejercicio.model.entity.Capacitacion;

public interface ICapacitacionController {
	
	public List<Capacitacion> findAllCapacitaciones();
	
	public String createCapacitacion(String rutCliente, String dia, String hora, String lugar, int duracion,
			int cantidadAsistentes);
	
//	public void deleteTrainingById();
//	
//	public Training updateTraining(Training training);
	

}

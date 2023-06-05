package cl.awakelab.ejercicio.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.ejercicio.conexion.DBConnection;
import cl.awakelab.ejercicio.model.entity.Capacitacion;

public class CapacitacionService {
	

	 public List<Capacitacion> findAllCapacitaciones() {
	    
	    List<Capacitacion> capacitaciones = new ArrayList<>();
	    DBConnection conexion = DBConnection.getInstance();
	    String sql = "SELECT * FROM capacitaciones";
	    
	    try {
	      
	      PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
	      ResultSet rs = statement.executeQuery();
	      
	      while(rs.next()) {
	        int id = rs.getInt("id");
	        String rutCliente = rs.getString("rutCliente");
	        String dia = rs.getString("dia");
	        String hora = rs.getString("hora"); 
	        String lugar = rs.getString("lugar");
	        int duracion = rs.getInt("duracion");
	        int cantidadAsistentes = rs.getInt("cantidadAsistentes");
	        Capacitacion capacitacion = new Capacitacion(id, rutCliente, dia, hora, lugar, duracion, cantidadAsistentes);
	        capacitaciones.add(capacitacion);
	      
	      }
	      
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	    return capacitaciones;
	  }
	 
	 
	 public Capacitacion createCapacitacion() {
		 
		 Capacitacion capacitacion = new Capacitacion();
		 
		 //ver lo ingresado en el formulario, via javascript??
		 
		 
		 return capacitacion;
	 }

}

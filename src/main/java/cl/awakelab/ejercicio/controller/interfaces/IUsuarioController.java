package cl.awakelab.ejercicio.controller.interfaces;

import java.util.List;
import cl.awakelab.ejercicio.model.entity.Usuario;

public interface IUsuarioController {

	public List<Usuario> getUsersByType(String tipoUsuario);

	public void crearUsuario(Usuario usuario);

	public Usuario findByIdUsuario(int id, String type);

	public void updateUsuario(Usuario usuario, int id);
}

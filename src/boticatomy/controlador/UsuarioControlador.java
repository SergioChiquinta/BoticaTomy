package boticatomy.controlador;

import boticatomy.modelo.UsuarioModeloLogin;
import java.sql.SQLException;
import boticatomy.controlador.UsuarioActual;

public class UsuarioControlador {

    private UsuarioModeloLogin usuarioModelo;

    public UsuarioControlador() {
        this.usuarioModelo = new UsuarioModeloLogin();
    }

    public boolean autenticar(String correoOusuario, String contraseña) throws SQLException {
        UsuarioActual usuario = usuarioModelo.autenticar(correoOusuario, contraseña);
        if (usuario != null) {
            UsuarioActual usuarioActual = UsuarioActual.getInstancia();
            usuarioActual.setIdUsuario(usuario.getIdUsuario());
            usuarioActual.setNombreUsuario(usuario.getNombreUsuario());
            usuarioActual.setCorreoUsuario(usuario.getCorreoUsuario());
            usuarioActual.setDni(usuario.getDni());
            usuarioActual.setTipoUsuario(usuario.getTipoUsuario());
            // Configura más campos si es necesario
            return true;
        } else {
            return false;
        }
    }

}

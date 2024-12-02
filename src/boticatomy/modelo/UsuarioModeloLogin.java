package boticatomy.modelo;

import boticatomy.controlador.UsuarioActual;
import java.sql.*;

public class UsuarioModeloLogin {

    public UsuarioActual autenticar(String correoOusuario, String contraseña) throws SQLException {
        try (Connection con = Conexion.getConexion()) {
            String query = "SELECT * FROM USUARIO WHERE (EMA_USU = ? OR NOM_USU = ?) AND CON_USU = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, correoOusuario);
            ps.setString(2, correoOusuario);
            ps.setString(3, contraseña);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UsuarioActual usuario = new UsuarioActual();
                usuario.setIdUsuario(rs.getString("ID_USU"));
                usuario.setNombreUsuario(rs.getString("NOM_USU"));
                usuario.setCorreoUsuario(rs.getString("EMA_USU"));
                usuario.setDni(obtenerDniUsuario(rs.getString("ID_USU"))); // Obtener DNI del usuario
                usuario.setTipoUsuario(rs.getString("TIP_USU"));
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error en la Base de Datos");
        }
    }

    private String obtenerDniUsuario(String idUsuario) throws SQLException {
        try (Connection con = Conexion.getConexion()) {
            String query = "SELECT DNI_CLI FROM CLIENTE WHERE ID_USU = ? UNION SELECT DNI_TRA FROM TRABAJADOR WHERE ID_USU = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, idUsuario);
            ps.setString(2, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString(1);
            } else {
                throw new SQLException("DNI no encontrado para el usuario");
            }
        }
    }

}


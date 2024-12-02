
package boticatomy.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioModeloRegistro {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String correo;
    private String contraseña;
    private String tipo;

    // Constructor
    public UsuarioModeloRegistro(String nombre, String apellido, String dni, String telefono, String correo, String contraseña, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    // Getters y setters...
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public static boolean validarDNI(String dni) {
        return dni.matches("\\d{8}");
    }

    public static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{9}");
    }

    public static boolean validarCorreo(String correo) {
        return correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean dniExiste(Connection con, String dni) throws SQLException {
        String query = "SELECT COUNT(*) AS total FROM CLIENTE WHERE DNI_CLI = ? UNION ALL SELECT COUNT(*) FROM TRABAJADOR WHERE DNI_TRA = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, Integer.parseInt(dni));
            ps.setInt(2, Integer.parseInt(dni));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt("total");
                    return total > 0;
                }
            }
        }
        return false;
    }

    public static int generarIDUsuario(Connection con) throws SQLException {
        String query = "SELECT MAX(ID_USU) AS UltimoID FROM USUARIO";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt("UltimoID") + 1;
            }
        }
        return 1;
    }

    public static void registrarUsuario(UsuarioModeloRegistro usuario) throws SQLException {
        try (Connection con = Conexion.getConexion()) {
            if (!validarDNI(usuario.getDni())) {
                throw new IllegalArgumentException("El DNI debe contener 8 dígitos numéricos");
            }

            if (!validarTelefono(usuario.getTelefono())) {
                throw new IllegalArgumentException("El teléfono debe contener 9 dígitos numéricos");
            }

            if (!validarCorreo(usuario.getCorreo())) {
                throw new IllegalArgumentException("El formato del correo electrónico no es válido");
            }

            if (dniExiste(con, usuario.getDni())) {
                throw new IllegalArgumentException("El DNI ya está asociado a una cuenta existente");
            }

            int idUsuario = generarIDUsuario(con);
            String query = "INSERT INTO usuario (ID_USU, NOM_USU, APE_USU, TIP_USU, TEL_USU, EMA_USU, CON_USU) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, idUsuario);
                ps.setString(2, usuario.getNombre());
                ps.setString(3, usuario.getApellido());
                ps.setString(4, usuario.getTipo());
                ps.setString(5, usuario.getTelefono());
                ps.setString(6, usuario.getCorreo());
                ps.setString(7, usuario.getContraseña());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected != 1) {
                    throw new SQLException("Error al registrar el usuario");
                }

                if ("Cliente".equals(usuario.getTipo())) {
                    query = "INSERT INTO CLIENTE (DNI_CLI, ID_USU) VALUES (?, ?)";
                } else {
                    query = "INSERT INTO TRABAJADOR (DNI_TRA, ID_USU) VALUES (?, ?)";
                }

                try (PreparedStatement ps2 = con.prepareStatement(query)) {
                    ps2.setString(1, usuario.getDni());
                    ps2.setInt(2, idUsuario);
                    ps2.executeUpdate();
                }
            }
        }
    }
}

package boticatomy.controlador;

public class UsuarioActual {
    private static UsuarioActual instancia; // Instancia única de la clase UsuarioActual
    private String tipoUsuario; // Tipo de usuario (Cliente, Administrador, etc.)
    private String nombreUsuario; // Nombre del usuario
    private String correoUsuario; // Correo electrónico del usuario
    private String dni; // DNI del usuario
    private String idUsuario; // Identificador único del usuario

    public UsuarioActual() {
        // Constructor privado para evitar instanciación directa
    }

    // Método estático para obtener la única instancia de UsuarioActual
    public static UsuarioActual getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioActual(); // Crear la instancia si es la primera vez que se llama
        }
        return instancia;
    }

    // Métodos getter y setter para cada atributo
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}

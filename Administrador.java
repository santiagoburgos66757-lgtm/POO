import java.util.ArrayList;
import java.util.List;

/**
 * Representa un usuario Administrador del sistema con permisos especiales
 * Hereda de Usuario y agrega funcionalidad específica para administradores
 */
public class Administrador extends Usuario {
    private String nivel; // "Super", "Moderador", "Soporte"
    private List<String> permisos;
    private String departamento;

    public Administrador() {
        super();
        setTipoUsuario("Administrador");
        this.nivel = "Soporte";
        this.permisos = new ArrayList<>();
        this.departamento = "";
    }

    public Administrador(String id, String nombre, String email, String password, String telefono,
                        String nivel, String departamento) {
        super(id, nombre, email, password, telefono, "Administrador");
        this.nivel = nivel;
        this.departamento = departamento;
        this.permisos = new ArrayList<>();
        inicializarPermisosPorNivel();
    }

    /**
     * Inicializa los permisos según el nivel del administrador
     */
    private void inicializarPermisosPorNivel() {
        permisos.clear();
        switch (nivel) {
            case "Super":
                permisos.add("GESTIONAR_USUARIOS");
                permisos.add("GESTIONAR_CONTENIDO");
                permisos.add("GESTIONAR_SISTEMA");
                permisos.add("VER_REPORTES");
                permisos.add("MODIFICAR_PLANTILLAS");
                break;
            case "Moderador":
                permisos.add("GESTIONAR_CONTENIDO");
                permisos.add("VER_REPORTES");
                permisos.add("MODIFICAR_PLANTILLAS");
                break;
            case "Soporte":
                permisos.add("VER_REPORTES");
                break;
        }
    }

    /**
     * Verifica si el administrador tiene un permiso específico
     */
    public boolean tienePermiso(String permiso) {
        return permisos.contains(permiso);
    }

    /**
     * Agrega un permiso personalizado al administrador
     */
    public boolean agregarPermiso(String permiso) {
        if (permiso != null && !permiso.isEmpty() && !permisos.contains(permiso)) {
            permisos.add(permiso);
            return true;
        }
        return false;
    }

    /**
     * Remueve un permiso del administrador
     */
    public boolean removerPermiso(String permiso) {
        return permisos.remove(permiso);
    }

    /**
     * Cambia el nivel del administrador y actualiza permisos
     */
    public void cambiarNivel(String nuevoNivel) {
        this.nivel = nuevoNivel;
        inicializarPermisosPorNivel();
    }

    // Getters y Setters
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { 
        this.nivel = nivel;
        inicializarPermisosPorNivel();
    }

    public List<String> getPermisos() { return new ArrayList<>(permisos); }
    public void setPermisos(List<String> permisos) { this.permisos = new ArrayList<>(permisos); }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    @Override
    public String toString() {
        return super.toString() + " | Nivel: " + nivel + " | Permisos: " + permisos.size();
    }
}

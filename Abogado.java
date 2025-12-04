import java.util.ArrayList;
import java.util.List;

/**
 * Representa un usuario Abogado que puede realizar revisiones jurídicas
 * Hereda de Usuario y agrega funcionalidad específica para abogados
 */
public class Abogado extends Usuario {
    private String numeroLicencia;
    private String especialidad;
    private int aniosExperiencia;
    private List<String> areasExperticia;
    private boolean disponibleParaRevisiones;

    public Abogado() {
        super();
        setTipoUsuario("Abogado");
        this.numeroLicencia = "";
        this.especialidad = "";
        this.aniosExperiencia = 0;
        this.areasExperticia = new ArrayList<>();
        this.disponibleParaRevisiones = true;
    }

    public Abogado(String id, String nombre, String email, String password, String telefono,
                   String numeroLicencia, String especialidad, int aniosExperiencia) {
        super(id, nombre, email, password, telefono, "Abogado");
        this.numeroLicencia = numeroLicencia;
        this.especialidad = especialidad;
        this.aniosExperiencia = Math.max(0, aniosExperiencia);
        this.areasExperticia = new ArrayList<>();
        this.disponibleParaRevisiones = true;
    }

    /**
     * Agrega un área de experticia al abogado
     */
    public boolean agregarAreaExperticia(String area) {
        if (area != null && !area.isEmpty() && !areasExperticia.contains(area)) {
            areasExperticia.add(area);
            return true;
        }
        return false;
    }

    /**
     * Verifica si el abogado tiene experticia en un área específica
     */
    public boolean tieneExperticia(String area) {
        return areasExperticia.contains(area);
    }

    /**
     * Establece la disponibilidad del abogado para revisiones
     */
    public void setDisponibilidad(boolean disponible) {
        this.disponibleParaRevisiones = disponible;
    }

    /**
     * Verifica si el abogado está disponible para revisiones
     */
    public boolean estaDisponible() {
        return this.disponibleParaRevisiones && this.isActivo();
    }

    // Getters y Setters
    public String getNumeroLicencia() { return numeroLicencia; }
    public void setNumeroLicencia(String numeroLicencia) { this.numeroLicencia = numeroLicencia; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { 
        if (aniosExperiencia >= 0) this.aniosExperiencia = aniosExperiencia; 
    }

    public List<String> getAreasExperticia() { return new ArrayList<>(areasExperticia); }
    public void setAreasExperticia(List<String> areasExperticia) { 
        this.areasExperticia = new ArrayList<>(areasExperticia); 
    }

    public boolean isDisponibleParaRevisiones() { return disponibleParaRevisiones; }

    @Override
    public String toString() {
        return super.toString() + " | Licencia: " + numeroLicencia + 
               " | Especialidad: " + especialidad + " | Disponible: " + disponibleParaRevisiones;
    }
}

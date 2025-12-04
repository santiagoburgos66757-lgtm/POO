import java.util.HashMap;
import java.util.Map;

/**
 * Clase de ejemplo que demuestra el uso del sistema jurídico
 * Muestra cómo interactúan las diferentes clases del proyecto
 */
public class EjemploSistemaJuridico {
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO DE USO DEL SISTEMA JURÍDICO ===\n");
        
        // 1. Crear institución educativa
        System.out.println("1. CREACIÓN DE INSTITUCIÓN EDUCATIVA");
        InstitucionEducativa universidad = new InstitucionEducativa(
            "INST-001",
            "Universidad Nacional de Colombia",
            "Carrera 30 # 45-03",
            "Bogotá",
            "Colombia",
            "+57 1 3165000",
            "info@unal.edu.co",
            "Universidad"
        );
        System.out.println(universidad);
        System.out.println();
        
        // 2. Crear rector y asociar con institución
        System.out.println("2. CREACIÓN DE RECTOR");
        Rector rector = new Rector(
            "R-001",
            "Dr. Juan Pérez",
            "rector@unal.edu.co",
            "password123",
            "+57 300 1234567",
            universidad,
            "Rector",
            "CC-12345678"
        );
        System.out.println(rector);
        System.out.println();
        
        // 3. Crear y activar membresía
        System.out.println("3. CREACIÓN DE MEMBRESÍA");
        Membresia membresia = new Membresia(
            "M-001",
            rector.getId(),
            "Premium",
            150.0,
            -1, // Consultas ilimitadas
            true // Incluye revisión humana
        );
        
        Pago pago = new Pago(
            "P-001",
            membresia.getId(),
            rector.getId(),
            150.0,
            "Tarjeta",
            "Pendiente"
        );
        pago.aprobar("TRX-123456");
        membresia.activar();
        
        System.out.println(membresia);
        System.out.println(pago);
        System.out.println();
        
        // 4. Crear consulta jurídica
        System.out.println("4. CONSULTA JURÍDICA");
        ConsultaJuridica consulta = new ConsultaJuridica(
            "C-001",
            rector.getId(),
            "¿Cuáles son los requisitos legales para crear un programa académico nuevo?",
            "Legislación educativa"
        );
        
        // Simular respuesta de IA
        RespuestaIA respuesta = new RespuestaIA(
            "RI-001",
            consulta.getId(),
            "Para crear un programa académico nuevo se requiere: 1) Registro calificado según Decreto 1075 de 2015...",
            0.85,
            "GPT-4"
        );
        respuesta.agregarFuente("Decreto 1075 de 2015 - Ministerio de Educación");
        respuesta.agregarFuente("Resolución 21795 de 2020");
        
        consulta.asignarRespuesta(respuesta);
        membresia.registrarConsulta();
        
        System.out.println(consulta);
        System.out.println(respuesta);
        System.out.println();
        
        // 5. Agregar referencias normativas
        System.out.println("5. REFERENCIAS NORMATIVAS");
        ReferenciaNormativa ref1 = new ReferenciaNormativa(
            "REF-001",
            "Decreto",
            "1075",
            "Decreto Único Reglamentario del Sector Educación",
            "2015"
        );
        ref1.setArticulo("2.5.3.2.3.2");
        ref1.setUrlFuenteOficial("https://www.mineducacion.gov.co/");
        ref1.marcarComoVerificada();
        
        consulta.agregarReferencia(ref1);
        System.out.println(ref1);
        System.out.println();
        
        // 6. Calificar respuesta
        System.out.println("6. CALIFICACIÓN DE RESPUESTA");
        Calificacion calificacion = new Calificacion(
            "CAL-001",
            consulta.getId(),
            rector.getId(),
            5
        );
        calificacion.setComentario("Excelente respuesta, muy completa y con referencias claras");
        
        System.out.println(calificacion);
        System.out.println();
        
        // 7. Generar documento desde plantilla
        System.out.println("7. GENERACIÓN DE DOCUMENTO");
        PlantillaJuridica plantilla = new PlantillaJuridica(
            "PT-001",
            "Solicitud de Registro Calificado",
            "Solicitud",
            "Educativo"
        );
        plantilla.setContenidoPlantilla(
            "SOLICITUD DE REGISTRO CALIFICADO\n\n" +
            "Nombre del programa: {{nombre_programa}}\n" +
            "Universidad: {{universidad}}\n" +
            "Representante legal: {{representante}}\n"
        );
        plantilla.agregarCampoRequerido("nombre_programa");
        plantilla.agregarCampoRequerido("universidad");
        plantilla.agregarCampoRequerido("representante");
        
        Map<String, String> valores = new HashMap<>();
        valores.put("nombre_programa", "Maestría en Derecho Educativo");
        valores.put("universidad", universidad.getNombre());
        valores.put("representante", rector.getNombre());
        
        DocumentoJuridico documento = plantilla.generarDocumento(
            "DOC-001",
            rector.getId(),
            valores
        );
        documento.setConsultaId(consulta.getId());
        
        System.out.println(documento);
        System.out.println();
        
        // 8. Solicitar revisión humana
        System.out.println("8. SOLICITUD DE REVISIÓN HUMANA");
        Abogado abogado = new Abogado(
            "A-001",
            "Dra. María González",
            "maria.gonzalez@legal.com",
            "password456",
            "+57 310 9876543",
            "LIC-98765",
            "Derecho Educativo",
            15
        );
        abogado.agregarAreaExperticia("Educación Superior");
        abogado.agregarAreaExperticia("Derecho Administrativo");
        
        SolicitudRevision solicitud = new SolicitudRevision(
            "SR-001",
            "Documento",
            documento.getId(),
            rector.getId(),
            "Alta",
            "Documento crítico que requiere validación legal"
        );
        solicitud.asignarRevisor(abogado.getId());
        
        System.out.println(abogado);
        System.out.println(solicitud);
        System.out.println();
        
        // 9. Realizar revisión
        System.out.println("9. PROCESO DE REVISIÓN");
        solicitud.iniciarRevision();
        
        Revision revision = new Revision(
            "REV-001",
            solicitud.getId(),
            abogado.getId(),
            documento.getId()
        );
        revision.aprobarConCambios(
            "El documento está bien estructurado",
            "Agregar cláusula de cumplimiento normativo en el artículo 3"
        );
        
        solicitud.completar("Revisión completada con sugerencias");
        
        System.out.println(revision);
        System.out.println();
        
        // 10. Generar reporte de métricas
        System.out.println("10. MÉTRICAS Y REPORTES");
        MetricaUso metricas = new MetricaUso("MU-001", "Consultas");
        metricas.setUsuariosActivos(1);
        metricas.registrarConsulta(true, 3.5);
        metricas.registrarDocumento();
        metricas.registrarRevision();
        
        System.out.println(metricas);
        System.out.println();
        
        // 11. Análisis de calidad de IA
        System.out.println("11. ANÁLISIS DE CALIDAD DE IA");
        AnalisisCalidadIA analisis = new AnalisisCalidadIA("ACI-001");
        analisis.analizarRespuesta(respuesta, calificacion);
        analisis.generarRecomendaciones();
        
        System.out.println(analisis);
        System.out.println("Recomendaciones: " + analisis.getRecomendaciones());
        System.out.println();
        
        System.out.println("=== FIN DEL EJEMPLO ===");
    }
}

# POO Proyecto Jurídico - Sistema de Gestión Legal

Este proyecto implementa un sistema completo de gestión legal con asistencia de IA, desarrollado en Java utilizando principios de Programación Orientada a Objetos (POO).

## Descripción del Sistema

El sistema proporciona funcionalidades para la gestión de consultas jurídicas, generación de documentos legales, control de calidad de respuestas de IA, y verificación humana de documentos críticos.

## Estructura del Proyecto

El proyecto está organizado en 7 módulos funcionales principales:

### 1. Gestión de Usuarios y Membresías
- **Usuario.java**: Clase base para todos los usuarios del sistema
- **Rector.java**: Usuario rector asociado a instituciones educativas
- **Abogado.java**: Usuario abogado con capacidad de revisión
- **Administrador.java**: Usuario administrador con permisos especiales
- **InstitucionEducativa.java**: Entidad que representa instituciones educativas
- **Membresia.java**: Gestión de planes y límites de uso
- **Pago.java**: Registro y gestión de pagos

### 2. Consultas Jurídicas Asistidas por IA
- **ConsultaJuridica.java**: Gestión de preguntas y respuestas legales
- **RespuestaIA.java**: Respuestas generadas por IA con trazabilidad
- **ReferenciaNormativa.java**: Referencias a normas y leyes
- **Calificacion.java**: Sistema de calificación de respuestas
- **ReporteError.java**: Reporte de errores e inexactitudes

### 3. Generación y Edición de Documentos Jurídicos
- **DocumentoJuridico.java**: Documentos legales con versionamiento
- **PlantillaJuridica.java**: Plantillas para generación de documentos
- **VersionDocumento.java**: Control de versiones de documentos
- **EdicionDocumento.java**: Sesiones de edición de documentos

### 4. Gestión de Base de Conocimiento
- **BaseConocimiento.java**: Gestor central de conocimiento legal
- **Norma.java**: Leyes, decretos y resoluciones
- **Jurisprudencia.java**: Sentencias y precedentes judiciales
- **ActualizacionNormativa.java**: Registro de cambios normativos

### 5. Control de Sesgos y Minimización de Alucinaciones
- **FuenteInformacion.java**: Rastreo de fuentes utilizadas
- **ValidacionRespuesta.java**: Validación automática de respuestas
- **ControlSesgo.java**: Detección y control de sesgos y alucinaciones

### 6. Verificación Humana y Flujo de Revisión
- **SolicitudRevision.java**: Solicitudes de revisión por abogados
- **ColaRevision.java**: Cola priorizada de revisiones
- **Revision.java**: Proceso de revisión humana
- **TrazabilidadCambio.java**: Historial completo de cambios

### 7. Reportes y Analítica
- **Reporte.java**: Generación de reportes del sistema
- **MetricaUso.java**: Métricas de uso y actividad
- **AnalisisCalidadIA.java**: Análisis de calidad de respuestas de IA

## Características Principales

### Principios de POO Implementados
- **Encapsulación**: Todos los campos son privados con getters/setters públicos
- **Herencia**: Jerarquía de usuarios (Usuario → Rector/Abogado/Administrador)
- **Abstracción**: Interfaces claras para interacción entre componentes
- **Polimorfismo**: Métodos sobrescritos como `toString()` y `equals()`

### Funcionalidades Destacadas
1. **Gestión de Usuarios**: Sistema completo de registro, autenticación y permisos
2. **IA Asistida**: Consultas legales con respuestas generadas por IA
3. **Generación de Documentos**: Plantillas y generación automática de documentos
4. **Control de Calidad**: Validación automática y manual de respuestas
5. **Trazabilidad**: Historial completo de cambios y versiones
6. **Analítica**: Reportes y métricas de uso del sistema

### Validaciones Implementadas
- Validación de rangos numéricos (calificaciones, confianza, etc.)
- Validación de estados de transición (documentos, revisiones, etc.)
- Validación de permisos y roles de usuario
- Validación de membresías y límites de uso

## Compilación

Para compilar el proyecto:

```bash
javac *.java
```

Para compilar con verificación de warnings:

```bash
javac -Xlint:all *.java
```

## Documentación del Código

Todas las clases incluyen:
- Comentarios JavaDoc describiendo la funcionalidad
- Documentación de métodos públicos
- Validaciones en setters y métodos de negocio
- Métodos `toString()` para facilitar debugging

## Arquitectura

El sistema sigue una arquitectura modular donde:
- Cada funcionalidad está separada en su propio conjunto de clases
- Las clases tienen responsabilidades bien definidas
- Se minimiza el acoplamiento entre módulos
- Se maximiza la cohesión dentro de cada módulo

## Casos de Uso Principales

1. **Rector realiza consulta legal**
   - Usuario (Rector) → Membresia → ConsultaJuridica → RespuestaIA

2. **Generación de documento**
   - Usuario → PlantillaJuridica → DocumentoJuridico → VersionDocumento

3. **Revisión por abogado**
   - SolicitudRevision → ColaRevision → Abogado → Revision

4. **Control de calidad**
   - RespuestaIA → ValidacionRespuesta → ControlSesgo → AnalisisCalidadIA

5. **Actualización normativa**
   - ActualizacionNormativa → BaseConocimiento → Norma/Jurisprudencia

## Extensibilidad

El sistema está diseñado para ser fácilmente extensible:
- Nuevos tipos de usuarios pueden heredar de `Usuario`
- Nuevos tipos de documentos pueden usar las plantillas existentes
- Nuevas métricas pueden agregarse a `MetricaUso`
- Nuevas validaciones pueden incorporarse en `ValidacionRespuesta`

## Autor

Desarrollado como parte del proyecto POO (Programación Orientada a Objetos) para el sistema de gestión jurídica educativa.

## Licencia

Este proyecto es de código abierto y está disponible para uso educativo.

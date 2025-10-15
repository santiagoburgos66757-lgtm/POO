public class TestPOO {
    public static void main(String[] args) {
        System.out.println("=== Testing POO Exercises toString() Methods ===\n");
        
        // 1) Libro de biblioteca
        System.out.println("1) Libro de biblioteca:");
        Libro libro = new Libro("El Quijote", 2, 5);
        System.out.println("   Expected: El Quijote- disponibles 2/5");
        System.out.println("   Actual:   " + libro);
        System.out.println("   Match: " + libro.toString().equals("El Quijote- disponibles 2/5"));
        System.out.println();
        
        // 2) Cuenta bancaria
        System.out.println("2) Cuenta bancaria:");
        CuentaBancaria cuenta = new CuentaBancaria("123-4", 1250000.00);
        System.out.println("   Expected: Cuenta 123-4 | Saldo: 1_250_000.00");
        System.out.println("   Actual:   " + cuenta);
        System.out.println("   Match: " + cuenta.toString().equals("Cuenta 123-4 | Saldo: 1_250_000.00"));
        System.out.println();
        
        // 3) Producto de inventario
        System.out.println("3) Producto de inventario:");
        Producto producto = new Producto("P01", "Teclado", 18, 59.90);
        System.out.println("   Expected: P01 - Teclado | stock: 18 | $59.90");
        System.out.println("   Actual:   " + producto);
        System.out.println("   Match: " + producto.toString().equals("P01 - Teclado | stock: 18 | $59.90"));
        System.out.println();
        
        // 4) Película en videoclub/streaming
        System.out.println("4) Película en videoclub/streaming:");
        Pelicula pelicula = new Pelicula("Matrix", "R", 1, 3);
        System.out.println("   Expected: Matrix (R) | disp: 1/3");
        System.out.println("   Actual:   " + pelicula);
        System.out.println("   Match: " + pelicula.toString().equals("Matrix (R) | disp: 1/3"));
        System.out.println();
        
        // 5) Estudiante – Promedio y estado
        System.out.println("5) Estudiante – Promedio y estado:");
        Estudiante estudiante = new Estudiante(102, "Juan", 4.3);
        System.out.println("   Expected: ID: 102 | Prom: 4.3 | Aprobado.");
        System.out.println("   Actual:   " + estudiante);
        System.out.println("   Match: " + estudiante.toString().equals("ID: 102 | Prom: 4.3 | Aprobado."));
        System.out.println();
        
        // 6) Vehículo – Consumo y autonomía
        System.out.println("6) Vehículo – Consumo y autonomía:");
        Vehiculo vehiculo = new Vehiculo("ABC123", 50.0, 24.5, 0.1);
        System.out.println("   Expected: ABC123 | Autonomía: 245.0 km.");
        System.out.println("   Actual:   " + vehiculo);
        System.out.println("   Match: " + vehiculo.toString().equals("ABC123 | Autonomía: 245.0 km."));
        System.out.println();
        
        // 7) Pedido de e-commerce
        System.out.println("7) Pedido de e-commerce:");
        Pedido pedido = new Pedido("P-009", 129.99, true);
        System.out.println("   Expected: Pedido P-009 | Total: $129.99 | Pagado: true");
        System.out.println("   Actual:   " + pedido);
        System.out.println("   Match: " + pedido.toString().equals("Pedido P-009 | Total: $129.99 | Pagado: true"));
        System.out.println();
        
        // 8) Reserva de hotel
        System.out.println("8) Reserva de hotel:");
        Reserva reserva = new Reserva(3, 180.00);
        System.out.println("   Expected: 3 noches | $540.00");
        System.out.println("   Actual:   " + reserva);
        System.out.println("   Match: " + reserva.toString().equals("3 noches | $540.00"));
        System.out.println();
        
        // 9) Paciente – Turno médico
        System.out.println("9) Paciente – Turno médico:");
        Paciente paciente = new Paciente("María", "B", 2, false);
        System.out.println("   Expected: Triage B | Prioridad 2 | Atendido: false");
        System.out.println("   Actual:   " + paciente);
        System.out.println("   Match: " + paciente.toString().equals("Triage B | Prioridad 2 | Atendido: false"));
        System.out.println();
        
        // 10) Clase Sensor (IoT)
        System.out.println("10) Clase Sensor (IoT):");
        Sensor sensor = new Sensor("S-01", 31.4, true);
        System.out.println("   Expected: S-01 | 31.4°C | Alarma: true");
        System.out.println("   Actual:   " + sensor);
        System.out.println("   Match: " + sensor.toString().equals("S-01 | 31.4°C | Alarma: true"));
        System.out.println();
        
        System.out.println("=== Test Complete ===");
    }
}

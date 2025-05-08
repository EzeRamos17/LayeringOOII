package ar.unrn.tp4.model;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un nombre");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un telefono");
        }
        if (!telefono.matches("\\d{4}-\\d{6}")) {
            throw new IllegalArgumentException("El teléfono debe ingresarse de la forma NNNN-NNNNNN");
        }
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
            throw new IllegalArgumentException("Region desconocida. Las conocidas son: China, US, Europa");
        }
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    public String nombre() {
        return nombre;
    }

    public String telefono() {
        return telefono;
    }

    public String region() {
        return region;
    }
}

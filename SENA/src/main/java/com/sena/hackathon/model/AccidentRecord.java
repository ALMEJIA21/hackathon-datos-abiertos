package com.sena.hackathon.model;

public class AccidentRecord {
    private String fecha;
    private String localidad;
    private String tipoVehiculo;
    private String gravedad;

    public AccidentRecord(String fecha, String localidad, String tipoVehiculo, String gravedad) {
        this.fecha = fecha;
        this.localidad = localidad;
        this.tipoVehiculo = tipoVehiculo;
        this.gravedad = gravedad;
    }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    public String getGravedad() { return gravedad; }
    public void setGravedad(String gravedad) { this.gravedad = gravedad; }
}
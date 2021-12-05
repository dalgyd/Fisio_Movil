package com.example.fisio_movil;

public class ListaCitas {

    private Integer Id;
    private Integer IdPaciente;
    private Integer IdProfesional;
    private String Fecha;
    private Integer Jornada;
    private String Direccion;
    private String Ubicacion;
    private Integer Estado;
    private Integer Calificacion;

    public ListaCitas(Integer id, Integer idPaciente, Integer idProfesional, String fecha, Integer jornada, String direccion, String ubicacion, Integer estado, Integer calificacion) {
        Id = id;
        IdPaciente = idPaciente;
        IdProfesional = idProfesional;
        Fecha = fecha;
        Jornada = jornada;
        Direccion = direccion;
        Ubicacion = ubicacion;
        Estado = estado;
        Calificacion = calificacion;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        IdPaciente = idPaciente;
    }

    public Integer getIdProfesional() {
        return IdProfesional;
    }

    public void setIdProfesional(Integer idProfesional) {
        IdProfesional = idProfesional;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public Integer getJornada() {
        return Jornada;
    }

    public void setJornada(Integer jornada) {
        Jornada = jornada;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public Integer getEstado() {
        return Estado;
    }

    public void setEstado(Integer estado) {
        Estado = estado;
    }

    public Integer getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        Calificacion = calificacion;
    }
}
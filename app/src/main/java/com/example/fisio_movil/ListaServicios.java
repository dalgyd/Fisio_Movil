package com.example.fisio_movil;

public class ListaServicios {
    public String tipoServicio;
    public String profesionalServicio;
    public String fechaServicio;
    public String statusServicio;

    public ListaServicios(String tipoServicio, String profesionalServicio, String fechaServicio, String statusServicio) {
        this.tipoServicio = tipoServicio;
        this.profesionalServicio = profesionalServicio;
        this.fechaServicio = fechaServicio;
        this.statusServicio = statusServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getProfesionalServicio() {
        return profesionalServicio;
    }

    public void setProfesionalServicio(String profesionalServicio) {
        this.profesionalServicio = profesionalServicio;
    }

    public String getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(String fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getStatusServicio() {
        return statusServicio;
    }

    public void setStatusServicio(String statusServicio) {
        this.statusServicio = statusServicio;
    }
}

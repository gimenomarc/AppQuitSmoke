package com.example.app;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String password;
    private String email;


    public Usuario(int id, String nombre, String apellido, String nombreUsuario, String password, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


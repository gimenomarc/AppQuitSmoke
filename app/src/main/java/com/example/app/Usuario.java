package com.example.app;

public class Usuario {
    int id;
    String Nombre, Usuario, Password, Email;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String usuario, String password, String email) {
        this.id = id;
        Nombre = nombre;
        Usuario = usuario;
        Password = password;
        Email = email;
    }

    public boolean isNull() {
        if(Nombre.equals("")&&Usuario.equals("")&&Password.equals("")&&Email.equals("")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + Nombre + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", password='" + Password + '\'' +
                ", email='" + Email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

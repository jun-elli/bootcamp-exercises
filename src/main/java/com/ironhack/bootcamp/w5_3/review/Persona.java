package com.ironhack.bootcamp.w5_3.review;

import java.util.List;

public class Persona {
    private String nombre;
    private String apellidos;
    private List<Persona> amigos;

    public Persona(String nombre, String apellidos, List<Persona> amigos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.amigos = amigos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<Persona> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Persona> amigos) {
        this.amigos = amigos;
    }

    public void addAmigo(Persona amigo) {
        this.amigos.add(amigo);
    }

    public void removeAmigo(Persona amigo) {
        amigos.remove(amigo);
    }

    public boolean esAmigo (Persona posibleAmigo) {
        return amigos.contains(posibleAmigo);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Persona)) {
            return false;
        }
        Persona objPersona = (Persona)obj;

        if (!this.nombre.equals(objPersona.nombre)) {
            return false;
        }
        if (!this.apellidos.equals(objPersona.apellidos)) {
            return false;
        }

        if (amigos.size() != objPersona.amigos.size()) {
            return false;
        }
        for (Persona amigo: amigos) {
            if (!objPersona.amigos.contains(amigo)) {
                return false;
            }
        }


        return true;
    }
}

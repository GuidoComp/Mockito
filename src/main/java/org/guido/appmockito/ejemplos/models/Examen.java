package org.guido.appmockito.ejemplos.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Examen {
    private Long id;
    private String nombre;
    private List<String> preguntas;

    public Examen() {
        this.preguntas = new ArrayList<>();
    }

    public Examen(Long id, String nombre) {
        this();
        this.id = id;
        this.nombre = nombre;
    }

    public Examen(Long id, String nombre, List<String> preguntas) {
        this.id = id;
        this.nombre = nombre;
        this.preguntas = preguntas;
    }
}

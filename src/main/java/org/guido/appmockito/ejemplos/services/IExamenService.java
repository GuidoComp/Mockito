package org.guido.appmockito.ejemplos.services;

import org.guido.appmockito.ejemplos.models.Examen;

import java.util.Optional;

public interface IExamenService {
    Optional<Examen> findExamenPorNombre(String nombre);
    Examen findExamenPorNombreConPreguntas(String nombre);
    Examen guardar(Examen examen);
}

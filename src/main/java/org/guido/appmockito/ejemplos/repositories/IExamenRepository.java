package org.guido.appmockito.ejemplos.repositories;

import org.guido.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface IExamenRepository {
    Examen guardar(Examen examen);
    List<Examen> findAll();
}

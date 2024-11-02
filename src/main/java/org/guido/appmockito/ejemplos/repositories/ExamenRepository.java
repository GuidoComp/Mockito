package org.guido.appmockito.ejemplos.repositories;

import org.guido.appmockito.ejemplos.Datos;
import org.guido.appmockito.ejemplos.models.Examen;

import java.util.List;

public class ExamenRepository implements IExamenRepository {

    @Override
    public Examen guardar(Examen examen) {
        System.out.println("ExamenRepository.guardar");
        return Datos.EXAMEN;
    }

    @Override
    public List<Examen> findAll() {
        System.out.println("ExamenRepository.findAll");
        return Datos.EXAMENES;
    }
}

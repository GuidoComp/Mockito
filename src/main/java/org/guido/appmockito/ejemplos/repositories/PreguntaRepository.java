package org.guido.appmockito.ejemplos.repositories;

import org.guido.appmockito.ejemplos.Datos;

import java.util.List;

public class PreguntaRepository implements IPreguntaRepository {
    @Override
    public List<String> findPreguntasPorExamenId(Long id) {
        System.out.println("PreguntaRepository.findPreguntasPorExamenId");
        return Datos.PREGUNTAS;
    }

    @Override
    public void guardarVarias(List<String> preguntas) {
        System.out.println("PreguntaRepository.guardarVarias");
    }
}

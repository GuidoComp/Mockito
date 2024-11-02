package org.guido.appmockito.ejemplos.services;

import org.guido.appmockito.ejemplos.models.Examen;
import org.guido.appmockito.ejemplos.repositories.IExamenRepository;
import org.guido.appmockito.ejemplos.repositories.IPreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenService implements IExamenService {
    private IExamenRepository examenRepository;
    private IPreguntaRepository preguntaRepository;

    public ExamenService(IExamenRepository examenRepository, IPreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return examenRepository.findAll()
                .stream()
                .filter(e -> e.getNombre().contains(nombre))
                .findFirst();
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExamenPorNombre(nombre);
        Examen examen = null;
        if (examenOptional.isPresent()) {
            examen = examenOptional.orElseThrow();
            List<String> preguntas = preguntaRepository.findPreguntasPorExamenId(examen.getId());
            preguntaRepository.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }
        return examen;
    }

    @Override
    public Examen guardar(Examen examen) {
        if (!examen.getPreguntas().isEmpty()) {
            preguntaRepository.guardarVarias(examen.getPreguntas());
        }
        return examenRepository.guardar(examen);
    }
}

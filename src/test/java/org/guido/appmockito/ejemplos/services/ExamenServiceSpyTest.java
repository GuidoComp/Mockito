package org.guido.appmockito.ejemplos.services;

import org.guido.appmockito.ejemplos.Datos;
import org.guido.appmockito.ejemplos.models.Examen;
import org.guido.appmockito.ejemplos.repositories.ExamenRepository;
import org.guido.appmockito.ejemplos.repositories.IExamenRepository;
import org.guido.appmockito.ejemplos.repositories.IPreguntaRepository;
import org.guido.appmockito.ejemplos.repositories.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceSpyTest {
    @Spy
    ExamenRepository examenRepository;
    @Spy
    PreguntaRepository preguntaRepository;

    @InjectMocks
    ExamenService service;

    @Test
    void testSpy() {
        List<String> preguntas = Arrays.asList("aritmética");
//        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(preguntas);
        doReturn(preguntas).when(preguntaRepository).findPreguntasPorExamenId(anyLong());

        Examen examen = service.findExamenPorNombreConPreguntas("Matemáticas");

        assertEquals(5L, examen.getId());
        assertEquals("Matemáticas", examen.getNombre());
        assertEquals(1, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("aritmética"));

        verify(examenRepository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenId(anyLong());
    }
}
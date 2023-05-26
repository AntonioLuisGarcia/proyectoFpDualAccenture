package agg.controller;

import agg.dao.Productos.Comida;
import agg.persistence.service.ComidaService;
import jakarta.ws.rs.core.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComidaControllerTest {

    @Mock
    private ComidaService comidaService;

    @Mock
    private Comida comida;

    @Mock
    private List<Comida> listaComida;

    @InjectMocks
    private ComidaController comidaController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getById_ok(){
        when(comidaService.getById(Mockito.anyInt())).thenReturn(comida);

        Response response = comidaController.getById(Mockito.anyInt());

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comida));
    }

    @Test
    void getAll_ok(){
        when(comidaService.getAll()).thenReturn(listaComida);

        Response response = comidaController.getAll();

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(listaComida));
    }
}
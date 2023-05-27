package agg.controller;


import agg.dao.Productos.Bebida;
import agg.persistence.service.BebidaService;
import jakarta.ws.rs.core.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BebidaControllerTest {

    @Mock
    private BebidaService bebidaService;

    @Mock
    private Bebida bebida;

    @Mock
    private List<Bebida> listaBebidas;

    @InjectMocks
    private BebidaController bebidaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getById_ok(){
        when(bebidaService.getById(Mockito.anyInt())).thenReturn(bebida);

        Response response = bebidaController.getById(Mockito.anyInt());

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(bebida));
    }

    @Test
    void getAll_ok(){
        when(bebidaService.getAll()).thenReturn(listaBebidas);

        Response response = bebidaController.getAll();

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(listaBebidas));
    }
}

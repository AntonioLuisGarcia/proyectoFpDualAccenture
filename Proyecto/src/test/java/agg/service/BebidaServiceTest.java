package agg.service;

import agg.client.BebidaClient;
import agg.persistence.dao.clases.Productos.Bebida;
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
class BebidaServiceTest {

    @Mock
    private BebidaClient bebidaClient;

    @Mock
    private List<Bebida> bebidas;

    @Mock
    private Bebida bebida;

    @InjectMocks
    private BebidaService bebidaService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void listAll() {
        when(bebidaClient.listAll()).thenReturn(bebidas);

        List<Bebida> bebidasTest = bebidaService.lisAll();

        MatcherAssert.assertThat(bebidasTest, Matchers.is(bebidas));
    }

    @Test
    void getById() {
        when(bebidaClient.getById(Mockito.anyInt())).thenReturn(bebida);

        Bebida bebidaTest = bebidaService.getById(Mockito.anyInt());

        MatcherAssert.assertThat(bebidaTest, Matchers.is(bebida));
    }
}
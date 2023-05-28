package agg.service;

import agg.client.ComidaClient;
import agg.persistence.dao.clases.Productos.Comida;
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
class ComidaServiceTest {

    @Mock
    private ComidaClient comidaClient;

    @Mock
    private List<Comida> comidas;

    @Mock
    private Comida comida;

    @InjectMocks
    private ComidaService comidaService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void listAll() {
        when(comidaClient.listAll()).thenReturn(comidas);

        List<Comida> comidasTest = comidaService.listAll();

        MatcherAssert.assertThat(comidasTest, Matchers.is(comidas));
    }

    @Test
    void getById() {
        when(comidaClient.getProductById(Mockito.anyInt())).thenReturn(comida);

        Comida comidaTest = comidaService.getById(Mockito.anyInt());

        MatcherAssert.assertThat(comidaTest, Matchers.is(comida));
    }
}
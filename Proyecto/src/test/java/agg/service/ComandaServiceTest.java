package agg.service;

import agg.client.ComandaClient;
import agg.persistence.dao.clases.Comanda;
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
class ComandaServiceTest {

    @Mock
    private ComandaClient comandaClient;

    @Mock
    private List<Comanda> comandas;

    @Mock
    private Comanda comanda;

    @InjectMocks
    private ComandaService comandaService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void listAll() {
        when(comandaClient.listAll()).thenReturn(comandas);

        List<Comanda> comandasTest = comandaService.listAll();

        MatcherAssert.assertThat(comandasTest, Matchers.is(comandas));
    }

    @Test
    void getById() {
        when(comandaClient.getById(Mockito.anyInt())).thenReturn(comanda);

        Comanda comandaTest = comandaService.getById(Mockito.anyInt());

        MatcherAssert.assertThat(comandaTest, Matchers.is(comanda));
    }

    @Test
    void getNoPagadas_ok() {
        when(comandaClient.getNoPagadas()).thenReturn(comandas);

        List<Comanda> comandasTest = comandaService.getNoPagadas();

        MatcherAssert.assertThat(comandasTest, Matchers.is(comandas));
    }

    @Test
    void getNoPagadasYPorIdCamarero_ok() {
        when(comandaClient.getNoPagadasYPorIdCamarero(Mockito.anyInt())).thenReturn(comandas);

        List<Comanda> comandasTest = comandaService.getNoPagadasYPorIdCamarero(Mockito.anyInt());

        MatcherAssert.assertThat(comandasTest, Matchers.is(comandas));
    }

    @Test
    void create_ok() {
        when(comandaClient.create(Mockito.any())).thenReturn(comanda);

        Comanda comandaTest = comandaService.create(Mockito.any());

        MatcherAssert.assertThat(comandaTest, Matchers.is(comanda));
    }

    @Test
    void pagarComanda_ok(){
        when(comandaClient.pagarComanda(Mockito.anyInt())).thenReturn(comanda);

        Comanda comandaTest = comandaService.pagarComanda(1);

        MatcherAssert.assertThat(comandaTest, Matchers.is(comanda));

    }

}
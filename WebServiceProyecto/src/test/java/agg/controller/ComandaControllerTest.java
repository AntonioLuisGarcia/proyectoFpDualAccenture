package agg.controller;


import agg.dao.Comanda;
import agg.persistence.service.ComandaService;
import jakarta.ws.rs.core.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComandaControllerTest {

    @Mock
    private ComandaService comandaService;

    @Mock
    private Comanda comanda;

    @Mock
    private List<Comanda> comandaList;

    @InjectMocks
    private ComandaController comandaController;

    @Test
    void getById_ok(){
        when(comandaService.getById(Mockito.anyInt())).thenReturn(comanda);

        Response response = comandaController.getById(1);

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comanda));
    }

    @Test
    void create_ok(){
        when(comandaService.create(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn(comanda);

        Response response = comandaController.create(comanda);

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comanda));
    }

    @Test
    void getNoPagadas_ok(){
        when(comandaService.getNoPagadas()).thenReturn(comandaList);

        Response response = comandaController.getNoPagadas();

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comandaList));
    }

    @Test
    void getAll_ok(){
        when(comandaService.getAll()).thenReturn(comandaList);

        Response response = comandaController.getAll();

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comandaList));
    }

    @Test
    void getNoPagadasYPorIdCamarero_ok(){
        when(comandaService.getNoPagadasYPorIdCamarero(Mockito.anyInt())).thenReturn(comandaList);

        Response response = comandaController.getNoPagadasYPorIdCamarero(Mockito.anyInt());

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comandaList));
    }

    @Test
    void pagar_ok(){
        when(comandaService.pagar(Mockito.anyInt())).thenReturn(comanda);

        Response response = comandaController.pagar(Mockito.anyInt());

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comanda));

    }
}

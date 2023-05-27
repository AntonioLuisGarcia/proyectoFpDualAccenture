package agg.client;

import agg.client.ComandaClient;
import agg.persistence.dao.clases.Comanda;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComandaClientTest {

    /*
    @Mock
    private Client client;

    @Mock
    private WebTarget webTarget;

    private ComandaClient comandaClient;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        comandaClient = new ComandaClient();
        comandaClient.setWebTarget(webTarget);
        webTarget = client.target();
    }

    @Test
    public void testListAll() {
        List<Comanda> expectedComandas = new ArrayList<>();
        expectedComandas.add(new Comanda());
        expectedComandas.add(new Comanda());

        Mockito.when(webTarget.path(Mockito.anyString())).thenReturn(webTarget);
        Mockito.when(webTarget.request(Mockito.anyString())).thenReturn(webTarget);
        Mockito.when(webTarget.get(Mockito.any(GenericType.class))).thenReturn(expectedComandas);

        List<Comanda> actualComandas = comandaClient.listAll();

        assertEquals(expectedComandas, actualComandas);
    }

    @Test
    public void testGetById() {
        int id = 1;
        Comanda expectedComanda = new Comanda();

        Mockito.when(webTarget.path(Mockito.anyString())).thenReturn(webTarget);
        Mockito.when(webTarget.queryParam(Mockito.anyString(), Mockito.anyInt())).thenReturn(webTarget);
        Mockito.when(webTarget.request(Mockito.anyString())).thenReturn(webTarget);
        Mockito.when(webTarget.get(Comanda.class)).thenReturn(expectedComanda);

        Comanda actualComanda = comandaClient.getById(id);

        assertEquals(expectedComanda, actualComanda);
    }

    // Similary, you can write tests for other methods such as getNoPagadas, getNoPagadasYPorIdCamarero, createComanda, pagarComanda.

    public void setWebTarget(WebTarget webTarget) {
        this.webTarget = webTarget;
    }*/
}

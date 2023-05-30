package agg.client;

import agg.persistence.dao.clases.Comanda;
import agg.persistence.dao.clases.ComandaProducto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComandaClientTest {

    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation invocation;

    @Mock
    private Invocation.Builder builder;

    private Comanda comanda;

    private ComandaClient comandaClient;

    @BeforeEach
    void setUp() {
        comanda = new Comanda(1,1,1,"", "", new ArrayList<ComandaProducto>(), true);
        MockitoAnnotations.openMocks(this);
        when(client.target(anyString())).thenReturn(webTarget);
        comandaClient = new ComandaClient(client);
    }

    @Test
    void getById_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(any(),any())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(Comanda.class)).thenReturn(comanda);

        Comanda comandaTest = comandaClient.getById(2);

        assertEquals(comandaTest.getId(), comanda.getId());
    }

    @Test
    void listAll_ok() {

        List<Comanda> comandas = new ArrayList<>();
        comandas.add(comanda);

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(new GenericType<List<Comanda>>() {})).thenReturn(comandas);

        List<Comanda> comandasTest = comandaClient.listAll();

        assertEquals(comandasTest.size(), comandas.size());
    }

    @Test
    void getNoPagadas_ok() {

        List<Comanda> comandas = new ArrayList<>();
        comandas.add(comanda);

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(new GenericType<List<Comanda>>() {})).thenReturn(comandas);

        List<Comanda> comandasTest = comandaClient.getNoPagadas();

        assertEquals(comandasTest.size(), comandas.size());
    }

    @Test
    void getNoPagadasYPorIdCamarero_ok() {

        List<Comanda> comandas = new ArrayList<>();
        comandas.add(comanda);

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(webTarget.queryParam(any(),any())).thenReturn(webTarget);
        when(builder.get(new GenericType<List<Comanda>>() {})).thenReturn(comandas);

        List<Comanda> comandasTest = comandaClient.getNoPagadasYPorIdCamarero(1);

        assertEquals(comandasTest.size(), comandas.size());
    }

    @Test
    void create_ok() {


        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.post(Entity.entity(comanda, MediaType.APPLICATION_JSON),Comanda.class)).thenReturn(comanda);

        Comanda comandaTest = comandaClient.create(comanda);

        assertEquals(comandaTest.getId(), comanda.getId());
    }

    @Test
    void pagarComanda_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.put(Entity.entity("", MediaType.APPLICATION_JSON),Comanda.class)).thenReturn(comanda);

        Comanda comandaTest = comandaClient.pagarComanda(1);

        assertEquals(comandaTest.getId(), comanda.getId());
    }
}

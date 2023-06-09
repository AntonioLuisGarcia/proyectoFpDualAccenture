package agg.client;

import agg.persistence.dao.clases.Productos.Bebida;
import jakarta.ws.rs.client.*;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BebidaClientTest {
    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation invocation;

    @Mock
    private Invocation.Builder builder;

    private Bebida bebida;

    private BebidaClient bebidaClient;

    @BeforeEach
    void setUp() {
        bebida = new Bebida(true,1);
        MockitoAnnotations.openMocks(this);
        when(client.target(anyString())).thenReturn(webTarget);
        bebidaClient = new BebidaClient(client);
    }

    @Test
    void getById_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(any(),any())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(Bebida.class)).thenReturn(bebida);

        Bebida bebidaTest = bebidaClient.getById(2);

        assertEquals(bebida.getId(), bebidaTest.getId());
    }

    @Test
    void listAll_ok() {

        List<Bebida> bebidas = new ArrayList<>();
        bebidas.add(bebida);

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(new GenericType<List<Bebida>>() {})).thenReturn(bebidas);

        List<Bebida> bebidasTest = bebidaClient.listAll();

        assertEquals(bebidas.size(), bebidasTest.size());
    }
}
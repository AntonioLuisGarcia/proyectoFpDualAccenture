package agg.client;

import agg.persistence.dao.clases.Productos.Comida;
import jakarta.ws.rs.client.Client;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComidaClientTest {

    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation invocation;

    @Mock
    private Invocation.Builder builder;

    private Comida comida;

    private ComidaClient comidaClient;

    @BeforeEach
    void setUp() {
        comida = new Comida(true,1);
        MockitoAnnotations.openMocks(this);
        when(client.target(anyString())).thenReturn(webTarget);
        comidaClient = new ComidaClient(client);
    }

    @Test
    void getProductById_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(any(),any())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(Comida.class)).thenReturn(comida);

        Comida comidaTest = comidaClient.getProductById(2);

        assertEquals(comida.getId(), comidaTest.getId());
    }

    @Test
    void listAll_ok() {

        List<Comida> comidas = new ArrayList<>();
        comidas.add(comida);

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(new GenericType<List<Comida>>() {})).thenReturn(comidas);

        List<Comida> comidasTest = comidaClient.listAll();

        assertEquals(comidas.size(), comidasTest.size());
    }
}
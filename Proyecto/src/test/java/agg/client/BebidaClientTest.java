package agg.client;

import agg.persistence.dao.clases.Productos.Bebida;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BebidaClientTest {
    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation.Builder builder;

    @Mock
    private Response response;

    @Mock
    private Bebida bebida;

    private BebidaClient bebidaClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bebidaClient = new BebidaClient();
    }

    @Test
    void getById_ok() {

        when(client.target(anyString())).thenReturn(webTarget);
        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get()).thenReturn(response);

        // Invoke the method under test
        Bebida bebidaTest = bebidaClient.getById(Mockito.anyInt());

        // Verify the interactions
        /*verify(client).target("http://localhost:8082/WebServiceProyecto/api/");
        verify(webTarget).path("bebidas/getAll/");
        verify(webTarget).request(MediaType.APPLICATION_JSON);
        verify(builder).get();*/

        // Verify the returned response
        assertEquals(response, bebidaTest);
    }
}
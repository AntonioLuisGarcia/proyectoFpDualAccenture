package agg.client;

import agg.persistence.dao.clases.Mesa;
import agg.persistence.dao.clases.Productos.Bebida;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MesaClientTest {
    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation invocation;

    @Mock
    private Invocation.Builder builder;

    private Mesa mesa;

    private MesaClient mesaClient;

    @BeforeEach
    void setUp() {
        mesa = new Mesa(1,1,1);
        MockitoAnnotations.openMocks(this);
        when(client.target(anyString())).thenReturn(webTarget);
        mesaClient = new MesaClient(client);
    }

    @Test
    void getById_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(any(),any())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(Mesa.class)).thenReturn(mesa);

        Mesa mesaTest = mesaClient.getById(2);

        assertEquals(mesa.getId(), mesaTest.getId());
    }

}
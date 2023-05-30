package agg.client;

import agg.persistence.dao.clases.Camarero;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
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
class CamareroClientTest {

    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation invocation;

    @Mock
    private Invocation.Builder builder;

    private Camarero camarero;

    private CamareroClient camareroClient;

    @BeforeEach
    void setUp() {
        camarero = new Camarero(1,"juan","","","");
        MockitoAnnotations.openMocks(this);
        when(client.target(anyString())).thenReturn(webTarget);
        camareroClient = new CamareroClient(client);
    }

    @Test
    void getById_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(any(),any())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(Camarero.class)).thenReturn(camarero);

        Camarero camareroTest= camareroClient.getById(2);

        assertEquals(camarero.getId(), camareroTest.getId());
    }

    @Test
    void verificateUserByUserAndPassword_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(any(),any())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(Camarero.class)).thenReturn(camarero);

        Camarero camareroTest= camareroClient.verificateUserByUserAndPassword("juan","1234");

        assertEquals(camarero.getId(), camareroTest.getId());
    }
}
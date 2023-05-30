package agg.client;

import agg.persistence.dao.clases.Productos.Postre;
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
class PostreClientTest {

    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation invocation;

    @Mock
    private Invocation.Builder builder;

    private Postre postre;

    private PostreClient postreClient;

    @BeforeEach
    void setUp() {
        postre = new Postre(1,1);
        MockitoAnnotations.openMocks(this);
        when(client.target(anyString())).thenReturn(webTarget);
        postreClient = new PostreClient(client);
    }

    @Test
    void getById_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(any(),any())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(Postre.class)).thenReturn(postre);

        Postre postreTest = postreClient.getById(2);

        assertEquals(postreTest.getId(), postre.getId());
    }

    @Test
    void listAll_ok() {

        List<Postre> postres = new ArrayList<>();
        postres.add(postre);

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(new GenericType<List<Postre>>() {})).thenReturn(postres);

        List<Postre> postresTest = postreClient.listAll();

        assertEquals(postres.size(), postresTest.size());
    }
}
package agg.client;

import agg.persistence.dao.clases.ComandaProducto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
class ComandaProductoClientTest {

    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation invocation;

    @Mock
    private Invocation.Builder builder;

    private ComandaProducto comandaProducto;

    private ComandaProductoClient comandaProductoClient;

    @BeforeEach
    void setUp() {
        comandaProducto = new ComandaProducto(1,1,1,1);
        MockitoAnnotations.openMocks(this);
        when(client.target(anyString())).thenReturn(webTarget);
        comandaProductoClient = new ComandaProductoClient(client);
    }

    @Test
    void getByIdComanda_ok() {

        List<ComandaProducto> comandasProductos = new ArrayList<>();
        comandasProductos.add(comandaProducto);

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(any(),any())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(new GenericType<List<ComandaProducto>>(){})).thenReturn(comandasProductos);

        List<ComandaProducto> comandasProductoTest = comandaProductoClient.getByIdComanda(2);

        assertEquals(comandasProductos.size(), comandasProductoTest.size());
    }
    @Test
    void create_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.post(Entity.entity(comandaProducto, MediaType.APPLICATION_JSON),ComandaProducto.class)).thenReturn(comandaProducto);

        ComandaProducto comandaProductoTest = comandaProductoClient.create(comandaProducto);

        assertEquals(comandaProductoTest.getId(), comandaProducto.getId());
    }

    @Test
    void updateCantidadByIdAndIdComanda_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.put(Entity.entity("", MediaType.APPLICATION_JSON),ComandaProducto.class)).thenReturn(comandaProducto);

        ComandaProducto comandaProductoTest = comandaProductoClient.updateCantidadByIdAndIdComanda(1,1,1);

        assertEquals(comandaProducto.getId(), comandaProductoTest.getId());
    }

    @Test
    void borrarPorId_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.delete()).thenReturn(Response.ok().build());

        boolean test = comandaProductoClient.borrarPorId(1,1);

        assertTrue(test);
    }
}
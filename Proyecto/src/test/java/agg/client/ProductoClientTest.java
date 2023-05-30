package agg.client;

import agg.persistence.dao.clases.Productos.Producto;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductoClientTest {

    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation invocation;

    @Mock
    private Invocation.Builder builder;

    private Producto producto;

    private ProductoClient productoClient;

    @BeforeEach
    void setUp() {
        producto = new Producto(1,1,"","","");
        MockitoAnnotations.openMocks(this);
        when(client.target(anyString())).thenReturn(webTarget);
        productoClient = new ProductoClient(client);
    }

    @Test
    void getById_ok() {

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(any(),any())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(Producto.class)).thenReturn(producto);

        Producto productoTest = productoClient.getById(2);

        assertEquals(productoTest.getId(), producto.getId());
    }

    @Test
    void listAll_ok() {

        List<Producto> productos = new ArrayList<>();
        productos.add(producto);

        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.get(new GenericType<List<Producto>>() {})).thenReturn(productos);

        List<Producto> productosTest = productoClient.listAll();

        assertEquals(productos.size(), productosTest.size());
    }
}
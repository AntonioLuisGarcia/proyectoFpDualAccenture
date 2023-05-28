package agg.service;

import agg.client.ProductoClient;
import agg.persistence.dao.clases.Productos.Producto;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoClient productoClient;

    @Mock
    private List<Producto> productos;

    @Mock
    private Producto producto;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void listAll() {
        when(productoClient.listAll()).thenReturn(productos);

        List<Producto> productosTest = productoService.listAll();

        MatcherAssert.assertThat(productosTest, Matchers.is(productos));
    }

    @Test
    void getById() {
        when(productoClient.getById(Mockito.anyInt())).thenReturn(producto);

        Producto productoTest = productoService.getById(Mockito.anyInt());

        MatcherAssert.assertThat(productoTest, Matchers.is(producto));
    }
}
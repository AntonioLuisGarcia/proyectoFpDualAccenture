package agg.controller;


import agg.dao.Productos.Producto;
import agg.persistence.service.BebidaService;
import agg.persistence.service.ComidaService;
import agg.persistence.service.PostreService;
import agg.persistence.service.ProductoService;
import jakarta.ws.rs.core.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductoControllerTest {

    @Mock
    private ProductoService productoService;

    @Mock
    private Producto producto;

    @Mock
    private List<Producto> productos;

    @Mock
    private BebidaService bebidaService;

    @Mock
    private ComidaService comidaService;

    @Mock
    private PostreService postreService;

    @InjectMocks
    private ProductoController productoController;

    @Test
    void getById_ok(){
        when(productoService.getById(Mockito.anyInt())).thenReturn(producto);

        Response response = productoController.getById(Mockito.anyInt());

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(producto));
    }

    @Test
    void getAll_ok(){///////77Arreglarrrrr
        when(productoService.getAll()).thenReturn(productos);
        when(productos.addAll(Mockito.any())).getMock();
        //////////when(comidaService.getAll()).thenReturn(productos);
        Response response = productoController.getAll();

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(productos));
    }
}

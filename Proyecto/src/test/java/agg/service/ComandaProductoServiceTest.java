package agg.service;

import agg.client.ComandaProductoClient;
import agg.persistence.dao.clases.ComandaProducto;
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
class ComandaProductoServiceTest {

    @Mock
    private ComandaProductoClient comandaProductoClient;

    @Mock
    private List<ComandaProducto> comandaProductos;

    @Mock
    private ComandaProducto comandaProducto;

    @InjectMocks
    private ComandaProductoService comandaProductoService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getByIdComanda_ok() {
        when(comandaProductoClient.getByIdComanda(Mockito.anyInt())).thenReturn(comandaProductos);

        List<ComandaProducto> comandaProductosTest = comandaProductoService.getByIdComanda(Mockito.anyInt());

        MatcherAssert.assertThat(comandaProductosTest, Matchers.is(comandaProductos));
    }

    @Test
    void create_ok() {
        when(comandaProductoClient.create(Mockito.any())).thenReturn(comandaProducto);

        ComandaProducto comandaProductoTest = comandaProductoService.create(Mockito.any());

        MatcherAssert.assertThat(comandaProductoTest, Matchers.is(comandaProducto));
    }

    @Test
    void updateCantidadByIdAndIdComanda_ok(){
        when(comandaProductoClient.updateCantidadByIdAndIdComanda(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(comandaProducto);

        ComandaProducto comandaProductoTest = comandaProductoService.updateCantidadByIdAndIdComanda(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());

        MatcherAssert.assertThat(comandaProductoTest, Matchers.is(comandaProducto));
    }

    @Test
    void borrarPorId_ok(){
        when(comandaProductoClient.borrarPorId(Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);

        boolean test = comandaProductoService.borrarPorId(Mockito.anyInt(), Mockito.anyInt());

        MatcherAssert.assertThat(test, Matchers.is(true));
    }
}
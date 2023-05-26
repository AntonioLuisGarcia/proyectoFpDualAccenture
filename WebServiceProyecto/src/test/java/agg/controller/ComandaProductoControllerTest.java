package agg.controller;

import agg.dao.ComandaProducto;
import agg.persistence.service.ComandaProductoService;
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
class ComandaProductoControllerTest {

    @Mock
    private ComandaProductoService comandaProductoService;

    @Mock
    private ComandaProducto comandaProducto;

    @Mock
    private List<ComandaProducto> comandaProductoList;

    @InjectMocks
    private ComandaProductoController comandaProductoController;

    @Test
    void getAll_ok(){
        when(comandaProductoService.getProductosById(Mockito.anyInt())).thenReturn(comandaProductoList);

        Response response = comandaProductoController.getAll(1);

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comandaProductoList));
    }

    @Test
    void getById_ok(){
        when(comandaProductoService.getById(Mockito.anyInt())).thenReturn(comandaProducto);

        Response response = comandaProductoController.getById(1);

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comandaProducto));
    }

    @Test
    void create_ok(){
        when(comandaProductoService.create(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(comandaProducto);

        Response response = comandaProductoController.create(comandaProducto);

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comandaProducto));

    }

    @Test
    void updateCantidadByIdAndIdComanda_ok(){
        when(comandaProductoService.updateCantidadByIdAndIdComanda(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(comandaProducto);

        Response response = comandaProductoController.updateCantidadByIdAndIdComanda(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(comandaProducto));

    }

    @Test
    void borrarPorId_ok(){
        when(comandaProductoService.borrarPorId(Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);

        Response response = comandaProductoController.borrarPorId(Mockito.anyInt(), Mockito.anyInt());

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(true));

    }
}
package agg.persistence.service;

import agg.dao.ComandaProducto;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComandaProductoManager;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComandaProductoServiceTest {

    @Mock
    private MySQLConnector mySQLConnector;

    @Mock
    private Connection connection;

    @Mock
    private ComandaProductoManager comandaProductoManager;

    @BeforeEach
    void init(){
        comandaProductoService = new ComandaProductoService(comandaProductoManager, mySQLConnector);
    }

    private ComandaProductoService comandaProductoService;

    @Test
    void getProductosById_ok() throws SQLException, ClassNotFoundException {
        ComandaProducto comandaProducto = new ComandaProducto(1,1,1,1);
        List<ComandaProducto> productos = new ArrayList<>();
        productos.add(comandaProducto);

        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaProductoManager.getProductosById(Mockito.any(), Mockito.anyInt())).thenReturn(productos);

        List<ComandaProducto> productosTest = comandaProductoService.getProductosById(comandaProducto.getIdProducto());

        MatcherAssert.assertThat(productosTest, Matchers.is(productos));
    }

    @Test
    void create_ok() throws SQLException, ClassNotFoundException{
        ComandaProducto comandaProducto = new ComandaProducto(1,1,1,1);
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaProductoManager.create(Mockito.any(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(comandaProducto);

        ComandaProducto comandaProductoTest = comandaProductoService.create(comandaProducto.getIdProducto(), comandaProducto.getIdComanda(), comandaProducto.getIdComanda());

        MatcherAssert.assertThat(comandaProductoTest, Matchers.is(comandaProducto));
    }

    @Test
    void getById_ok()throws SQLException, ClassNotFoundException{
        ComandaProducto comandaProducto = new ComandaProducto(1,1,1,1);
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaProductoManager.getById(Mockito.any(), Mockito.anyInt())).thenReturn(comandaProducto);

        ComandaProducto comandaProductoTest = comandaProductoService.getById(comandaProducto.getIdProducto());

        MatcherAssert.assertThat(comandaProductoTest, Matchers.is(comandaProducto));
    }

    @Test
    void updateCantidadByIdAndIdComanda_ok() throws SQLException, ClassNotFoundException{
        ComandaProducto comandaProducto = new ComandaProducto(1,1,1,1);
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaProductoManager.updateCantidadByIdAndIdComanda(Mockito.any(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(comandaProducto);

        ComandaProducto comandaProductoTest = comandaProductoService.updateCantidadByIdAndIdComanda(comandaProducto.getIdComanda(), comandaProducto.getIdProducto(), comandaProducto.getCantidad());

        MatcherAssert.assertThat(comandaProductoTest, Matchers.is(comandaProducto));
    }

    @Test
    void borrarPorId_ok()throws SQLException, ClassNotFoundException{
        ComandaProducto comandaProducto = new ComandaProducto(1,1,1,1);
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaProductoManager.borrarPorId(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);

       boolean borrado = comandaProductoService.borrarPorId(comandaProducto.getIdComanda(), comandaProducto.getIdProducto());

        MatcherAssert.assertThat(borrado, Matchers.is(comandaProductoService.borrarPorId(comandaProducto.getIdComanda(), comandaProducto.getIdProducto())));
    }
}
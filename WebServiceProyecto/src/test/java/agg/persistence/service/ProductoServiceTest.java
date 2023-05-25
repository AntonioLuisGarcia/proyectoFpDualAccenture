package agg.persistence.service;

import agg.dao.Productos.Producto;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ProductoManager;
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
class ProductoServiceTest {

    @Mock
    private MySQLConnector mySQLConnector;

    @Mock
    private Connection connection;

    @Mock
    private ProductoManager productoManager;

    @BeforeEach
    public void init(){
        productoService = new ProductoService(productoManager, mySQLConnector);
    }

    private ProductoService productoService;

    @Test
    void getAll_ok() throws SQLException, ClassNotFoundException {
        Producto producto = new Producto(1,1,"","","");
        List<Producto> productos = new ArrayList<>();
        productos.add(producto);

        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(productoManager.getAll(Mockito.any())).thenReturn((ArrayList<Producto>) productos);

        List<Producto> productosTest = productoService.getAll();

        MatcherAssert.assertThat(productosTest, Matchers.is(productos));
    }

    @Test
    void getById_ok() throws SQLException, ClassNotFoundException {
        Producto producto = new Producto(1,1,"","","");

        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(productoManager.getById(Mockito.any(), Mockito.anyInt())).thenReturn(producto);

        Producto productoTest = productoService.getById(producto.getId());

        MatcherAssert.assertThat(productoTest, Matchers.is(producto));
    }
}
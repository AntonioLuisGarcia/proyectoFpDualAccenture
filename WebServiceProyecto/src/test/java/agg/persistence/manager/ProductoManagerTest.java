package agg.persistence.manager;

import agg.dao.Productos.Producto;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.*;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductoManagerTest {

    @Mock
    private Connection connection;

    @Mock
    private Statement statement;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private ProductoManager productoManager;

    @Test
    void getAll_ok() throws SQLException{
        Producto productoEsperado = new Producto(1,2.2,"Nombre","Descripcion","imagen.jpg");

        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(any())).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                if(counter < 1){
                    counter++;
                    return true;
                } else {
                    return false;
                }
            }
        });

        doReturn(productoEsperado.getId()).when(resultSet).getInt(any());
        when(resultSet.getDouble(any())).thenReturn(productoEsperado.getPrecio());
        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("NombreProducto")){
                    return productoEsperado.getNombre();
                } else if(invocationOnMock.getArgument(0).equals("DescripcionProducto")) {
                    return productoEsperado.getDescripcion();
                } else if(invocationOnMock.getArgument(0).equals("ImagenProducto")) {
                    return productoEsperado.getImagen();
                }else{
                    return null;
                }
            }
        });

        //Set<Producto> productoSet = productoManager.getAll(connection);

        //MatcherAssert.assertThat(productoSet, Matchers.hasSize(1));
        //MatcherAssert.assertThat(productoSet.iterator().next(), Matchers.is(productoEsperado));

    }

    @Test
    void getById_ok() throws SQLException{
        Producto productoEsperado = Producto.builder().id(1).precio(1).nombre("Nombre").descripcion("descripcion").imagen("imagen.jpg").build();

        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(any())).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                if(counter < 1){
                    counter++;
                    return true;
                } else {
                    return false;
                }
            }
        });

        doReturn(productoEsperado.getId()).when(resultSet).getInt(any());
        when(resultSet.getDouble(any())).thenReturn(productoEsperado.getPrecio());
        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("NombreProducto")){
                    return productoEsperado.getNombre();
                } else if(invocationOnMock.getArgument(0).equals("DescripcionProducto")) {
                    return productoEsperado.getDescripcion();
                } else if(invocationOnMock.getArgument(0).equals("ImagenProducto")) {
                    return productoEsperado.getImagen();
                }else{
                    return null;
                }
            }
        });

        Producto productoSet = productoManager.getById(connection, 1);

        //MatcherAssert.assertThat(productoSet, Matchers.hasSize(1));
        //MatcherAssert.assertThat(productoSet.iterator().next(), Matchers.is(productoEsperado));

    }

}
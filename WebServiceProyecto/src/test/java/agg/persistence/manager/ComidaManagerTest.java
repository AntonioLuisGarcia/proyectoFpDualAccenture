package agg.persistence.manager;


import agg.dao.Productos.Comida;
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
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComidaManagerTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private ComidaManager comidaManager;

    @Test
    void getAll_ok() throws SQLException {

        Comida comida = new Comida(1,1,"","","",true,1);
        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
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

        doReturn(comida.isVegano()).when(resultSet).getBoolean(any());
        when(resultSet.getDouble(any())).thenReturn(comida.getPrecio());
        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdComida")){
                    return comida.getId();
                } else if(invocationOnMock.getArgument(0).equals("TiemporPreparacion")) {
                    return comida.getTiempoDePreparacion();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("NombreProducto")){
                    return comida.getNombre();
                } else if(invocationOnMock.getArgument(0).equals("DescripcionProducto")) {
                    return comida.getDescripcion();
                } else if(invocationOnMock.getArgument(0).equals("ImagenProducto")) {
                    return comida.getImagen();
                }else{
                    return null;
                }
            }
        });

        List<Comida> comidasTest = comidaManager.getAll(connection);

        MatcherAssert.assertThat(comidasTest, Matchers.hasSize(1));
        MatcherAssert.assertThat(comidasTest.iterator().next(), Matchers.is(comida));
    }

    @Test
    void getById_ok() throws SQLException {

        Comida comida = new Comida(1,1,"","","",true,1);
        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
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

        doReturn(comida.isVegano()).when(resultSet).getBoolean(any());
        when(resultSet.getDouble(any())).thenReturn(comida.getPrecio());
        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdComida")){
                    return comida.getId();
                } else if(invocationOnMock.getArgument(0).equals("TiemporPreparacion")) {
                    return comida.getTiempoDePreparacion();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("NombreProducto")){
                    return comida.getNombre();
                } else if(invocationOnMock.getArgument(0).equals("DescripcionProducto")) {
                    return comida.getDescripcion();
                } else if(invocationOnMock.getArgument(0).equals("ImagenProducto")) {
                    return comida.getImagen();
                }else{
                    return null;
                }
            }
        });

        Comida comidaTest = comidaManager.getById(connection, comida.getId());

        MatcherAssert.assertThat(comidaTest, Matchers.is(comida));
    }

}

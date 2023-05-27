package agg.persistence.manager;


import agg.dao.Productos.Bebida;
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
class BebidaManagerTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private BebidaManager bebidaManager;

    @Test
    void getAll_ok() throws SQLException {

        Bebida bebida = new Bebida(1,1,"","","",true,1);
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

        doReturn(bebida.isAlcoholica()).when(resultSet).getBoolean(any());
        when(resultSet.getDouble(any())).thenReturn(bebida.getPrecio());
        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdBebida")){
                    return bebida.getId();
                } else if(invocationOnMock.getArgument(0).equals("Mililitros")) {
                    return bebida.getMiliLitros();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("NombreProducto")){
                    return bebida.getNombre();
                } else if(invocationOnMock.getArgument(0).equals("DescripcionProducto")) {
                    return bebida.getDescripcion();
                } else if(invocationOnMock.getArgument(0).equals("ImagenProducto")) {
                    return bebida.getImagen();
                }else{
                    return null;
                }
            }
        });

        List<Bebida> bebidasTest = bebidaManager.getAll(connection);

        MatcherAssert.assertThat(bebidasTest, Matchers.hasSize(1));
        MatcherAssert.assertThat(bebidasTest.iterator().next(), Matchers.is(bebida));
    }

    @Test
    void getById_ok() throws SQLException {

        Bebida bebida = new Bebida(1,1,"","","",true,1);
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

        doReturn(bebida.isAlcoholica()).when(resultSet).getBoolean(any());
        when(resultSet.getDouble(any())).thenReturn(bebida.getPrecio());
        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdBebida")){
                    return bebida.getId();
                } else if(invocationOnMock.getArgument(0).equals("Mililitros")) {
                    return bebida.getMiliLitros();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("NombreProducto")){
                    return bebida.getNombre();
                } else if(invocationOnMock.getArgument(0).equals("DescripcionProducto")) {
                    return bebida.getDescripcion();
                } else if(invocationOnMock.getArgument(0).equals("ImagenProducto")) {
                    return bebida.getImagen();
                }else{
                    return null;
                }
            }
        });

        Bebida bebidaTest = bebidaManager.getById(connection, bebida.getId());

        MatcherAssert.assertThat(bebidaTest, Matchers.is(bebida));
    }
}

package agg.persistence.manager;

import agg.dao.ComandaProducto;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComandaProductoManagerTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private ComandaProductoManager comandaProductoManager;

    private ComandaProducto comandaProducto = new ComandaProducto(1,1,1,1);

    @Test
    void getProductosById_ok() throws SQLException {

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

        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdComandaProducto")){
                    return comandaProducto.getId();
                } else if(invocationOnMock.getArgument(0).equals("IdProducto")) {
                    return comandaProducto.getIdProducto();
                } else if(invocationOnMock.getArgument(0).equals("IdComanda")) {
                    return comandaProducto.getIdComanda();
                }else if(invocationOnMock.getArgument(0).equals("Cantidad")) {
                    return comandaProducto.getCantidad();
                }else{
                    return null;
                }
            }
        });


        List<ComandaProducto> comandaProductosTest = comandaProductoManager.getProductosById(connection, comandaProducto.getIdComanda());

        MatcherAssert.assertThat(comandaProductosTest, Matchers.hasSize(1));
        MatcherAssert.assertThat(comandaProductosTest.iterator().next(), Matchers.is(comandaProducto));
    }

    @Test
    void getById_ok() throws SQLException {

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

        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdComandaProducto")){
                    return comandaProducto.getId();
                } else if(invocationOnMock.getArgument(0).equals("IdProducto")) {
                    return comandaProducto.getIdProducto();
                } else if(invocationOnMock.getArgument(0).equals("IdComanda")) {
                    return comandaProducto.getIdComanda();
                }else if(invocationOnMock.getArgument(0).equals("Cantidad")) {
                    return comandaProducto.getCantidad();
                }else{
                    return null;
                }
            }
        });


        ComandaProducto comandaProductoTest = comandaProductoManager.getById(connection, comandaProducto.getId());

        MatcherAssert.assertThat(comandaProductoTest, Matchers.is(comandaProducto));
    }
}
package agg.persistence.manager;

import agg.dao.Comanda;
import agg.dao.ComandaProducto;
import agg.persistence.service.ComandaService;
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
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ComandaManagerTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private ComandaManager comandaManager;


    private Comanda comanda = new Comanda(0,0,0,"","",new ArrayList<ComandaProducto>(),false);


    @Test
    void getAll_ok() throws SQLException {

        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        //when(comandaService.getById(Mockito.anyInt())).thenReturn(comanda);
        //when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
        //when(preparedStatement.getGeneratedKeys().getInt(any())).thenReturn(comanda.getId());
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

        doReturn(comanda.isPagada()).when(resultSet).getBoolean(any());

        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdComanda")){
                    return comanda.getId();
                } else if(invocationOnMock.getArgument(0).equals("IdCamarero")) {
                    return comanda.getIdCamarero();
                } else if(invocationOnMock.getArgument(0).equals("IdMesa")) {
                    return comanda.getIdMesa();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("EmailContacto")){
                    return comanda.getEmailContacto();
                } else if(invocationOnMock.getArgument(0).equals("FechaLlegada")) {
                    return comanda.getLlegada();
                }else{
                    return null;
                }
            }
        });

        List<Comanda> comandasTest = comandaManager.getAll(connection);

        MatcherAssert.assertThat(comandasTest, Matchers.hasSize(1));
        MatcherAssert.assertThat(comandasTest.iterator().next(), Matchers.is(comanda));
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

        doReturn(comanda.isPagada()).when(resultSet).getBoolean(any());

        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdComanda")){
                    return comanda.getId();
                } else if(invocationOnMock.getArgument(0).equals("IdCamarero")) {
                    return comanda.getIdCamarero();
                } else if(invocationOnMock.getArgument(0).equals("IdMesa")) {
                    return comanda.getIdMesa();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("EmailContacto")){
                    return comanda.getEmailContacto();
                } else if(invocationOnMock.getArgument(0).equals("FechaLlegada")) {
                    return comanda.getLlegada();
                }else{
                    return null;
                }
            }
        });

        Comanda comandaTest = comandaManager.getById(connection, comanda.getId());

        MatcherAssert.assertThat(comandaTest, Matchers.is(comanda));
    }

    @Test
    void getNoPagadas_ok() throws SQLException {

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

        doReturn(comanda.isPagada()).when(resultSet).getBoolean(any());

        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdComanda")){
                    return comanda.getId();
                } else if(invocationOnMock.getArgument(0).equals("IdCamarero")) {
                    return comanda.getIdCamarero();
                } else if(invocationOnMock.getArgument(0).equals("IdMesa")) {
                    return comanda.getIdMesa();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("EmailContacto")){
                    return comanda.getEmailContacto();
                } else if(invocationOnMock.getArgument(0).equals("FechaLlegada")) {
                    return comanda.getLlegada();
                }else{
                    return null;
                }
            }
        });

        List<Comanda> comandasTest = comandaManager.getNoPagadas(connection);

        MatcherAssert.assertThat(comandasTest, Matchers.hasSize(1));
        MatcherAssert.assertThat(comandasTest.iterator().next(), Matchers.is(comanda));
    }

    @Test
    void getNoPagadasYPorIdCamarero_ok() throws SQLException {

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

        doReturn(comanda.isPagada()).when(resultSet).getBoolean(any());

        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdComanda")){
                    return comanda.getId();
                } else if(invocationOnMock.getArgument(0).equals("IdCamarero")) {
                    return comanda.getIdCamarero();
                } else if(invocationOnMock.getArgument(0).equals("IdMesa")) {
                    return comanda.getIdMesa();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("EmailContacto")){
                    return comanda.getEmailContacto();
                } else if(invocationOnMock.getArgument(0).equals("FechaLlegada")) {
                    return comanda.getLlegada();
                }else{
                    return null;
                }
            }
        });

        List<Comanda> comandasTest = comandaManager.getNoPagadasYPorIdCamarero(connection, comanda.getIdCamarero());

        MatcherAssert.assertThat(comandasTest, Matchers.hasSize(1));
        MatcherAssert.assertThat(comandasTest.iterator().next(), Matchers.is(comanda));
    }

    /*@Test
    void pagar_ok() throws SQLException {

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

        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                boolean arg1 = (boolean) args[1];

                // Realiza acciones adicionales según el valor pasado al método setBoolean
                // Por ejemplo, puedes almacenar el valor en una variable o hacer alguna otra lógica

                return null; // Método void, por lo que no hay valor de retorno
            }
        }).when(preparedStatement).setBoolean(eq(any()), anyBoolean());

        Comanda comandaTest = comandaManager.pagar(connection, comanda.getId());

        MatcherAssert.assertThat(comandaTest, Matchers.is(comanda));
    }

    @Test
    void create_ok() throws SQLException {

        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate(any())).thenReturn(1);
        when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);

        Comanda comandaTest = comandaManager.create(connection, comanda.getIdMesa(), comanda.getIdCamarero(), comanda.getEmailContacto());

        verify(preparedStatement).executeUpdate();
        MatcherAssert.assertThat(comandaTest, Matchers.is(comanda));
    }*/
}
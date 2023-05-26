package agg.persistence.manager;

import agg.dao.Camarero;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CamareroManagerTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private CamareroManager camareroManager;

    @Test
    void getById_ok() throws SQLException{
        Camarero camareroEsperado = new Camarero(1,"Juan","Garcia","juan","1234");

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

        doReturn(camareroEsperado.getId()).when(resultSet).getInt(any());

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("NombreCamarero")){
                    return camareroEsperado.getNombre();
                } else if(invocationOnMock.getArgument(0).equals("ApellidoCamarero")) {
                    return camareroEsperado.getApellidos();
                } else if(invocationOnMock.getArgument(0).equals("UsuarioCamarero")) {
                    return camareroEsperado.getUsuario();
                }else if(invocationOnMock.getArgument(0).equals("ContraseniaCamarero")){
                    return camareroEsperado.getContrasenia();
                }else{
                    return null;
                }
            }
        });

        Camarero camareroTest = camareroManager.getById(connection,1);

        MatcherAssert.assertThat(camareroTest, Matchers.is(camareroEsperado));
    }

    @Test
    void getCamareroByUserAndPassword_ok()throws SQLException{
        Camarero camareroEsperado = new Camarero(1,"Juan","Garcia","juan","1234");

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

        doReturn(camareroEsperado.getId()).when(resultSet).getInt(any());

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("NombreCamarero")){
                    return camareroEsperado.getNombre();
                } else if(invocationOnMock.getArgument(0).equals("ApellidoCamarero")) {
                    return camareroEsperado.getApellidos();
                } else if(invocationOnMock.getArgument(0).equals("UsuarioCamarero")) {
                    return camareroEsperado.getUsuario();
                }else if(invocationOnMock.getArgument(0).equals("ContraseniaCamarero")){
                    return camareroEsperado.getContrasenia();
                }else{
                    return null;
                }
            }
        });

        Camarero camareroTest = camareroManager.getCamareroByUserAndPassword(connection,camareroEsperado.getUsuario(), camareroEsperado.getContrasenia());

        MatcherAssert.assertThat(camareroTest, Matchers.is(camareroEsperado));

    }

    /*@Test
    void getById_ko() throws SQLException {
        when(connection.createStatement()).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenThrow(new SQLException("Mock SQLException"));

        Camarero camareroSet = camareroManager.getById(connection, anyInt());

        MatcherAssert.assertThat(camareroSet, Matchers.nullValue());
    }*/
}
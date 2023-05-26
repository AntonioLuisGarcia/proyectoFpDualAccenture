package agg.persistence.manager;


import agg.dao.Mesa;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MesaManagerTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private MesaManager mesaManager;

    @Test
    void getAll_ok() throws SQLException {
        Mesa mesa = new Mesa(1,1,0);

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

                if(invocationOnMock.getArgument(0).equals("IdMesa")){
                    return mesa.getId();
                } else if(invocationOnMock.getArgument(0).equals("NumeroMesa")) {
                    return mesa.getNumero();
                }else if(invocationOnMock.getArgument(0).equals("PersonasMesa")) {
                    return mesa.getNumeroPersonas();
                }else{
                    return null;
                }
            }
        });

        List<Mesa> mesasTest = mesaManager.getAll(connection);

        MatcherAssert.assertThat(mesasTest, Matchers.hasSize(1));
        MatcherAssert.assertThat(mesasTest.iterator().next(), Matchers.is(mesa));
    }

    @Test
    void getById_ok() throws SQLException {
        Mesa mesa = new Mesa(1,1,1);

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

                if(invocationOnMock.getArgument(0).equals("IdMesa")){
                    return mesa.getId();
                } else if(invocationOnMock.getArgument(0).equals("NumeroMesa")) {
                    return mesa.getNumero();
                }else if(invocationOnMock.getArgument(0).equals("PersonasMesa")) {
                    return mesa.getNumeroPersonas();
                }else{
                    return null;
                }
            }
        });

        Mesa mesaTest = mesaManager.getById(connection, mesa.getId());

        MatcherAssert.assertThat(mesaTest, Matchers.is(mesa));
    }
}
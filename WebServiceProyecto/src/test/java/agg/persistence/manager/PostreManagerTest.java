package agg.persistence.manager;

import agg.dao.Productos.Postre;
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
class PostreManagerTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private PostreManager postreManager;

    @Test
    void getAll_ok() throws SQLException {

        Postre postre = new Postre(1,1,"","","",1,1);
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

        when(resultSet.getDouble(any())).thenReturn(postre.getPrecio());
        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdPostre")){
                    return postre.getId();
                } else if(invocationOnMock.getArgument(0).equals("Kcal")) {
                    return postre.getKcal();
                }else if(invocationOnMock.getArgument(0).equals("PersonasParaCompartir")) {
                    return postre.getPersonasParaCompartir();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("NombreProducto")){
                    return postre.getNombre();
                } else if(invocationOnMock.getArgument(0).equals("DescripcionProducto")) {
                    return postre.getDescripcion();
                } else if(invocationOnMock.getArgument(0).equals("ImagenProducto")) {
                    return postre.getImagen();
                }else{
                    return null;
                }
            }
        });

        List<Postre> postresTest = postreManager.getAll(connection);

        MatcherAssert.assertThat(postresTest, Matchers.hasSize(1));
        MatcherAssert.assertThat(postresTest.iterator().next(), Matchers.is(postre));
    }

    @Test
    void getById_ok() throws SQLException {

        Postre postre = new Postre(1,1,"","","",1,1);
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

        when(resultSet.getDouble(any())).thenReturn(postre.getPrecio());
        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("IdPostre")){
                    return postre.getId();
                } else if(invocationOnMock.getArgument(0).equals("Kcal")) {
                    return postre.getKcal();
                }else if(invocationOnMock.getArgument(0).equals("PersonasParaCompartir")) {
                    return postre.getPersonasParaCompartir();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("NombreProducto")){
                    return postre.getNombre();
                } else if(invocationOnMock.getArgument(0).equals("DescripcionProducto")) {
                    return postre.getDescripcion();
                } else if(invocationOnMock.getArgument(0).equals("ImagenProducto")) {
                    return postre.getImagen();
                }else{
                    return null;
                }
            }
        });

        Postre postreTest = postreManager.getById(connection, postre.getId());

        MatcherAssert.assertThat(postreTest, Matchers.is(postre));
    }
}
package agg.persistence.service;

import agg.dao.Productos.Comida;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComidaManager;
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
class ComidaServiceTest {

    @Mock
    private MySQLConnector mySQLConnector;

    @Mock
    private Connection connection;

    @Mock
    private ComidaManager comidaManager;

    @BeforeEach
    public void init(){
        comidaService = new ComidaService(comidaManager, mySQLConnector);
    }

    private ComidaService comidaService;

    @Test
    void getAll_ok() throws SQLException, ClassNotFoundException {
        Comida comida = new Comida(1,1,"","","",true,1);
        List<Comida> comidas = new ArrayList<>();
        comidas.add(comida);

        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comidaManager.getAll(Mockito.any())).thenReturn((ArrayList<Comida>) comidas);

        List<Comida> comidasTest = comidaService.getAll();

        MatcherAssert.assertThat(comidasTest, Matchers.is(comidas));
    }

    @Test
    void getById_ok() throws SQLException, ClassNotFoundException {
        Comida comida = new Comida(1,1,"","","",true,1);

        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comidaManager.getById(Mockito.any(), Mockito.anyInt())).thenReturn(comida);

        Comida comidaTest = comidaService.getById(comida.getId());

        MatcherAssert.assertThat(comidaTest, Matchers.is(comida));
    }
}
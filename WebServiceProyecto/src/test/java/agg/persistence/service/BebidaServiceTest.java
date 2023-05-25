package agg.persistence.service;

import agg.dao.Productos.Bebida;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.BebidaManager;
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
class BebidaServiceTest {

    @Mock
    private MySQLConnector mySQLConnector;

    @Mock
    private Connection connection;

    @Mock
    private BebidaManager bebidaManager;

    @BeforeEach
    public void init(){
        bebidaService = new BebidaService(bebidaManager, mySQLConnector);
    }

    private BebidaService bebidaService;

    @Test
    void getAll_ok() throws SQLException, ClassNotFoundException {
        Bebida bebida = new Bebida(1,1,"","","",true,1);
        List<Bebida> bebidas = new ArrayList<>();
        bebidas.add(bebida);

        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(bebidaManager.getAll(Mockito.any())).thenReturn(bebidas);

        List<Bebida> bebidasTest = bebidaService.getAll();

        MatcherAssert.assertThat(bebidasTest, Matchers.is(bebidas));
    }

    @Test
    void getById_ok() throws SQLException, ClassNotFoundException {
        Bebida bebida = new Bebida(1,1,"","","",true,1);

        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(bebidaManager.getById(Mockito.any(), Mockito.anyInt())).thenReturn(bebida);

        Bebida bebidaTest = bebidaService.getById(bebida.getId());

        MatcherAssert.assertThat(bebidaTest, Matchers.is(bebida));
    }

}
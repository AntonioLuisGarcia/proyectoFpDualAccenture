package agg.persistence.service;

import agg.dao.Mesa;
import agg.dao.Productos.Postre;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.MesaManager;
import agg.persistence.manager.PostreManager;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MesaServiceTest {

    @Mock
    private MySQLConnector mySQLConnector;

    @Mock
    private Connection connection;

    @Mock
    private MesaManager mesaManager;

    @BeforeEach
    public void init(){
        mesaService = new MesaService(mesaManager, mySQLConnector);
    }

    private MesaService mesaService;

    @Test
    void getById_ok() throws SQLException, ClassNotFoundException {
        Mesa mesa = new Mesa(1,1,1);

        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(mesaManager.getById(Mockito.any(), Mockito.anyInt())).thenReturn(mesa);

        Mesa mesaTest = mesaService.getById(mesa.getId());

        MatcherAssert.assertThat(mesaTest, Matchers.is(mesa));
    }

}
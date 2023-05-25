package agg.persistence.service;

import agg.dao.Camarero;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.CamareroManager;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CamareroServiceTest {

    @Mock
    private MySQLConnector mySQLConnector;

    @Mock
    private Connection connection;

    @Mock
    private CamareroManager camareroManager;

    @BeforeEach
    public void init(){
        camareroService = new CamareroService(camareroManager, mySQLConnector);
    }

    private CamareroService camareroService;

    @Test
    public void getCamareroByUserAndPassword_ok() throws SQLException, ClassNotFoundException {
        Camarero camarero = new Camarero(1, "","","","");
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(camareroManager.getCamareroByUserAndPassword(Mockito.any(), Mockito.anyString(), Mockito.anyString())).thenReturn(camarero);

        Camarero camarero1 = camareroService.getCamareroByUserAndPassword(camarero.getUsuario(),camarero.getContrasenia());

        MatcherAssert.assertThat(camarero1, Matchers.is(camarero));
    }

    @Test
    void getById_ok() throws SQLException, ClassNotFoundException {

        Camarero camarero = new Camarero(1, "","","","");
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(camareroManager.getById(Mockito.any(), Mockito.anyInt())).thenReturn(camarero);

        Camarero camarero1 = camareroService.getById(camarero.getId());

        MatcherAssert.assertThat(camarero1, Matchers.is(camarero));
    }
}
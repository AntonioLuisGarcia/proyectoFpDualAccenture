package agg.persistence.service;

import agg.dao.Comanda;
import agg.dao.ComandaProducto;
import agg.persistence.conector.MySQLConnector;
import agg.persistence.manager.ComandaManager;
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
class ComandaServiceTest {

    @Mock
    private MySQLConnector mySQLConnector;

    @Mock
    private Connection connection;

    @Mock
    private ComandaManager comandaManager;

    private ComandaService comandaService;

    @BeforeEach
    public void init(){
        comandaService = new ComandaService(comandaManager, mySQLConnector);
    }

    @Test
    void getById_ok() throws SQLException, ClassNotFoundException {
        Comanda comanda = new Comanda(1,1,1,"","",new ArrayList<ComandaProducto>(), true);
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaManager.getById(Mockito.any(), Mockito.anyInt())).thenReturn(comanda);

        Comanda comandaTest = comandaService.getById(comanda.getId());

        MatcherAssert.assertThat(comandaTest, Matchers.is(comanda));
    }

    @Test
    void getAll_ok() throws SQLException, ClassNotFoundException {
        Comanda comanda = new Comanda(1,1,1,"","",new ArrayList<ComandaProducto>(), true);
        List<Comanda> comandas = new ArrayList<>();
        comandas.add(comanda);
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaManager.getAll(Mockito.any())).thenReturn(comandas);

        List<Comanda> comandasTest = comandaService.getAll();

        MatcherAssert.assertThat(comandasTest, Matchers.is(comandas));
    }

    @Test
    void getNoPagadas_ok() throws SQLException, ClassNotFoundException {
        Comanda comanda = new Comanda(1,1,1,"","",new ArrayList<ComandaProducto>(), true);
        List<Comanda> comandas = new ArrayList<>();
        comandas.add(comanda);
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaManager.getNoPagadas(Mockito.any())).thenReturn(comandas);

        List<Comanda> comandasTest = comandaService.getNoPagadas();

        MatcherAssert.assertThat(comandasTest, Matchers.is(comandas));
    }

    @Test
    void pagar_ok() throws SQLException, ClassNotFoundException{
        Comanda comanda = new Comanda(1,1,1,"","",new ArrayList<ComandaProducto>(), true);
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaManager.pagar(Mockito.any(),Mockito.anyInt())).thenReturn(comanda);

        Comanda comandaTest = comandaService.pagar(comanda.getId());

        MatcherAssert.assertThat(comandaTest, Matchers.is(comanda));
    }

    @Test
    void getNoPagadasYPorIdCamarero_ok() throws SQLException, ClassNotFoundException {
        Comanda comanda = new Comanda(1,1,1,"","",new ArrayList<ComandaProducto>(), true);
        List<Comanda> comandas = new ArrayList<>();
        comandas.add(comanda);
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaManager.getNoPagadasYPorIdCamarero(Mockito.any(), Mockito.anyInt())).thenReturn(comandas);

        List<Comanda> comandasTest = comandaService.getNoPagadasYPorIdCamarero(comanda.getIdCamarero());

        MatcherAssert.assertThat(comandasTest, Matchers.is(comandas));
    }

    @Test
    void create_ok() throws SQLException, ClassNotFoundException {
        Comanda comanda = new Comanda(1,1,1,"","",new ArrayList<ComandaProducto>(), true);
        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(comandaManager.create(Mockito.any(), Mockito.anyInt(),Mockito.anyInt(),Mockito.anyString())).thenReturn(comanda);

        Comanda comandaTest = comandaService.create(comanda.getIdMesa(), comanda.getIdCamarero(), comanda.getEmailContacto());

        MatcherAssert.assertThat(comandaTest, Matchers.is(comanda));
    }

}
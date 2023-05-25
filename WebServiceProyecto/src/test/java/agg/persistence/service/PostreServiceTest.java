package agg.persistence.service;

import agg.dao.Productos.Postre;
import agg.persistence.conector.MySQLConnector;
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
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostreServiceTest {

    @Mock
    private MySQLConnector mySQLConnector;

    @Mock
    private Connection connection;

    @Mock
    private PostreManager postreManager;

    @BeforeEach
    public void init(){
        postreService = new PostreService(postreManager, mySQLConnector);
    }

    private PostreService postreService;

    @Test
    void getAll_ok() throws SQLException, ClassNotFoundException {
        Postre postre = new Postre(1,1,"","","",1,1);
        List<Postre> postres = new ArrayList<>();
        postres.add(postre);

        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(postreManager.getAll(Mockito.any())).thenReturn((ArrayList<Postre>) postres);

        List<Postre> postresTest = postreService.getAll();

        MatcherAssert.assertThat(postresTest, Matchers.is(postres));
    }

    @Test
    void getById_ok() throws SQLException, ClassNotFoundException {
        Postre postre = new Postre(1,1,"","","",1,1);

        when(mySQLConnector.getMySQLConnection()).thenReturn(connection);
        when(postreManager.getById(Mockito.any(), Mockito.anyInt())).thenReturn(postre);

        Postre postreTest = postreService.getById(postre.getId());

        MatcherAssert.assertThat(postreTest, Matchers.is(postre));
    }
}
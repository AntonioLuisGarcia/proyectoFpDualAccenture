package agg.controller;

import agg.dao.Productos.Postre;
import agg.persistence.service.PostreService;
import jakarta.ws.rs.core.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostreControllerTest {

    @Mock
    private PostreService postreService;

    @Mock
    private Postre postre;

    @Mock
    private List<Postre> listaPostres;

    @InjectMocks
    private PostreController postreController;

    @Test
    void getById_ok(){
        when(postreService.getById(Mockito.anyInt())).thenReturn(postre);

        Response response = postreController.getById(Mockito.anyInt());

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(postre));
    }

    @Test
    void getAll_ok(){
        when(postreService.getAll()).thenReturn(listaPostres);

        Response response = postreController.getAll();

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(listaPostres));
    }
}

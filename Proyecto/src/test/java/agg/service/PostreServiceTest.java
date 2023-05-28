package agg.service;

import agg.client.PostreClient;
import agg.persistence.dao.clases.Productos.Postre;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PostreServiceTest {

    @Mock
    private PostreClient postreClient;

    @Mock
    private List<Postre> postres;

    @Mock
    private Postre postre;

    @InjectMocks
    private PostreService postreService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void listAll() {
        when(postreClient.listAll()).thenReturn(postres);

        List<Postre> postresTest = postreService.listAll();

        MatcherAssert.assertThat(postresTest, Matchers.is(postres));
    }

    @Test
    void getById() {
        when(postreClient.getById(Mockito.anyInt())).thenReturn(postre);

        Postre postreTest = postreService.getById(Mockito.anyInt());

        MatcherAssert.assertThat(postreTest, Matchers.is(postre));
    }
}
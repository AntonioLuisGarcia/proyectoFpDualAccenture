package agg.controller;


import agg.dao.Camarero;
import agg.persistence.service.CamareroService;
import jakarta.ws.rs.core.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CamareroControllerTest {

    @Mock
    private CamareroService camareroService;

    @Mock
    private Camarero camarero;

    @InjectMocks
    private CamareroController camareroController;

    @Test
    void getById_ok(){
        when(camareroService.getById(Mockito.anyInt())).thenReturn(camarero);

        Response response = camareroController.getById(1);

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(camarero));
    }

    @Test
    void getCamareroByUserAndPassword_ok(){
        when(camareroService.getCamareroByUserAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(camarero);

        Response response = camareroController.getCamareroByUserAndPassword(Mockito.anyString(), Mockito.anyString());

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(camarero));
    }
}
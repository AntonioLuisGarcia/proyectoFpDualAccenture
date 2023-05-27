package agg.controller;


import agg.dao.Mesa;
import agg.persistence.service.MesaService;
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
class MesaControllerTest {

    @Mock
    private MesaService mesaService;

    @Mock
    private Mesa mesa;

    @InjectMocks
    private MesaController mesaController;

    @Test
    void getById_ok(){
        when(mesaService.getById(Mockito.anyInt())).thenReturn(mesa);

        Response response = mesaController.getById(Mockito.anyInt());

        MatcherAssert.assertThat(response.getEntity(), Matchers.is(mesa));
    }

}

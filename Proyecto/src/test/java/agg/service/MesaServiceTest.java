package agg.service;

import agg.client.MesaClient;
import agg.persistence.dao.clases.Mesa;
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

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MesaServiceTest {

    @Mock
    private MesaClient mesaClient;

    @Mock
    private Mesa mesa;

    @InjectMocks
    private MesaService mesaService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getById() {
        when(mesaClient.getById(Mockito.anyInt())).thenReturn(mesa);

        Mesa mesaTest = mesaService.getById(Mockito.anyInt());

        MatcherAssert.assertThat(mesaTest, Matchers.is(mesa));
    }
}
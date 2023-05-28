package agg.service;

import agg.client.CamareroClient;
import agg.persistence.dao.clases.Camarero;
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
class CamareroServiceTest {

    @Mock
    private CamareroClient camareroClient;

    @Mock
    private Camarero camarero;

    @InjectMocks
    private CamareroService camareroService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void verificateUserByUserAndPassword_ok() {
        when(camareroClient.verificateUserByUserAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(camarero);

        Camarero camareroTest = camareroService.verificateUserByUserAndPassword(Mockito.anyString(), Mockito.anyString());

        MatcherAssert.assertThat(camareroTest, Matchers.is(camarero));
    }

    @Test
    void getById_ok() {
        when(camareroClient.getById(Mockito.anyInt())).thenReturn(camarero);

        Camarero camareroTest = camareroService.getById(Mockito.anyInt());

        MatcherAssert.assertThat(camareroTest, Matchers.is(camarero));
    }
}
package com.willdevp.clienteinfoservice.service;

import com.willdevp.clienteinfoservice.exception.InvalidInputException;
import com.willdevp.clienteinfoservice.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ClienteServiceImplTest {

    @MockBean
    private ClienteServiceImpl clienteService;

    @BeforeEach
    public void setUp() {
        clienteService = new ClienteServiceImpl();
    }

    @Test
    public void testGetClienteByTipoAndNumeroValid() {
        Cliente result = clienteService.getClienteByTipoIdAndNumeroId("C", "23445322");
        assertNotNull(result);
    }

    @Test
    public void testGetClienteByTipoAndNumeroInvalid() {
        assertThrows(InvalidInputException.class, () -> {
            clienteService.getClienteByTipoIdAndNumeroId("Z", "123456");
        });
    }
}

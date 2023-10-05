package com.willdevp.clienteinfoservice.controller;

import com.willdevp.clienteinfoservice.exception.InvalidInputException;
import com.willdevp.clienteinfoservice.model.Cliente;
import com.willdevp.clienteinfoservice.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void testGetClienteByTipoAndNumeroValid() throws Exception {
        Cliente mockCliente = new Cliente(
                "Wilmar",
                "Dario",
                "Garcia",
                "Valderrama",
                "1234567890",
                "Calle 123 # 45 - 67",
                "Medellin"
        );
        when(clienteService.getClienteByTipoIdAndNumeroId("C", "23445322")).thenReturn(mockCliente);

        mockMvc.perform(get("/cliente?tipoId=C&numeroId=23445322"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.primerNombre").value("Wilmar"));
    }

    @Test
    public void testGetClienteByTipoAndNumeroInvalid() throws Exception {
        when(clienteService.getClienteByTipoIdAndNumeroId("Z", "123456")).thenThrow(InvalidInputException.class);

        mockMvc.perform(get("/cliente?tipoId=Z&numeroId=123456"))
                .andExpect(status().isBadRequest());
    }
}
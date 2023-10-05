package com.willdevp.clienteinfoservice.service;

import com.willdevp.clienteinfoservice.exception.ClienteNotFoundException;
import com.willdevp.clienteinfoservice.exception.InvalidInputException;
import com.willdevp.clienteinfoservice.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
    private static final String TIPO_CEDULA = "C";
    private static final String TIPO_PASAPORTE = "P";
    private static final String NUMERO_CEDULA_MOCK = "23445322";
    @Override
    public Cliente getClienteByTipoIdAndNumeroId(String tipoId, String numeroId) {
        if (!isValidInput(tipoId, numeroId)) {
            throw new InvalidInputException("Tipo o número de documento inválido.");
        }
        if (isMockedCliente(tipoId, numeroId)) {
            return createMockedCliente();
        }
        throw new ClienteNotFoundException("Cliente no encontrado.");
    }
    private boolean isMockedCliente(String tipoId, String numeroId) {
        return TIPO_CEDULA.equalsIgnoreCase(tipoId) && NUMERO_CEDULA_MOCK.equals(numeroId);
    }
    private boolean isValidInput(String tipoId, String numeroId) {
        if (tipoId == null || numeroId == null) {
            throw new InvalidInputException("El tipo o número de documento no puede ser nulo.");
        }
        if (!TIPO_CEDULA.equalsIgnoreCase(tipoId) && !TIPO_PASAPORTE.equalsIgnoreCase(tipoId)) {
            throw new InvalidInputException("El tipo de documento debe ser 'C' (Cédula de ciudadanía) o 'P' (Pasaporte).");
        }
        return true;
    }
    private Cliente createMockedCliente() {
        return new Cliente(
                "Wilmar",
                "Dario",
                "Garcia",
                "Valderrama",
                "1234567890",
                "Calle 123 # 45 - 67",
                "Medellin");
    }
}

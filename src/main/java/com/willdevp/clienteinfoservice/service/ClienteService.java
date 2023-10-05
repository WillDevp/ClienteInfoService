package com.willdevp.clienteinfoservice.service;

import com.willdevp.clienteinfoservice.model.Cliente;

public interface ClienteService {
    Cliente getClienteByTipoIdAndNumeroId(String tipoId, String numeroId);
}

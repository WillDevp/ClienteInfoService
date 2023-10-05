package com.willdevp.clienteinfoservice.controller;

import com.willdevp.clienteinfoservice.model.Cliente;
import com.willdevp.clienteinfoservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/cliente")
    public ResponseEntity<Cliente> getCliente(
            @RequestParam(required = false) String tipoId,
            @RequestParam(required = false) String numeroId
    ){
        if (tipoId == null || numeroId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!"C".equalsIgnoreCase(tipoId) && !"P".equalsIgnoreCase(tipoId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cliente cliente = clienteService.getClienteByTipoIdAndNumeroId(tipoId, numeroId);
        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}

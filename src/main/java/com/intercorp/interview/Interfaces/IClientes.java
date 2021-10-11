package com.intercorp.interview.Interfaces;


import com.intercorp.interview.Models.Cliente;
import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.message.Message;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Tag(name = "clientes", description = "Api para clientes")
@RequestMapping("clientes")
public interface IClientes {

    @Operation(summary = "Create client", description = "Creates a new client", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid user suplied")}
    )
    @PostMapping(value = "/creaCliente")
    ResponseEntity<Cliente> createClient(@Parameter(description = "Cliente a agregar", required = true) Cliente cliente);

    @Operation(summary = "kpi de Clientes", description = "Promedio edad mas desviacion standard de edades", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Message.class)))
    })
    @GetMapping(value = "/kpideclientes", produces = { "application/text" })
    ResponseEntity<String> kpiClients();

    @Operation(summary = "Get Clients", description = "Lista de personas + fecha prob de muerte", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Message.class)))}
    )
    @GetMapping(value = "/lisclientes", produces = { "application/json" })
    ResponseEntity<List<Cliente>> listClients();

}

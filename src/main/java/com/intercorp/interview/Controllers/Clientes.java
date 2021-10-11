package com.intercorp.interview.Controllers;


import com.intercorp.interview.Interfaces.IClientes;
import com.intercorp.interview.Models.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class Clientes implements IClientes {

    private List<Cliente> clientes;

    public Clientes(){
        this.clientes = new ArrayList<>();
    }

    @Override
    public ResponseEntity<Cliente> createClient(Cliente cliente) {
        clientes.add(cliente);
        return ResponseEntity.ok(cliente);
    }

    @Override
    public ResponseEntity<String> kpiClients() {
        int n = clientes.size();

        // Average calculation
        Integer partialSum = clientes.stream()
                .map(c -> c.getEdad())
                .reduce(0, Integer::sum);
        Integer average = partialSum / n;

        // Desviation calculation
        Double desv = clientes.stream()
                .map(c -> c.getEdad())
                .map(e -> Math.pow(e - average,2))
                .reduce(0.0, Double::sum);

        desv = Math.sqrt(desv / n);

        String response = "El promedio de las edades es: " + average.toString() + " . Y la desviacion estandar es: " + desv.toString();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<Cliente>> listClients() {
        clientes.stream()
                .filter(c -> c.getFechaMuerte() == null)
                .forEach(c -> c.setFechaMuerte(Cliente.deadDateGen()));
        return ResponseEntity.ok(clientes);
    }
}

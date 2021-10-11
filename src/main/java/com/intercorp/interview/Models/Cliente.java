package com.intercorp.interview.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Cliente {
    private String nombre;
    private String apellido;
    private int edad;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNac;
    @ApiModelProperty(hidden = true)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaMuerte;

    public Cliente(String nombre, String apellido, int edad, LocalDate fechaNac)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNac = fechaNac;
    }

    public static LocalDate deadDateGen()
    {
        int daysIn30Years = 365 * 30;
        int daysRemaining = (int)(Math.random() * daysIn30Years);
        return LocalDate.now().plusDays(daysRemaining);
    }
}

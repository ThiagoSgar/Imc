package br.com.imc.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor

public class Imc {

    private double weight;
    private double height;

    public Imc(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }


}

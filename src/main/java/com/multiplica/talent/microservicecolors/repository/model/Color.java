package com.multiplica.talent.microservicecolors.repository.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name = "colors" )
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "field name cant be empty")
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "year")
    private int year;

    @NotBlank(message = "field color cant be empty")
    @Column(name = "color")
    private String color;

    @NotBlank(message = "field pantone_value cant be empty")
    @Column(name = "pantone_value")
    private String pantoneValue;
}

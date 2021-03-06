package com.rabba007whizz.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")

public class PetType extends BaseEntity {

    private String name;

    @Override
    public String toString() {
        return this.getName();
    }
}

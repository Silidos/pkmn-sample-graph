package org.example.pkmn.model;

import lombok.Data;

@Data
public class Pokemon {

    private String ability;
    private String abilityDescription;
    private Integer attack;
    private Integer defense;
    private String description;
    private Integer hp;
    private String name;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;
    private String type;
    private String weaknesses;
}

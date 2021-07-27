package org.example.pkmn.resolver;


import org.example.pkmn.model.AbilityDetails;
import org.example.pkmn.model.Pokemon;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class PokemonResolver implements GraphQLResolver<Pokemon> {

    public AbilityDetails getAbilityDetails(Pokemon pokemon) {
        AbilityDetails abilityDetails = new AbilityDetails();
        abilityDetails.setName(pokemon.getAbility());
        abilityDetails.setDescription(pokemon.getAbilityDescription());
        return abilityDetails;
    }
}

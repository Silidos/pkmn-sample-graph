package org.example.pkmn.query;


import org.example.pkmn.model.Pokemon;
import org.example.pkmn.service.PkmnService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PkmnQueryResolver implements GraphQLQueryResolver {

    @Autowired
    PkmnService pkmnService;

    public Connection<Pokemon> getPokemon(int first, String after, DataFetchingEnvironment env) {
        return new SimpleListConnection<>(new ArrayList<>(pkmnService.getPokemon())).get(env);
    }

    public Connection<Pokemon> searchPokemon(String searchFor, int first, String after, DataFetchingEnvironment env) {
        return new SimpleListConnection<>(new ArrayList<>(pkmnService.searchPokemon(searchFor))).get(env);
    }


}

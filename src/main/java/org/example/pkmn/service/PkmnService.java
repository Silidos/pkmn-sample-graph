package org.example.pkmn.service;


import org.example.pkmn.constants.RestAPIConstants;
import org.example.pkmn.model.Pokemon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class PkmnService {


    @Value("${pokemondapi.uri}")
    private String pkmnServiceUri;

    @Autowired
    @Qualifier("pkmnDapiRestTemplate")
    private RestTemplate pkmnDapiRestTemplate;

    @Autowired
    private HttpServletRequest request;

    public Collection<Pokemon> getPokemon() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ParameterizedTypeReference<List<Pokemon>> pokemonTypeRef = new ParameterizedTypeReference<List<Pokemon>>() {};
        UriComponents url = UriComponentsBuilder.fromUriString(pkmnServiceUri + RestAPIConstants.POKEMON_SERVICE)
                .build();

            Pokemon[] pokemon = pkmnDapiRestTemplate.getForObject(url.toString(), Pokemon[].class);
            return List.of(pokemon);

    }

    public Collection<Pokemon> searchPokemon(String searchFor) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ParameterizedTypeReference<Pokemon> pokemonTypeRef = new ParameterizedTypeReference<Pokemon>() {};
        UriComponents url = UriComponentsBuilder.fromUriString(pkmnServiceUri + RestAPIConstants.POKEMON_SEARCH_SERVICE + searchFor)
                .build();

        Pokemon pokemon = pkmnDapiRestTemplate.getForObject(url.toString(), Pokemon.class);
        return List.of(pokemon);
    }
 }

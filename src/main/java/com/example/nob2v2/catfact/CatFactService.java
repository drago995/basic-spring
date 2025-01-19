package com.example.nob2v2.catfact;

import com.example.nob2v2.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class CatFactService implements Query<Integer, CatFactDTO> {
    private final String url = "https://catfact.ninja/fact";
    private final RestTemplate restTemplate;
    private final String MAX_LENGTH = "max length";
    public CatFactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<CatFactDTO> execute(Integer input) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam(MAX_LENGTH, input)
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");


        HttpEntity<String> entity = new HttpEntity<>(headers);
        // handle error
        try {
            ResponseEntity<CatFactResponse> response = restTemplate
                    .exchange(uri, HttpMethod.GET, entity, CatFactResponse.class);

            CatFactDTO catFactDTO = new CatFactDTO(response.getBody().getFact());
            return ResponseEntity.ok(catFactDTO);

        }
        catch(Exception e){
            throw new RuntimeException("Cat Facts API is down");

        }

    }
}

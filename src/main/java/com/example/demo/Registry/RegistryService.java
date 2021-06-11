package com.example.demo.Registry;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RegistryService {

  private final WebClient webclient;

  public RegistryService(WebClient.Builder webClientBuilder) {
    this.webclient = webClientBuilder.build();
  }

  public RegistryPackage get(String name) {
    return this.webclient
        .get()
        .uri("https://registry.npmjs.org", uriBuilder -> uriBuilder.path("/{name}").build(name))
        .retrieve()
        .bodyToMono(RegistryPackage.class)
        .block();
  }
}

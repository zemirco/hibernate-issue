package com.example.demo.Registry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RegistryPackage(
    String name,
    String description,
    String homepage,
    Map<String, RegistryPackage> versions,
    Set<RegistryMaintainer> maintainers,
    Set<String> keywords,
    String readme) {}

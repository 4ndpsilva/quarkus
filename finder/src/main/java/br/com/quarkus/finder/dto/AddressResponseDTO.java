package br.com.quarkus.finder.dto;

public record AddressResponseDTO(
    String zipCode,
    String street,
    String complement,
    String district,
    String city,
    String state,
    String ddd) {}
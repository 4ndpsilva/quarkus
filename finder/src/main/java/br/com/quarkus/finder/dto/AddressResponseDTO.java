package br.com.quarkus.finder.dto;

import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"zipCode", "street", "district", "complement",
    "district", "city", "state", "ddd"})
public record AddressResponseDTO(
    String zipCode,
    String street,
    String complement,
    String district,
    String city,
    String state,
    String ddd) {}
package org.rtu.jtarasova_191rdb176.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User(String gender, String name, Integer id, String email, String status) {
}

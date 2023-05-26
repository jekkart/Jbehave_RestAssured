package org.rtu.jtarasova_191rdb176.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ErrorItem(String field, String message) {
}

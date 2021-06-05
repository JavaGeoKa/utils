package com.geo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImgurResponseDto {

    @Getter
    ObjectDataDto data;
    boolean success;
    Integer status;

    public ObjectDataDto getData() {
        return this.data;
    }
}
package com.rest.davetlimsiniz.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AbstractDTO implements GenericDTO {

    private Long id;
    private LocalDateTime createAt = LocalDateTime.now();

}

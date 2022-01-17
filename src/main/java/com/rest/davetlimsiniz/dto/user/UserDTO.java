package com.rest.davetlimsiniz.dto.user;

import com.rest.davetlimsiniz.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends AbstractDTO {
    private String email;
}

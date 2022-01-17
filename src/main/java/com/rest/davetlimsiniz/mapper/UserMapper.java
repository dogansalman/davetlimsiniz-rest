package com.rest.davetlimsiniz.mapper;

import com.rest.davetlimsiniz.dto.user.UserDTO;
import com.rest.davetlimsiniz.entity.user.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDTO> {

    @Override
    UserDTO clone(User entity);

    @Override
    List<UserDTO> toDtos(List<User> entities);

    @Override
    User toEntity(UserDTO dto);
}

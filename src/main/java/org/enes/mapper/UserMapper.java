package org.enes.mapper;

import org.enes.dto.request.RegisterRequestDto;
import org.enes.dto.response.LoginResponseDto;
import org.enes.dto.response.RegisterResponseDto;
import org.enes.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    LoginResponseDto fromUserToLoginResponseDto(final User user);

    User fromRegisterRequestDtoToUser(final RegisterRequestDto dto);

    RegisterResponseDto fromUserDtoToRegisterResponse(final User user);

    List<RegisterResponseDto> fromUserListToRegisterResponseDtoList(List<User> userList);
}

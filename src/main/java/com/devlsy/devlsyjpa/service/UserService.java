package com.devlsy.devlsyjpa.service;

import com.devlsy.devlsyjpa.domain.UserDto;
import com.devlsy.devlsyjpa.domain.UserEntity;
import com.devlsy.devlsyjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;


    /**
     *  create member by userId
     */
    @Transactional
    public Long createMember(UserDto userDto) {
        UserEntity userEntity = UserEntity.convertFromDto(userDto);
        return userRepository.save(userEntity).getUserId();
    }

    /**
     *  delete member by userId
     */
    @Transactional
    public void deleteMember(Long userId) {
        userRepository.deleteByUserId(userId);
    }

    /**
     * findOne member by userId
     */
    @Transactional(readOnly = true)
    public HashMap<String, Object> findOneMember(Long userId) {
        HashMap<String, Object> resultMap = new HashMap<>();

        UserEntity findUser = userRepository.findByUserId(userId);
        resultMap.put("result", UserDto.convertFromEntity(findUser));
        return resultMap;
    }

    /**
     *  findAll member by userId
     */
    @Transactional(readOnly = true)
    public HashMap<String, Object> findAllMember() {
        HashMap<String, Object> resultMap = new HashMap<>();
        List<UserDto> userDtoList = new ArrayList<>();

        List<UserEntity> userEntityList = userRepository.findAll();

        for (UserEntity userEntity : userEntityList) {
            UserDto.convertFromEntity(userEntity);
            userDtoList.add(UserDto.convertFromEntity(userEntity));
        }
        resultMap.put("result", userDtoList);
        return resultMap;
    }

}

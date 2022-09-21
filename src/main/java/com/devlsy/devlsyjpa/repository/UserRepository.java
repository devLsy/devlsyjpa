package com.devlsy.devlsyjpa.repository;

import com.devlsy.devlsyjpa.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     *  delete member by userId
     */
    public void deleteByUserId(Long userId);

    /**
     *  findOne member by userId
     */
    public UserEntity findByUserId(Long userId);
}

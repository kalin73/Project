package com.softuni.registerform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softuni.registerform.domain.entity.VideoEntity;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

}

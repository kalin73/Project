package com.softuni.registerform.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "videos")
public class VideoEntity {
	@Id
	private Long id;

	private String name;

	private String path;

	private String contentType;

	private String language;

	public VideoEntity() {

	}

	public Long getId() {
		return id;
	}

	public VideoEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public VideoEntity setName(String name) {
		this.name = name;
		return this;
	}

	public String getPath() {
		return path;
	}

	public VideoEntity setPath(String path) {
		this.path = path;
		return this;
	}

	public String getContentType() {
		return contentType;
	}

	public VideoEntity setContentType(String contentType) {
		this.contentType = contentType;
		return this;
	}

	public String getLanguage() {
		return language;
	}

	public VideoEntity setLanguage(String language) {
		this.language = language;
		return this;
	}

}

package com.softuni.registerform.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "videos")
public class VideoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TEXT")
	private String path;

	@Column(name = "content_type")
	private String contentType;

	public VideoEntity() {

	}

	public Long getId() {
		return id;
	}

	public VideoEntity setId(Long id) {
		this.id = id;
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

}

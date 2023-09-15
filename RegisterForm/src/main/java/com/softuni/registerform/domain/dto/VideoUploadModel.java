package com.softuni.registerform.domain.dto;

import org.springframework.web.multipart.MultipartFile;

public class VideoUploadModel {
	private MultipartFile video;

	public VideoUploadModel() {

	}

	public void setVideo(MultipartFile video) {
		this.video = video;
	}

	public MultipartFile getVideo() {
		return video;
	}
}

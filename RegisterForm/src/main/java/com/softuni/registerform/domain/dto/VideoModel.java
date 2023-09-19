package com.softuni.registerform.domain.dto;

import com.softuni.registerform.domain.entity.VideoEntity;

public class VideoModel {
	private String name;
	private String path;

	public VideoModel() {

	}

	public VideoModel(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static VideoModel mapToVideoModel(VideoEntity videoEntity) {
		return new VideoModel(videoEntity.getName(), videoEntity.getPath());
	}
}

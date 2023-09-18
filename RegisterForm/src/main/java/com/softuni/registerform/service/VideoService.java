package com.softuni.registerform.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.softuni.registerform.domain.dto.VideoUploadModel;
import com.softuni.registerform.domain.entity.VideoEntity;
import com.softuni.registerform.repository.VideoRepository;

@Service
public class VideoService {
	private final VideoRepository videoRepository;
	private static final String DIRECTORY = "C:/Users/Kalin/Desktop/";

	public VideoService(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	public Long saveVideo(VideoUploadModel videoModel) throws FileNotFoundException, IOException {
		VideoEntity video = new VideoEntity();

		File file = new File(DIRECTORY + videoModel.getVideo().getOriginalFilename());

		try (OutputStream os = new FileOutputStream(file)) {
			os.write(videoModel.getVideo().getBytes());
		}

		final String filePath = file.getPath();

		video.setContentType(videoModel.getVideo().getContentType()).setPath(filePath);

		return videoRepository.save(video).getId();
	}

	public String getVideoPathById(Long id) {
		VideoEntity video = this.videoRepository.findById(id).orElse(null);
		
		return video.getPath();
	}
}

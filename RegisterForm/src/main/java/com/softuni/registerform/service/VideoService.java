package com.softuni.registerform.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.softuni.registerform.domain.dto.VideoModel;
import com.softuni.registerform.domain.dto.VideoUploadModel;
import com.softuni.registerform.domain.entity.VideoEntity;
import com.softuni.registerform.repository.VideoRepository;

@Service
public class VideoService {
	private final VideoRepository videoRepository;
	private static final String DIRECTORY = "src\\main\\resources\\static\\images\\";
	private static final String PATH = "/images/";

	public VideoService(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	public Long saveVideo(VideoUploadModel videoModel) throws FileNotFoundException, IOException {
		VideoEntity video = new VideoEntity();

		File file = new File(DIRECTORY + videoModel.getVideo().getOriginalFilename());

		try (OutputStream os = new FileOutputStream(file)) {
			os.write(videoModel.getVideo().getBytes());
		}

		final String filePath = PATH + videoModel.getVideo().getOriginalFilename().replace("\\", "/");

		video.setContentType(videoModel.getVideo().getContentType())
			.setName(videoModel.getVideo().getOriginalFilename())
			.setPath(filePath);

		return videoRepository.save(video).getId();
	}

	public List<VideoModel> getAllVideos() {
		List<VideoModel> videos = this.videoRepository.findAll()
				.stream().map(VideoModel::mapToVideoModel)
				.collect(Collectors.toList());
		
		return videos;
	}

	public VideoModel getVideoPathById(Long id) {
		VideoEntity video = this.videoRepository.findById(id).orElse(null);

		return VideoModel.mapToVideoModel(video);
	}
}

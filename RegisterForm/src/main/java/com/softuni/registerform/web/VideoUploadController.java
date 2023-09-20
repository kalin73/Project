package com.softuni.registerform.web;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softuni.registerform.domain.dto.VideoUploadModel;
import static com.softuni.registerform.domain.enums.Languages.*;
import com.softuni.registerform.service.VideoService;

@Controller
@RequestMapping("/upload")
public class VideoUploadController {
	private final VideoService videoService;

	public VideoUploadController(VideoService videoService) {
		this.videoService = videoService;
	}

	@PostMapping("/java")
	public String uploadJavaVideo(VideoUploadModel video) throws FileNotFoundException, IOException {
		videoService.saveVideo(video, Java);

		return "redirect:/java";
	}

	@PostMapping("/html")
	public String uploadHtmlVideo(VideoUploadModel video) throws FileNotFoundException, IOException {
		videoService.saveVideo(video, HTML);

		return "redirect:/html";
	}

	@PostMapping("/js")
	public String uploadJavaScriptVideo(VideoUploadModel video) throws FileNotFoundException, IOException {
		videoService.saveVideo(video, JavaScript);

		return "redirect:/js";
	}

	@PostMapping("/css")
	public String uploadCssVideo(VideoUploadModel video) throws FileNotFoundException, IOException {
		videoService.saveVideo(video, CSS);

		return "redirect:/css";
	}
}

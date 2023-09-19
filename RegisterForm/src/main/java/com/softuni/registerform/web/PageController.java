package com.softuni.registerform.web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softuni.registerform.domain.dto.VideoModel;
import com.softuni.registerform.domain.dto.VideoUploadModel;
import com.softuni.registerform.service.VideoService;

@Controller
public class PageController {
	private final VideoService videoService;

	public PageController(VideoService videoService) {
		this.videoService = videoService;
	}

	@GetMapping("/java")
	public ModelAndView getJavaPage(ModelAndView modelAndView) {
		List<VideoModel> videos = this.videoService.getAllVideos();
		modelAndView.addObject("videos", videos);
		modelAndView.setViewName("Java");

		return modelAndView;
	}

	@PostMapping("/java/upload")
	public String uploadVideo(VideoUploadModel video) throws FileNotFoundException, IOException {
		videoService.saveVideo(video);

		return "redirect:/java";
	}

	@GetMapping("/java/video/{id}")
	public ModelAndView showVideo(@PathVariable(name = "id") Long id, ModelAndView modelAndView) {
		VideoModel video = this.videoService.getVideoPathById(id);

		modelAndView.addObject("video", video);
		modelAndView.setViewName("Video");

		return modelAndView;
	}
}

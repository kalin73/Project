package com.softuni.registerform.web;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softuni.registerform.domain.dto.VideoUploadModel;
import com.softuni.registerform.domain.entity.VideoEntity;
import com.softuni.registerform.service.VideoService;

@Controller
public class PageController {
	private final VideoService videoService;

	public PageController(VideoService videoService) {
		this.videoService = videoService;
	}

	@GetMapping("/java")
	public String getJavaPage() {
		return "Java";
	}

	@PostMapping("/java/upload")
	public String uploadVideo(VideoUploadModel video) throws FileNotFoundException, IOException {
		Long id = videoService.saveVideo(video);

		return "redirect:/java/video/" + id;
	}

	@GetMapping("/java/video/{id}")
	public ModelAndView showVideo(@PathVariable(name = "id") Long id, ModelAndView modelAndView) {
		VideoEntity video = this.videoService.getVideoPathById(id);
		
		modelAndView.addObject("video", video);
		modelAndView.setViewName("Video");

		return modelAndView;
	}
}

package com.softuni.registerform.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.softuni.registerform.domain.dto.VideoModel;
import com.softuni.registerform.domain.enums.Languages;

import static com.softuni.registerform.domain.enums.Languages.*;
import com.softuni.registerform.service.VideoService;

@Controller
public class PageController {
	private final VideoService videoService;

	public PageController(VideoService videoService) {
		this.videoService = videoService;
	}

	@GetMapping("/java")
	public ModelAndView getJavaPage(ModelAndView modelAndView) {
		getPage(modelAndView, Java);

		return modelAndView;
	}

	@GetMapping("/html")
	public ModelAndView getHtmlPage(ModelAndView modelAndView) {
		getPage(modelAndView, HTML);

		return modelAndView;
	}

	@GetMapping("/js")
	public ModelAndView getJavaScriptPage(ModelAndView modelAndView) {
		getPage(modelAndView, JavaScript);

		return modelAndView;
	}

	@GetMapping("/css")
	public ModelAndView getCssPage(ModelAndView modelAndView) {
		getPage(modelAndView, CSS);

		return modelAndView;
	}

	@GetMapping("/video/{id}")
	public ModelAndView showVideo(@PathVariable(name = "id") Long id, ModelAndView modelAndView) {
		VideoModel video = this.videoService.getVideoPathById(id);

		modelAndView.addObject("video", video);
		modelAndView.setViewName("Video");

		return modelAndView;
	}

	private final void getPage(ModelAndView modelAndView, Languages language) {
		List<VideoModel> videos = this.videoService.getAllVideosByLanguage(language);
		modelAndView.addObject("videos", videos);
		modelAndView.addObject("language", language.name().toLowerCase());
		modelAndView.setViewName(language.name());
	}
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.IndexEntity;
import com.example.demo.repository.IndexRepository;
//import com.example.demo.service.IndexService;
import com.example.demo.service.IndexServiceImpl;

@Controller
public class IndexController {
	
	private final IndexServiceImpl indexservice;
	
	public IndexController(IndexServiceImpl indexService) {
		this.indexservice = indexService;
	}
	
	@Autowired
	private IndexRepository indexRepository;
	
	@GetMapping("/")
	public String getAllIndex(@ModelAttribute IndexEntity indexEntity, Model model) {
		model.addAttribute("dogs",indexservice.findAll());
		return "index";		
	}
}

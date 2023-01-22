package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.IndexEntity;
import com.example.demo.repository.IndexRepository;

@Service
public class IndexServiceImpl implements IndexService {
	
	private final IndexRepository indexRepository;

	public IndexServiceImpl(IndexRepository indexRepository) {
		this.indexRepository = indexRepository;
	}
	
	@Override
	public List<IndexEntity> findAll() {
		return indexRepository.findAll();
	}
}

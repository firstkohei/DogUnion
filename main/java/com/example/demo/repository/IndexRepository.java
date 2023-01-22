package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.IndexEntity;

public interface IndexRepository {
	
	List<IndexEntity> findAll();
}

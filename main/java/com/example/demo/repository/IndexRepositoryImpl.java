package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IndexEntity;

@Repository
public class IndexRepositoryImpl implements IndexRepository{
	
	private final JdbcTemplate jdbcTemplate;

	public IndexRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<IndexEntity> findAll() {

		String sql = "SELECT id, name, gender "
				+ " FROM dogs ";

		//タスク一覧をMapのListで取得
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

		//return用の空のListを用意
		List<IndexEntity> list = new ArrayList<>();

		//二つのテーブルのデータをTaskにまとめる
		for(Map<String, Object> result : resultList) {

			IndexEntity indexEntity = new IndexEntity();
			indexEntity.setId((int)result.get("id"));
			indexEntity.setName((String)result.get("name"));
			indexEntity.setGender((String)result.get("gender"));

			list.add(indexEntity);
		}
		return list;
	}
}

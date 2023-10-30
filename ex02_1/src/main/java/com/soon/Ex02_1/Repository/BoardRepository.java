package com.soon.Ex02_1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soon.Ex02_1.Entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	

}

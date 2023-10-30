package com.soon.Ex02.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soon.Ex02.Entity.Board;

@Repository // 이 이노테이션은 안써도 상관없음 ( 이유 - JpaRepository 를 상속받고 있기때문)
//JpaRepository가 가지고 있는 메서드를 사용해서 DB를 제어할 수 있음
public interface BoardRepository extends JpaRepository<Board, Integer> {
										 // JpaRepository<대상이 되는 엔티티명, 해당 엔티티의 식별자(프라이머리키) 의 데이터타입>
	
}

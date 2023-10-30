package com.soon.Ex02;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Data가 Null인 경우 에러를 처리하기 위한 클래스
// RuntimeException을 상속받고 
// 아래 어노테이션을 통해 404 에러를 처리
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataIsNull extends RuntimeException{
	// 아래 코드는 이해할 필요는 없고 그냥 이렇게 있다 라고 생각
   private static final long serialVersionUID = 1L;
   
   public DataIsNull(String message) {
      super(message); }
   
}
package org.joonzis.controller;

import org.joonzis.domain.BoardLikeVO;
import org.joonzis.service.BoardLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/like")
public class BoardLikeController {

    @Autowired
    private BoardLikeService service;

    // 좋아요 추가/삭제 기능 
    @PostMapping("/get")
    public ResponseEntity<String> toggleLike(@RequestBody BoardLikeVO vo) {
        log.info("getLike... " + vo);
        
        boolean isLiked = service.isLiked(vo.getBoardno(), vo.getMno());
        
        if (isLiked) {
        	service.deleteLike(vo);
            return new ResponseEntity<>("Like removed", HttpStatus.OK);
        } else {
        	service.insertLike(vo);
            return new ResponseEntity<>("Like added", HttpStatus.OK);
        }
    }

    // 좋아요 개수 가져오기
    @GetMapping("/count/{boardno}")
    public ResponseEntity<Integer> countLikes(@PathVariable int boardno) {
        log.info("countLikes... " + boardno);
        int count = service.countLikes(boardno);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
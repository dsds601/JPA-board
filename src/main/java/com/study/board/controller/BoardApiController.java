package com.study.board.controller;

import com.study.board.entity.BoardRequestDto;
import com.study.board.entity.BoardResponseDto;
import com.study.board.model.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public Long save(@RequestBody final BoardRequestDto params){
        return boardService.save(params);
    }

    @GetMapping("/boards")
    public List<BoardResponseDto> findAll(){
        return boardService.findAll();
    }

    @PutMapping("/boards/{id}")
    public Long save(@PathVariable final Long id,@RequestBody final BoardRequestDto params){
        return boardService.update(id,params);
    }

    @DeleteMapping("/boards/{id}")
    public Long delete(@PathVariable final Long id){
        return boardService.delete(id);
    }

    @GetMapping("/boards/{id}")
    public BoardResponseDto findById(@PathVariable final Long id){
        return boardService.findById(id);
    }


}

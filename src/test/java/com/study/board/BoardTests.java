package com.study.board;

import com.study.board.entity.Board;
import com.study.board.entity.BoardJpaRepository;
import com.study.board.entity.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class BoardTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save(){
        Board params = Board.builder()
                .title("1번 게시글 제목")
                .content("1번 게시글 내용")
                .writer("도뎡이")
                .hits(0)
                .deleteYn('N')
                .build();

        boardRepository.save(params);
    }

    @Test
    void findOne(){
        Board board = boardRepository.findById((long) 2).get();
        assertThat(board.getTitle()).isEqualTo("1번 게시글 제목");
    }

    @Test
    void findAll(){
        List<Board> boards = boardRepository.findAll();
        assertThat(boards.get(0).getTitle()).isEqualTo("1번 게시글 제목");
    }

    @Test
    void delete(){
        Board board = boardRepository.findById(2L).get();
        boardRepository.delete(board);
    }
}

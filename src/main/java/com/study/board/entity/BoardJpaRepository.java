package com.study.board.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BoardJpaRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Board board){
        em.persist(board);
    }

    public Board findOne(Long id){
        return em.find(Board.class,id);
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board b",Board.class)
                .getResultList();
    }

}

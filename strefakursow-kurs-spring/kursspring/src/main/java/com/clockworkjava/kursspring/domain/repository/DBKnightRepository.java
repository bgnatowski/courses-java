package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.Quest;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
        em.persist(knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return  em.createQuery("select k from Knight k", Knight.class).getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Knight knightByName = em.createQuery("select k from Knight k where k.name=:name", Knight.class)
                .setParameter("name", name).getSingleResult();

        return Optional.ofNullable(knightByName);
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        Knight knight = em.find(Knight.class, id);
        em.remove(knight);
    }

    @Override
    public void build() {

    }

    @Override
    @Transactional
    public void createKnight(Knight knight) {
        em.persist(knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return em.find(Knight.class, id);
    }


    @Override
    @Transactional
    public void updateKnight(int id, Knight knight) {
        em.merge(knight);
    }


}

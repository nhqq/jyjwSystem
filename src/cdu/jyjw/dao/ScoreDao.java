package cdu.jyjw.dao;

import cdu.jyjw.entity.Score;

import java.sql.Connection;

public interface ScoreDao {


    /**
     * 修改成绩
     * @param conn
     * @param score
     * @return
     */
    boolean ModScore(Connection conn,Score score);
}

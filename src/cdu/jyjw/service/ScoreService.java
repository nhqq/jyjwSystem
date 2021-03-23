package cdu.jyjw.service;

import cdu.jyjw.entity.Score;

import java.sql.Connection;

public interface ScoreService {
    /**
     * 修改成绩
     * @param score
     * @return
     */
    boolean ModScore(Score score);
}

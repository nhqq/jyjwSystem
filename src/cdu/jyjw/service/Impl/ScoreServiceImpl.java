package cdu.jyjw.service.Impl;

import cdu.jyjw.dao.BaseDao;
import cdu.jyjw.dao.CourseDao;
import cdu.jyjw.dao.Impl.CourseDaoImpl;
import cdu.jyjw.dao.Impl.ScoreDaoImpl;
import cdu.jyjw.dao.ScoreDao;
import cdu.jyjw.entity.Score;
import cdu.jyjw.service.ScoreService;

import java.sql.Connection;

public class ScoreServiceImpl implements ScoreService {
    private ScoreDao scoreDao;
    public ScoreServiceImpl() {
        this.scoreDao = new ScoreDaoImpl();
    }

    /**
     * 修改成绩
     * @param score
     * @return
     */
    @Override
    public boolean ModScore(Score score) {
        Connection conn=null;
        boolean flag = false;
        try {
            conn=BaseDao.getConnection();
            flag = scoreDao.ModScore(conn, score);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(conn,null,null);
        }
        return flag;
    }
}

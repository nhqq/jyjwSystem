package cdu.jyjw.dao.Impl;

import cdu.jyjw.dao.BaseDao;
import cdu.jyjw.dao.ScoreDao;
import cdu.jyjw.entity.Score;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class ScoreDaoImpl implements ScoreDao {

    /**
     * 修改成绩
     *
     * @param conn
     * @param score
     * @return
     */
    @Override
    public boolean ModScore(Connection conn, Score score) {
        boolean flag = false;
        PreparedStatement ps = null;
        if (conn!=null){
            Object[] param = {score.getScore(),score.getcId(),score.getsId()};
            String sql = "UPDATE score SET score = ? WHERE c_id = ? AND s_id = ?";
            try {
                int i = BaseDao.execute(conn, ps, sql, param);
                if (i>0){
                    flag=true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                BaseDao.closeResource(null,ps,null);
            }
        }
        return flag;
    }
}

package cdu.jyjw.dao.Impl;

import cdu.jyjw.dao.BaseDao;
import cdu.jyjw.dao.SecourseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SecourseDaoImpl implements SecourseDao {
    /**
     * 通过学生id获取课程id的集合
     * @param conn
     * @param sId
     * @return
     */
    @Override
    public int getCIdBySId(Connection conn,int sId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cId = 0;
        if (conn!=null) {
            try {
                Object[] param = {sId};
                String sql = "SELECT c_id FROM secourse WHERE s_id = ?";
                conn = BaseDao.getConnection();
                rs = BaseDao.execute(conn, ps, rs, sql, param);
                while (rs.next()) {
                    cId = rs.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cId;
    }


}

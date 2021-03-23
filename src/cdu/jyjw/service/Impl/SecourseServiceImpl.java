package cdu.jyjw.service.Impl;

import cdu.jyjw.dao.BaseDao;
import cdu.jyjw.dao.Impl.SecourseDaoImpl;
import cdu.jyjw.dao.SecourseDao;
import cdu.jyjw.service.SecourseService;

import java.sql.Connection;

public class SecourseServiceImpl implements SecourseService {
    private SecourseDao secourseDao;

    public SecourseServiceImpl() {
        secourseDao=new SecourseDaoImpl();
    }

    @Override
    public int getCIdBySId(int sId) {
        Connection connection = null;
        int  cId = 0;
        try {
            connection= BaseDao.getConnection();
            cId=secourseDao.getCIdBySId(connection,sId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return cId;
    }

    @Override
    public int getSIdByCId(int cId) {
        Connection connection = null;
        int  sId = 0;
        try {
            connection= BaseDao.getConnection();
            sId=secourseDao.getCIdBySId(connection,cId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return sId;
    }
}

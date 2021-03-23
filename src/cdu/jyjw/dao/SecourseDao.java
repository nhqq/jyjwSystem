package cdu.jyjw.dao;

import java.sql.Connection;

public interface SecourseDao {
    int getCIdBySId(Connection conn, int sId);
}

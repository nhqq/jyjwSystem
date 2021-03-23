package cdu.jyjw.service;

import java.sql.Connection;

public interface SecourseService {
    int getCIdBySId(int sId);

    int getSIdByCId(int cId);
}

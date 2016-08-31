package com.dragon.warIII.service.teacher.dao;

import com.dragon.warIII.service.teacher.entity.Teacher;

public interface TeacherDAO {

	Teacher findByNo(String tNo);
}

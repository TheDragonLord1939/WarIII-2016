package com.dragon.warIII.core.springJdbc;

public class OracleDialect implements Dialect {
	@Override
    public String getPaginationSql(String sql, int offset, int pageSize) {
      /* return "select * from (select rownum rn, t.* from (" + sql
              + ") t where rownum <= " + offset*pageSize
              + ") t1 where t1.rn > " +(offset-1)*pageSize ;*/
		return "select * from (select rownum rn, t.* from (" + sql
	              + ") t "
	              + ") t1 where t1.rn > " +(offset-1)*pageSize +" and t1.rn <= " +offset*pageSize;
    }
}
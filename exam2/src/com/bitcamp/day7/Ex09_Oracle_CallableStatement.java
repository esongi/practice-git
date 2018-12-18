package com.bitcamp.day7;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;

/*
 * create or replace procedure usp_emplist ( p_sal IN number, p_cursor OUT SYS_REFCURSOR -- app 에서
 * 값을 사용하기 위해서(Multi row) ) is BEGIN OPEN p_cursor FOR select empno ,ename , sal from emp where sal
 * > p_sal;
 * 
 * END;
 */
public class Ex09_Oracle_CallableStatement {

  public static void main(String[] args) {
    Connection conn = null;
    ResultSet rs = null;

    CallableStatement cstmt = null; // oracle procedure 사용시

    try {
      Class.forName("oracle.jdbc.OracleDriver");
      // db 연결
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "park", "1004");

      // input, output 파라미터 2개
      // usp_emplist(?,?) : 프로시저에 따라 이 구문만 바뀌면 됨
      // 셀렉트한 메모리 주소값(아웃풋)
      String sql = "{call usp_emplist(?,?)}";
      cstmt = conn.prepareCall(sql);

      // 커서라는 타입??
      // 두번째 파라미터(메모리 주소값)
      // 물음표의 위치값, 타입
      cstmt.setInt(1, 1000);
      cstmt.registerOutParameter(2, OracleTypes.CURSOR);

      boolean result = cstmt.execute();

      // 주소정보 얻어오기
      rs = (ResultSet) cstmt.getObject(2);

      while (rs.next()) {
        System.out.println(rs.getInt(1) + "/" + rs.getString(2) + "/" + rs.getInt(3));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (Exception e) {
        }
      if (cstmt != null)
        try {
          cstmt.close();
        } catch (Exception e) {
        }
      if (conn != null)
        try {
          conn.close();
        } catch (Exception e) {
        }
    }
  }

}



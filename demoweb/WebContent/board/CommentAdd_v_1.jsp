<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.demoweb.model.dao.BoardCommentDao"%>
<%@page import="com.demoweb.model.dto.BoardComment"%>
<%@ page import ="java.util.List" %>
<%@ page import="net.sf.json.JSONArray" %>

<%
	//String comment = request.getParameter("comment");
	int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	//System.out.println(bbsSeq + " / " + comment);
	
	BoardCommentDao commentDao = new BoardCommentDao();
	BoardComment boardComment = new BoardComment();
	
	//덧글등록
	commentDao.addComment(boardComment);
	List<BoardComment> commentlist = commentDao.getCommentList(boardNo);
	
	//JSON 데이터
	JSONArray jsonarray = JSONArray.fromObject(commentlist);
%>
<%=jsonarray %>












package com.it.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.it.util.DBConnector;

public class BoardDAO {
	
	private DBConnector dbConnector;
	
	public BoardDAO() {
		dbConnector = new DBConnector();
	}
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		Connection con = dbConnector.getConnect();
		
		String sql = "insert into board values(?,?,?,?,sysdate,0)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, boardDTO.getNum());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getWriter());
		st.setString(4, boardDTO.getContents());
		
		int num = st.executeUpdate();
		
		st.close();
		con.close();
		
		return num;
	}
	
	public ArrayList<BoardDTO> boardList() throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<>();
		Connection con = dbConnector.getConnect();
		
		String sql = "select * from board order by num desc";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			
			boardDTO.setNum(rs.getLong("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setRegdate(rs.getDate("regdate"));
			boardDTO.setHit(rs.getLong("hit"));
			
			ar.add(boardDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}

}

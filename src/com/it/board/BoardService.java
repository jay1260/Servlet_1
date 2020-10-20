package com.it.board;

import java.util.ArrayList;

public class BoardService {
	
	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	// 전체 목록
	public ArrayList<BoardDTO> boardList(BoardDTO boardDTO) throws Exception {
		
		ArrayList<BoardDTO> ar = boardDAO.boardList();
		
		return ar;
	}
	
	// 데이터 넣기
	public void boardWrite(BoardDTO boardDTO) throws Exception {
		
		int result = boardDAO.boardWrite(boardDTO);
		System.out.println(result+"-----1 이상이면 성공");
		
	}

}

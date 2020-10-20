package com.it.gb1;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.board.BoardDTO;
import com.it.board.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService;
    private BoardDTO boardDTO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        boardService = new BoardService();
        boardDTO = new BoardDTO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String path = request.getRequestURI();
		path = path.substring(path.lastIndexOf("/"));
		String info = "";
		
		if(path.equals("/boardList.board")) {
			System.out.println("boardList");
			info="./boardList.jsp";
			ArrayList<BoardDTO> ar = null;
			try {
				ar = boardService.boardList(boardDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("list", ar);
		}else if(path.equals("/boardWrite.board")) {
			System.out.println("boardWrite");
			info="./boardWrite.jsp";
		}else if(path.equals("/boardWriteProcess.board")) {
			System.out.println("boardProcess");
			info="./boardWrite.jsp";
			
			boardDTO.setNum(Long.parseLong(request.getParameter("num")));
			boardDTO.setTitle(request.getParameter("title"));
			boardDTO.setWriter(request.getParameter("writer"));
			boardDTO.setContents(request.getParameter("contents"));
			
			try {
				boardService.boardWrite(boardDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		RequestDispatcher view = request.getRequestDispatcher(info);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

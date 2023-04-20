package com.jdbc.board.service;

import java.sql.Connection;
import java.util.List;

import com.jdbc.board.model.dao.BoardDao;
import com.jdbc.board.model.dto.BoardDTO;
import static com.jdbc.board.common.JDBCTemplate.*;

public class BoardService {

	private BoardDao dao = new BoardDao();

	public List<BoardDTO> selectBoardAll() {
		Connection conn = getConnection();
		List<BoardDTO> boards = dao.selectBoardAll(conn);
		close(conn);
		return boards;
	}

}
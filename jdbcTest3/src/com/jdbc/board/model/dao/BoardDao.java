package com.jdbc.board.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.jdbc.board.common.JDBCTemplate.close;
import com.jdbc.board.model.dto.BoardDTO;

public class BoardDao {

	private Properties sql = new Properties();

	{
		String path = BoardDao.class.getResource("/sql/board/board_sql.properties").getPath();
		try (FileReader fr = new FileReader(path);) {
			sql.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<BoardDTO> selectBoardAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = this.sql.getProperty("selectBoardAll");
		List<BoardDTO> boards = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boards.add(getBoard(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
	}

	private Board getBoard(ResultSet rs) {
		Board b = new Board();

		return b;
	}

}

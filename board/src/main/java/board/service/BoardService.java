package board.service;

import java.util.List;

import board.dto.BoardDto;

public interface BoardService {
	List<BoardDto> selectBoardList() throws Exception;
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	void insertBoard(BoardDto board) throws Exception;
	void updateBoard(BoardDto board) throws Exception;
	void deleteBoard(int boardIdx) throws Exception;

}

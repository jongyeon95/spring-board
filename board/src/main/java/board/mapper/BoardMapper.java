package board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.dto.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
	void insertBoard(BoardDto board) throws Exception;
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	void updateHitCount(int boardIdx) throws Exception;
}

package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import board.dto.BoardDto;
import board.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="게시판 REST API")
@RestController
public class RestBoardApiController {
	
	@Autowired
	private BoardService boardservice;
	
	@ApiOperation(value ="게시글 목록 조회")
	@RequestMapping(value="/api/board", method=RequestMethod.GET)
	public List<BoardDto> openBoardList() throws Exception{
		return boardservice.selectBoardList();
	}
	
	@ApiOperation(value ="게시글 작성")
	@RequestMapping(value="/api/board/write", method=RequestMethod.POST)
	public void insertBoard(@RequestBody BoardDto board) throws Exception{
		boardservice.insertBoard(board, null);
	}
	
	@ApiOperation(value ="게시글 상세 내용 조회")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.GET)
	public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
		return boardservice.selectBoardDetail(boardIdx);
	}
	
	@ApiOperation(value ="게시글 상세 내용 수정")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.PUT)
	public String updateBoard(@RequestBody BoardDto board) throws Exception{
		boardservice.updateBoard(board);
		return "redirect:/board";
	}
	@ApiOperation(value ="게시글 삭제")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardservice.deleteBoard(boardIdx);
		return "redirect:/board";
	}
	

}

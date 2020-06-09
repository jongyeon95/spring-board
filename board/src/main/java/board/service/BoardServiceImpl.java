package board.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.common.FileUtils;
import board.dto.BoardDto;
import board.dto.BoardFileDto;
import board.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileUtils fileUtils;

	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}

	@Override
	public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardMapper.insertBoard(board);
		List<BoardFileDto> list = fileUtils.parseFileInfo(board.getBoardIdx(),multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list)==false) {
			boardMapper.insertBoardFileList(list);
		}
		if(ObjectUtils.isEmpty(multipartHttpServletRequest)==false) {
			Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
			String name;
			while(iterator.hasNext()) {
				name=iterator.next();
				log.debug("file tag name :" + name);
				List<MultipartFile> flist=multipartHttpServletRequest.getFiles(name);
				for(MultipartFile multipartfile :flist) {
					log.debug("start file information");
					log.debug("file name : "+multipartfile.getOriginalFilename());
					log.debug("file size : "+multipartfile.getSize());
					log.debug("file content type : "+multipartfile.getContentType());
					log.debug("end file information.\n");
				}
				
				
			}
		}
		
	}

	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
	
		
		BoardDto board=boardMapper.selectBoardDetail(boardIdx);
		List<BoardFileDto> fileList = boardMapper.selectBoardFileList(boardIdx);
		board.setFileList(fileList);
		boardMapper.updateHitCount(boardIdx);
		return board;
	}

	@Override
	public void updateBoard(BoardDto board) throws Exception {
		
		boardMapper.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
	}
	
	

}

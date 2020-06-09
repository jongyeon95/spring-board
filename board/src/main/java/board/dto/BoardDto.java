package board.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
@Data
public class BoardDto {
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private LocalDateTime createdDatetime;
	private String updaterId;
	private LocalDateTime updatedDatetime;
	private List<BoardFileDto> fileList;

}

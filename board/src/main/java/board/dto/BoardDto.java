package board.dto;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="BoardDto : 게시글 내용" , description="게시글 내용")
@Data
public class BoardDto {
	@ApiModelProperty(value="게시글 번호")
	private int boardIdx;
	
	@ApiModelProperty(value="게시글 제목")
	private String title;
	
	@ApiModelProperty(value="게시글 내용")
	private String contents;
	
	@ApiModelProperty(value="조회수")
	private int hitCnt;
	
	@ApiModelProperty(value="작성자 아이디")
	private String creatorId;
	
	@ApiModelProperty(value="작성 시간")
	private LocalDateTime createdDatetime;
	
	@ApiModelProperty(value="수정자 아이디")
	private String updaterId;
	
	@ApiModelProperty(value="수정 시간")
	private LocalDateTime updatedDatetime;
	
	@ApiModelProperty(value="첨부파일 목록")
	private List<BoardFileDto> fileList;

}

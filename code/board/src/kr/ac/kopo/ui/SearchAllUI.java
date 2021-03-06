package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.vo.BoardVO;

public class SearchAllUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		List<BoardVO> list = service.전체게시글조회서비스();
		
		System.out.println("----------------------------------------");
		System.out.println("\t전체 게시글 조회");
		System.out.println("----------------------------------------");
		System.out.println("번호\t글쓴이\t등록일\t제목");
		System.out.println("----------------------------------------");
		
		// 게시글 목록 출력
		if(list.size() == 0 || list.isEmpty()) {
			System.out.println("조회할 게시물이 없습니다.");
		} else {
			for(BoardVO vo : list) {
				System.out.println(vo.getNo() + "\t" + vo.getWriter() + "\t"
						   			+ vo.getRegDate() + "\t" + vo.getTitle());
			}
		}
		
		System.out.println("----------------------------------------");
	}

}

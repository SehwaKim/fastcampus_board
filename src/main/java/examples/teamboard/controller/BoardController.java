package examples.teamboard.controller;


import examples.teamboard.common.Pagination;
import examples.teamboard.domain.Board;
import examples.teamboard.service.BoardService;
import examples.teamboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/boards")
public class BoardController {
    @Autowired
    BoardService boardService;
    @Autowired
    CommentService commentService;

//    게시글 리스트
    @GetMapping
    public String boards(@RequestParam(name = "categoryNo", defaultValue = "1") int categoryNo,
                         @RequestParam(name = "page", defaultValue = "1") int page,
                         @RequestParam(name = "searchType", defaultValue = "title") String searchType,
                         @RequestParam(name = "searchStr", defaultValue = "") String searchStr,
                         ModelMap modelMap) {
        //TODO
        // pagination 인스턴스 생성
        int totalCnt = boardService.getTotalCnt(searchType, searchStr);
        Pagination pagination = new Pagination(totalCnt,10, page);
        // 리스트 가져오는 서비스 호출
        List<Board> list = boardService.getBoards(pagination, 1, searchType, searchStr);
        // 리스트를 맵에 전달
        modelMap.addAttribute("list", list);

        return "boards/boards_list";
    }
    
//    게시글 쓰기페이지 이동
    @GetMapping("/writeform")
    public String writeForm() {
        
        return "boards/board_writeform";
    }
    
//    게시글 등록
    @PostMapping
    public String write() {
        
        long boardNo = 0; // 등록한 게시글 번호
        
        return "redirect:/boards/"+boardNo;
    }
    
//    게시글 수정페이지 이동
    @GetMapping("updateform")
    public String updateForm() {
    
        return "boards/board_updateform";
    }

//    게시글 수정
    @PutMapping
    public String update(Board board) {
        
        return "redirect:/boards/"+board.getBoardNo();
    }
    
//     게시글 상세보기
    @GetMapping("/{boardId}")
    public String boardDetail() {
        
        return "boards/board_view";
    }

//    게시글 삭제
    @DeleteMapping
    public String delete() {
        
        return "redirect:/boards";
    }
    
//    댓글 등록
    @PostMapping("/boards/{boardId}/comment")
    public String registComment(@PathVariable(value = "boardId") long boardId) {
    
        return "redirect:/boards/"+boardId;
    }
    
//    댓글 삭제
    @DeleteMapping("/boards/{boardId}/comment")
    public String deleteComment(@PathVariable(value = "boardId") long boardId) {
    
        return "redirect:/boards/"+boardId;
    }

}

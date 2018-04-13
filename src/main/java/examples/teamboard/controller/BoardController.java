package examples.teamboard.controller;


import examples.teamboard.domain.Board;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/boards")
public class BoardController {

//    게시글 리스트
    @GetMapping
    public String boards(){

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

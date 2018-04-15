package examples.teamboard.controller;


import examples.teamboard.common.Pagination;
import examples.teamboard.domain.Board;
import examples.teamboard.domain.Comment;
import examples.teamboard.service.BoardService;
import examples.teamboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/boards")
public class BoardController {
    
    private static final int POST_SIZE = 10;
    
    @Autowired
    private BoardService boardService;
    
    @Autowired
    private CommentService commentService;
    
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
    @GetMapping("/{boardNo}")
    public String boardDetail(@PathVariable("boardNo") long boardNo, @RequestParam(defaultValue = "1") int categoryNo
            , @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "1") int commentPage
            , @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchStr
            , Model model) {
        
        Board board = boardService.getBoard(boardNo);
    
        int totalCount = commentService.totalCount(boardNo);
        Pagination pagination = new Pagination(totalCount, POST_SIZE, commentPage);
        
        List<Comment> commentList = commentService.getComments(boardNo, pagination);
    
        model.addAttribute("page", page);
        model.addAttribute("board", board);
        model.addAttribute("categoryNo", categoryNo);
        model.addAttribute("commentList", commentList);
        model.addAttribute("pagination", pagination);
        
        return "boards/board_view";
    }

//    게시글 삭제
    @DeleteMapping
    public String delete() {
        
        return "redirect:/boards";
    }
    
//    댓글 등록
    @PostMapping("/boards/{boardNo}/comment")
    public String registComment(@PathVariable(value = "boardNo") long boardId) {
    
        return "redirect:/boards/"+boardId;
    }
    
//    댓글 삭제
    @DeleteMapping("/boards/{boardNo}/comment")
    public String deleteComment(@PathVariable(value = "boardNo") long boardId) {
    
        return "redirect:/boards/"+boardId;
    }

}

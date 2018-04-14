package examples.teamboard.controller;


import examples.teamboard.common.Pagination;
import examples.teamboard.domain.Board;
import examples.teamboard.domain.Comment;
import examples.teamboard.service.BoardService;
import examples.teamboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    public String boards(@RequestParam(name = "categoryNo", defaultValue = "1") int categoryNo,
                         @RequestParam(name = "page", defaultValue = "1") int page,
                         @RequestParam(name = "searchType", defaultValue = "title") String searchType,
                         @RequestParam(name = "searchStr", defaultValue = "") String searchStr,
                         ModelMap modelMap) {

        int totalCnt = boardService.getTotalCnt(searchType, searchStr);
        Pagination pagination = new Pagination(totalCnt,10, page);
        List<Board> boardList = boardService.getBoards(pagination, 1, searchType, searchStr);

        modelMap.addAttribute("hasPrev", pagination.hasPrev());
        modelMap.addAttribute("hasNext", pagination.hasNext());
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("categoryNo", categoryNo);
        modelMap.addAttribute("startPage", pagination.getStartPage());
        modelMap.addAttribute("endPage", pagination.getEndPage());
        modelMap.addAttribute("searchType", searchType);
        modelMap.addAttribute("searchStr", searchStr);
        modelMap.addAttribute("boardList", boardList);

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
    public String boardDetail(@PathVariable("boardNo") long boardNo, @RequestParam int categoryNo
            , @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "1") int commentPage
            , @RequestParam(name = "searchType", defaultValue = "title") String searchType
            , @RequestParam(name = "searchStr", defaultValue = "") String searchStr, Model model) {

        Board board = boardService.getBoard(boardNo);
    
        int totalCount = commentService.totalCount(boardNo);
        Pagination pagination = new Pagination(totalCount, POST_SIZE, commentPage);

        List<Comment> commentList = commentService.getComments(boardNo, pagination);

        model.addAttribute("board", board);
        model.addAttribute("categoryNo", categoryNo);
        model.addAttribute("commentList", commentList);
        model.addAttribute("page", page);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchStr", searchStr);


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
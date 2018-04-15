package examples.teamboard.controller;


import examples.teamboard.common.Pagination;
import examples.teamboard.domain.Board;
import examples.teamboard.domain.Comment;
import examples.teamboard.domain.User;
import examples.teamboard.service.BoardService;
import examples.teamboard.service.CommentService;
import examples.teamboard.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchStr", searchStr);
        model.addAttribute("commentPage", commentPage);
    
        //TODO  테스트용이니까삭제 해야댐.
        User user = new User();
        user.setNickName("스터디맨");
        user.setId("freewifi");
        model.addAttribute("user", user);
        
        return "boards/board_view";
    }

    //    게시글 삭제
    @DeleteMapping
    public String delete() {

        return "redirect:/boards";
    }

//    댓글 등록
    @PostMapping("/{boardNo}/comment")
    public String registComment(@PathVariable("boardNo") long boardNo, @RequestParam(defaultValue = "1") int categoryNo
            , @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "1") int commentPage
            , @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchStr
            , Comment comment, HttpSession session) {
    
        
        User user = (User) session.getAttribute("user");
        // TODO 테스트용. 삭제 해야댐.
        user = new User();
        user.setId("studyman");
        ////////////////////////////////////////////////////////
    
        comment.setUserId(user.getId());
        commentService.registComment(comment);
        
        String url = createCommentRedirectUrl(categoryNo, page, commentPage, searchType, searchStr);
        
        return "redirect:/boards/"+boardNo+url;
    }
    
    private String createCommentRedirectUrl(int categoryNo, int page, int commentPage
            , String searchType, String searchStr) {
        
        
        StringBuilder builder = new StringBuilder();
        builder.append("?");
        builder.append("categoryNo=").append(categoryNo);
        builder.append("&").append("page=").append(page);
        builder.append("&").append("commentPage=").append(commentPage);
        if(StringUtil.isNotBlank(searchType)) {
            builder.append("&").append("searchType=").append(searchType);
            builder.append("&").append("searchStr=").append(searchStr);
        }
        return builder.toString();
    }
    
    //    댓글 삭제
    @DeleteMapping("/{boardNo}/comment")
    public String deleteComment(@PathVariable(value = "boardNo") long boardNo) {

        return "redirect:/boards/"+boardNo;
    }

}
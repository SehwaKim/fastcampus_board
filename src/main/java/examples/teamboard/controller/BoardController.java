package examples.teamboard.controller;


import examples.teamboard.common.Pagination;
import examples.teamboard.domain.Board;
import examples.teamboard.domain.Comment;
import examples.teamboard.domain.FileDTO;
import examples.teamboard.domain.User;
import examples.teamboard.service.BoardService;
import examples.teamboard.service.CommentService;
import examples.teamboard.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
                         @RequestParam(name = "searchType", required = false) String searchType,
                         @RequestParam(name = "searchStr", required = false) String searchStr,
                         ModelMap modelMap) {

        int totalCnt = boardService.getTotalCnt(searchType, searchStr);
        Pagination pagination = new Pagination(totalCnt,10, page);
        List<Board> boardList = boardService.getBoards(pagination, 1, searchType, searchStr);

        modelMap.addAttribute("page", page);
        modelMap.addAttribute("categoryNo", categoryNo);
        modelMap.addAttribute("pagination", pagination);
        modelMap.addAttribute("searchType", searchType);
        modelMap.addAttribute("searchStr", searchStr);
        modelMap.addAttribute("boardList", boardList);

        return "boards/boards_list";
    }
    
//    게시글 쓰기페이지 이동
    @GetMapping("/writeform")
    public String writeForm(@RequestParam(defaultValue = "1") int categoryNo
            , @RequestParam(defaultValue = "1") int page, @RequestParam(required = false) String searchType
            , @RequestParam(required = false) String searchStr, Model model) {
    
        model.addAttribute("page", page);
        model.addAttribute("categoryNo", categoryNo);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchStr", searchStr);
        
        return "boards/board_writeform";
    }
    
//    게시글 등록
    @PostMapping
    public String write(@RequestParam(defaultValue = "1") int page
            , @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchStr
            , @RequestParam(defaultValue = "1") int categoryNo
            , String title, String content
            , @RequestParam(name = "image", required = false) MultipartFile file
            , HttpSession session) {

        // 파일 업로드
        String fileName = file.getOriginalFilename();
        int fileSize = (int)file.getSize();

        System.out.println("filename : "+fileName+", fileSize : "+fileSize);

        StringBuffer sb = new StringBuffer("/tmp/download/");
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        sb.append(year);
        sb.append("/");
        sb.append(month);
        sb.append("/");
        sb.append(day);
        sb.append("/");

        String dir = sb.toString();

        File fileObj = new File(dir);
        if(!fileObj.exists()){
            fileObj.mkdirs();
        }

        UUID uuid = UUID.randomUUID();

        String savefilename = uuid.toString();
        String savefilepath = dir + savefilename;

        try(InputStream in =  file.getInputStream();
            FileOutputStream fos = new FileOutputStream(savefilepath);
            ){

            byte[] buffer = new byte[1024];
            int readCount = 0;

            while((readCount = in.read(buffer)) != -1){
                fos.write(buffer, 0, readCount);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        FileDTO fileDTO = new FileDTO();
        fileDTO.setName(fileName);
        fileDTO.setSize(fileSize);
        fileDTO.setPath(savefilepath);
        fileDTO.setType(file.getContentType());

        User user = (User) session.getAttribute("user");

        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setUserId(user.getId());
        board.setCategoryNo(categoryNo);
        
        Map<String, Long> map = boardService.addBoard(board, fileDTO);
        Long boardNo = map.get("boardNo");
        Long fileNo = map.get("fileNo");
    
        String queryParams = createCommentRedirectQueryParams(board.getCategoryNo(), page, 0, searchType, searchStr);
        
        return "redirect:/boards/"+boardNo+queryParams;
    }
    
//    게시글 수정페이지 이동
    @GetMapping("updateform")
    public String updateForm(@RequestParam Long boardNo, @RequestParam(defaultValue = "1") int categoryNo
            , @RequestParam(defaultValue = "1") int page, @RequestParam(required = false) String searchType
            , @RequestParam(required = false) String searchStr, Model model) {
    
        Board board = boardService.getBoard(boardNo);
    
        model.addAttribute("page", page);
        model.addAttribute("board", board);
        model.addAttribute("categoryNo", categoryNo);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchStr", searchStr);
        
        return "boards/board_updateform";
    }

//    게시글 수정
    @PutMapping("/{boardNo}")
    public String update(@PathVariable("boardNo") long boardNo, @RequestParam(defaultValue = "1") int page
            , @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchStr
            , Board board) {
    
        board.setBoardNo(boardNo);
    
        boardService.updateBoard(board);
        
        String queryParams = createCommentRedirectQueryParams(board.getCategoryNo(), page, 0, searchType, searchStr);
    
        return "redirect:/boards/"+boardNo+queryParams;
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
    
        return "boards/board_view";
    }

    //    게시글 삭제
    @DeleteMapping("/{boardNo}")
    public String delete(@PathVariable("boardNo") long boardNo, @RequestParam(defaultValue = "1") int categoryNo) {
    
        boardService.deleteBoard(boardNo);
        
        return "redirect:/boards?categoryNo="+categoryNo;
    }

//    댓글 등록
    @PostMapping("/{boardNo}/comment")
    public String registComment(@PathVariable("boardNo") long boardNo, @RequestParam(defaultValue = "1") int categoryNo
            , @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "1") int commentPage
            , @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchStr
            , Comment comment, HttpSession session) {
    
        
        User user = (User) session.getAttribute("user");
        
        comment.setUserId(user.getId());
        commentService.registComment(comment);
        
        String queryParams = createCommentRedirectQueryParams(categoryNo, page, commentPage, searchType, searchStr);
        
        return "redirect:/boards/"+boardNo+queryParams;
    }
    
    private String createCommentRedirectQueryParams(int categoryNo, int page, int commentPage
            , String searchType, String searchStr) {
        
        
        StringBuilder builder = new StringBuilder();
        builder.append("?");
        builder.append("categoryNo=").append(categoryNo);
        builder.append("&").append("page=").append(page);
        if(commentPage > 0) {
            builder.append("&").append("commentPage=").append(commentPage);
        }
        if(StringUtil.isNotBlank(searchType)) {
            builder.append("&").append("searchType=").append(searchType);
            builder.append("&").append("searchStr=").append(searchStr);
        }
        return builder.toString();
    }
    
    //    댓글 삭제
    @DeleteMapping("/{boardNo}/comment/{commentNo}")
    public String deleteComment(@PathVariable("boardNo") long boardNo, @PathVariable("commentNo") long commentNo
            , @RequestParam(defaultValue = "1") int categoryNo, @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "1") int commentPage, @RequestParam(required = false) String searchType
            , @RequestParam(required = false) String searchStr) {
    
        commentService.deleteComment(commentNo);
        
        String queryParams = createCommentRedirectQueryParams(categoryNo, page, commentPage, searchType, searchStr);
        
        return "redirect:/boards/"+boardNo+queryParams;
    }

}
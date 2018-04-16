package examples.teamboard.service;

import examples.teamboard.common.Pagination;
import examples.teamboard.dao.BoardDAO;
import examples.teamboard.dao.FileDAO;
import examples.teamboard.domain.Board;
import examples.teamboard.domain.FileInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardDAO boardDAO;
    private FileDAO fileDAO;

    public BoardServiceImpl(BoardDAO boardDAO, FileDAO fileDAO) {
        this.boardDAO = boardDAO;
        this.fileDAO = fileDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> getBoards(Pagination pagination, int categoryNo, String searchType, String searchStr) {
        return boardDAO.selectBoardList(pagination, categoryNo, searchType, searchStr);
    }

    @Override
    @Transactional
    public Board getBoard(Long boardNo) {
        //TODO
        // hit이 증가하되 세션이 유지되는 한 동일 사용자로 인한 hit의 중복 증가를 막아야 함
        // 게시물을 읽는 동시에 댓글도 가져와야 하는데 comment list를 가져오는 것도 이 트랙젝션에 포함일까?

        Board board = boardDAO.selectBoard(boardNo);
        List<Long> fileNoList = fileDAO.selectFileNo(boardNo);
        boardDAO.updateBoardHit(boardNo);

        board.setFileNoList(fileNoList);

        return board;
    }

    @Override
    @Transactional
    public Long addBoard(Board board, MultipartFile file) {
        Long boardNo = boardDAO.insertBoard(board);
        FileInfo fileDTO = saveFile(file);
        fileDTO.setBoardNo(boardNo);
        fileDAO.insertFile(fileDTO);

        return boardNo;
    }

    private FileInfo saveFile(MultipartFile file){
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

        FileInfo fileDTO = new FileInfo();
        fileDTO.setName(fileName);
        fileDTO.setSize(fileSize);
        fileDTO.setPath(savefilepath);
        fileDTO.setType(file.getContentType());

        return fileDTO;
    }

    @Override
    @Transactional
    public int updateBoard(Board board) {
        return boardDAO.updateBoard(board);
    }

    @Override
    @Transactional
    public int deleteBoard(Long boardNo) {
        return boardDAO.deleteBoard(boardNo);
    }

    @Override
    @Transactional(readOnly = true)
    public int getTotalCnt(String searchType, String searchStr){
        return boardDAO.selectTotalCnt(searchType, searchStr);
    }

    @Override
    public FileInfo getFileInfo(Long fileNo) {
        return fileDAO.selectFile(fileNo);
    }
}

package examples.teamboard.common;

public class Pagination {
    private int pageCnt;
    private int totalCnt;
    private int postSize;
    private int startIdx;

    public Pagination(int totalCnt, int postSize) {
        this.totalCnt = totalCnt;
        this.postSize = postSize;
    }

    public int getPageCnt() {
        return pageCnt;
    }

    public void setPageCnt(int pageCnt) {
        this.pageCnt = pageCnt;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getPostSize() {
        return postSize;
    }

    public void setPostSize(int postSize) {
        this.postSize = postSize;
    }

    public int getStartIdx() {
        return startIdx;
    }

    public void setStartIdx(int startIdx) {
        this.startIdx = startIdx;
    }
}

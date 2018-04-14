package examples.teamboard.util;

import examples.teamboard.common.Pagination;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PaginationTest {
    
    @Test
    public void testStartIdx() {
        Pagination pagination = new Pagination(58, 10, 3);
    
        assertEquals(20, pagination.getStartIdx());
    }
    
    @Test
    public void testTotalPageCount() {
        Pagination pagination = new Pagination(58, 10);
        
        assertEquals(6, pagination.getTotalPageCnt());
    }
    
    @Test
    public void testEndIdx() {
        Pagination pagination = new Pagination(58, 10, 6);
        
        assertEquals(57, pagination.getEndIdx());
    }
    
    @Test
    public void testStartPage() {
        Pagination pagination = new Pagination(58, 10);
        
        assertEquals(1, pagination.getStartPage());
        assertFalse(pagination.hasPrev());
    }
    
    @Test
    public void testEndPage() {
        Pagination pagination = new Pagination(58, 10, 7);
        
        assertEquals(6, pagination.getEndPage());
        assertFalse(pagination.hasNext());
    }
    
}

package com.freecharge.test;

import org.junit.Test;
import static org.junit.Assert.*;
import com.freecharge.dao.FileDAO;
import java.io.FileNotFoundException;
public class FileDAOTest{
    private FileDAO fileDAO=new FileDAO();
    
    @Test
    public void testCount(){
        
        try{
        int count=fileDAO.getCount("java");  
        assertTrue(count>=0);
        }catch(Exception e){
            
        }
    }
}
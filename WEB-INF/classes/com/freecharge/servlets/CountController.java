package com.freecharge.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freecharge.utility.GlobalResources;
import com.freecharge.dao.FileDAO;
import org.json.simple.JSONObject;

public class CountController extends HttpServlet{
    private FileDAO fileDAO=new FileDAO();
	protected void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
	throws ServletException, IOException {
        JSONObject jsonResponse = new JSONObject();
		try{    
		String query=(String)httpServletRequest.getParameter("query");
		if(query!=null && query.length()>0){
            jsonResponse.put("count",fileDAO.getCount(query));
		}else{
			jsonResponse.put("Result","Some Error Occured.Please Try Again!");
		}
    }catch(Exception e){
            jsonResponse.put("Result","Some Error Occured.Please Try Again!");
	        System.out.println("Exception in class : CountController method: processRequest "+e.getMessage());
    }
           httpServletResponse.setContentType("application/json");
           httpServletResponse.getWriter().write(jsonResponse.toString());
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	} 
    
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	}
    
}

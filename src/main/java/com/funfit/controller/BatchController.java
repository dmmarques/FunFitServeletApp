package com.funfit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.service.BatchService;

/**
 * Servlet implementation class BatchController
 */
@WebServlet("/batchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BatchService batchService = new BatchService();

	/**
	 * Default constructor.
	 */
	public BatchController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		List<Batch> listOfBatch = batchService.fetchAllBatches();
		HttpSession hs = request.getSession();

		hs.setAttribute("batches", listOfBatch);
		String flagValue = request.getParameter("flag");
		if (flagValue.equals("2")) {
			response.sendRedirect("addStudents.jsp");
		} else {
			response.sendRedirect("viewBatches.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            String batchId = request.getParameter("bid");
            String result = batchService.deleteBatch(batchId);
            
            RequestDispatcher rd = request.getRequestDispatcher("viewBatches.jsp");
            pw.print(result);
            rd.include(request, response);
        } else {
    		String typeofbatch = request.getParameter("typeofbatch");
    		String time = request.getParameter("time");
    		RequestDispatcher rd = request.getRequestDispatcher("addBatch.jsp");
    		Batch batch = new Batch();
    		
    		batch.setTypeofbatch(typeofbatch);
    		batch.setTime(time);

    		String result = batchService.addBatch(batch);
    		pw.println(result);
    		rd.include(request, response);
        }
	}

}

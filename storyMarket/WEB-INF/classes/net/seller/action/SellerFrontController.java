package net.seller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SellerFrontController extends HttpServlet{

	

	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("c: doProcess()호출-SellerFrontController");
		
		
		System.out.println("\n\n 가상주소계산하기");
		String requestURI = request.getRequestURI();
		System.out.println("requestURI: "+requestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath: "+contextPath);
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("command : "+command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/sellerWriteForm.se")) {
		    System.out.println("c : /sellerWrite.se 호출! ");	
			System.out.println("c : view 페이지로 이동");
			
			forward = new ActionForward();
			forward.setPath("./seller/sellerWriteForm.jsp");
			forward.setRedirect(false);
				
		}
		else if(command.equals("/sellerSelection.se")) {
			System.out.println("c: /sellerSelection.se 호출!");
			System.out.println("c: view 페이지로 이동");
			
			forward = new ActionForward();
			forward.setPath("./seller/sellerSelection.jsp");
			forward.setRedirect(false);
		}
		
		
		else if(command.equals("/sellerWriteAction.se")) {
			System.out.println("c: /sellerWriteAction.se 호출!");
			System.out.println("c: DB사용(o)-> 페이지 이동");
			
			action = new sellerWriteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
	         
	
			
		}
		
			
		else if(command.equals("/sellerList.se")) {
			
			System.out.println("c: /sellerList.se 호출!");
			System.out.println("c: DB데이터를 가지고 jsp 페이지 이동");
			
			action = new sellerListAction();
			
			try {
				forward = action.execute(request, response);
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		}
		else if(command.equals("/sellerMainAction.se")) {
			System.out.println("c: /sellerMainAction.se호출");
			System.out.println("c: DB데이터를 가지고 jsp페이지 이동");
			
			action = new sellerMainAction();
			
			try {
				
				forward = action.execute(request, response);
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			
		}
            else if(command.equals("/searchList.se")) {
			
			System.out.println("c: /searchList.se 호출!");
			System.out.println("c: DB데이터를 가지고 jsp 페이지 이동");
			
			action = new searchAction();
			
			try {
				forward = action.execute(request, response);
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		}
		
		System.out.println("가상 주소처리(매핑) \n\n ");
	/*************************************************************/
		if(forward != null) {
			
			if(forward.isRedirect()) {
				System.out.println("c : 페이지 이동(sendRedirect)");
				response.sendRedirect(forward.getPath());
				
			}else {
				System.out.println("c : 페이지 이동(forward)");
				
				RequestDispatcher dis =
						request.getRequestDispatcher(forward.getPath());
				
				dis.forward(request, response);
			}
			
			
			
			
			
		}
		
	   System.out.println("3.페이지 이동 \n\n");
		
		
	}


	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("c: doGet()호출-SellerFrontController");
		doProcess(request, response);
		
	
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("c: doPost()호출-SellerFrontController");
		doProcess(request, response);
	
	}
	
	

}

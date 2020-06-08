package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println("uri:" + uri);
		// 分析请求资源路径，进行不同的处理
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("path:" + path);
		if ("/list".equals(path)) {
			response.sendRedirect("list.jsp");
		} else if ("/add".equals(path)) {
			request.setAttribute("add","this is add page");
			RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
			rd.forward(request,response);
		}
	}

}

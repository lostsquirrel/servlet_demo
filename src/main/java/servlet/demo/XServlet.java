package servlet.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class XServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(XServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/classes/log4j.xml");
		URL path = getServletContext().getResource("/WEB-INF/classes/log4j.xml");
		log.debug(path.getFile());
		PrintWriter pw = resp.getWriter();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		String content = null;
		while ((content = bufferedReader.readLine()) != null ) {
			pw.append(content);
		}
		
		pw.close();
		in.close();
	}



}

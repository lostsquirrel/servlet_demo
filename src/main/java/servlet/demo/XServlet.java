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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(XServlet.class);
	
	private String resource = "/WEB-INF/classes/log4j.xml";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		try {
			InputStream in = getServletContext().getResourceAsStream(resource);
			URL path = getServletContext().getResource(resource);
			if (path != null) {
				log.debug(path.getFile());
			}
			if (in != null) {
				try {
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
					String content = null;
					while ((content = bufferedReader.readLine()) != null ) {
						pw.append(content);
					}
					
				} finally {
					in.close();
				}
			} else {
				pw.write(String.format("load resource %s fail!", resource));
			}
		} finally {
			pw.close();
		}
		
	}



}

package servlet.demo;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(RequestCountServlet.class);
	
	private static long count = 0;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		count += 1;
		long millis = new Random().nextLong() % 1000;
		millis = millis < 0 ? millis * -1 : millis;
		//		System.out.println(count);
		try {
			log.debug(String.format("sleep in %d ms", millis));
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		log.debug(""+count);
		resp.getWriter().print(count);
	}

	
}

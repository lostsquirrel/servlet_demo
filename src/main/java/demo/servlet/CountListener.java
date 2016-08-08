package demo.servlet;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountListener implements ServletContextListener {

	private static final Logger log = LoggerFactory.getLogger(CountListener.class);
	
	private ScheduledExecutorService scheduler;
	
	private AtomicLong counter;
	
	private ConcurrentLinkedQueue<Integer> q;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		counter = new AtomicLong();
		
		
		q = new ConcurrentLinkedQueue<Integer>();
		sce.getServletContext().setAttribute("count_queue", q);
		scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				int ci = q.size();
				while(ci > 0) {
					Integer ms = q.poll();
					if (ms != null){
						
						log.debug(String.format("x sleep %3d ms", ms));
						long count = counter.incrementAndGet();
						log.debug(String.valueOf(count));
						
					}
					ci--;
				}
			}
			
		}, 0, 1, TimeUnit.MINUTES);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		scheduler.shutdownNow();
	}

}

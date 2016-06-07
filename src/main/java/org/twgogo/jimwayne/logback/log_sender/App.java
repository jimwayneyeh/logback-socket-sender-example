package org.twgogo.jimwayne.logback.log_sender;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class App {
	private static Logger log = LoggerFactory.getLogger("org.twgogo.jimwayne.logback");
	private static SecureRandom rand = new SecureRandom();
	static {
		try {
			MDC.put("hostname", InetAddress.getLocalHost().getHostName() + rand.nextInt());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		log.info("Start log sender.");
		
		long loopCount = 0;
		while(true && !Thread.currentThread().isInterrupted()) {
			log.info("Loop #{} for random number '{}'.", ++loopCount, rand.nextLong());
			
			try {
				Thread.sleep(750 + rand.nextInt(500));
			} catch (InterruptedException e) {
				log.warn("Thread is interrupted.", e);
				break;
			}
		}
	}
}

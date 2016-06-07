package org.twgogo.jimwayne.logback.log_sender;

import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger("org.twgogo.jimwayne.logback");
		SecureRandom rand = new SecureRandom();
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

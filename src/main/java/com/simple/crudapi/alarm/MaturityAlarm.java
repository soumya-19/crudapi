package com.simple.crudapi.alarm;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.simple.crudapi.resource.TradesResource;

@SpringBootApplication
@EnableScheduling
public class MaturityAlarm {

	@Scheduled(initialDelay = 86400000, fixedRate = 86400000)
	public void run() {
		try {
			for (int i = 0; i <= TradesResource.singleton().alTrades.size() - 1; i++) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date inputDate = sdf.parse(TradesResource.singleton().alTrades.get(i).getMaturityDate());
				Date currentDate = sdf
						.parse(java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				int result = inputDate.compareTo(currentDate);
				if (result <= 0) {
					TradesResource.singleton().alTrades.get(i).setExpired("Y");
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}

package com.mht.exposeapi.service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.mht.exposeapi.dto.Measure;
import com.mht.exposeapi.dto.MeasureHistory;
import com.mht.exposeapi.dto.MeasureHistoryResponse;
import com.mht.exposeapi.dto.Range;

@Service()
public class SonarApiServiceImpl implements SonarApiService{

	@Override
	public List<List<Object>> getDataPoint(Range range, String metrics) {
		List<List<Object>> datapoints = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		String historyMetrics = "http://localhost:9000/api/measures/search_history";
		UriComponentsBuilder builder = UriComponentsBuilder
			    .fromUriString(historyMetrics)
			    // Add query parameter
			    .queryParam("component", "com.infy.sonar:sonar-spring-demo")
			    .queryParam("metrics", metrics);
		MeasureHistoryResponse measureHistoryResponse = restTemplate.getForObject(builder.toUriString(), MeasureHistoryResponse.class);
		System.out.println("sonar response - "+measureHistoryResponse);
		for(Measure measure: measureHistoryResponse.getMeasures()) {
			for(MeasureHistory measureHistory: measure.getHistory()) {
				ZonedDateTime zonedDateTime = measureHistory.getDate();
				System.out.println("zoned time - "+zonedDateTime);
				Long epochSecond = zonedDateTime.toEpochSecond();
				LocalDateTime historyTime = zonedDateTime.toLocalDateTime();
				LocalDateTime rangeFrom = range.getFrom();
				LocalDateTime rangeTo = range.getTo();
				System.out.println("history - "+historyTime);
				System.out.println("from - "+rangeFrom);
				System.out.println("to - "+rangeTo);
				System.out.println("epoch sec - "+epochSecond);
				if(historyTime.isBefore(range.getFrom()) || historyTime.isAfter(range.getTo()))
					continue;
				List<Object> datapoint = Arrays.asList(measureHistory.getValue(),epochSecond*1000);
				datapoints.add(datapoint);
			}
		}
		return datapoints;
	}

}

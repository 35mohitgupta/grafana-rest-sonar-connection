package com.mht.exposeapi.controllers;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mht.exposeapi.dto.AnnotationRequest;
import com.mht.exposeapi.dto.QueryRequest;
import com.mht.exposeapi.dto.QueryType;
import com.mht.exposeapi.dto.Range;
import com.mht.exposeapi.dto.TableQueryResponse;
import com.mht.exposeapi.dto.TagKeysResponse;
import com.mht.exposeapi.dto.Target;
import com.mht.exposeapi.dto.TimeserieQueryResponse;
import com.mht.exposeapi.service.SonarApiService;

@CrossOrigin
@RestController
public class SonarAPIController {

	@Autowired
	private SonarApiService sonarApiService;
	
	@GetMapping("/")
	public ResponseEntity<String> testDataSourceConnection(){
		System.out.println(">>>>>> testing datasource connection-\n");
		return new ResponseEntity<String>("Test connection established",HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<String>> getMetrics(@RequestBody JSONObject request){
		System.out.println(">>>>>> getting metrics -\n"+request);
		List<String> metrics = Arrays.asList("coverage","new_violations","ncloc");
		return new ResponseEntity<List<String>>(metrics, HttpStatus.OK);
	}
	
	@PostMapping("/annotations")
	public ResponseEntity<List<String>> getAnnotations(@RequestBody AnnotationRequest request){
		System.out.println(">>>>>> getting metrics -\n"+request);
		List<String> metrics = Arrays.asList("coverage","new_violations","ncloc","complexity");
		return new ResponseEntity<List<String>>(metrics, HttpStatus.OK);
	}
	
	@PostMapping("/query")
	public ResponseEntity<List<Object>> query(@RequestBody QueryRequest request){
		System.out.println(">>>>>> querying -\n"+request);
		List<Object> response = new ArrayList<Object>();
		Range range = request.getRange();
		for(Target target: request.getTargets()) {
			String metric = target.getTarget();
			QueryType type = target.getType();
			if(type == QueryType.timeserie) {
				List<List<Object>> datapoints = sonarApiService.getDataPoint(range, metric);
				System.out.println("datapoints - "+datapoints);
				TimeserieQueryResponse timeQuery = new TimeserieQueryResponse();
				timeQuery.setDatapoints(datapoints);
				timeQuery.setTarget(metric);
				response.add(timeQuery);
			}else {
				TableQueryResponse tableQuery = new TableQueryResponse();
				response.add(tableQuery);
			}
			
		}
		
		
		
		return new ResponseEntity<List<Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/tag-keys")
	public List<TagKeysResponse> getTagKey(@RequestBody JSONObject request){
		List<TagKeysResponse> tagKeys = new ArrayList<TagKeysResponse>();
		return null;
	}
	
	
	@GetMapping("/test")
	public List<List<Object>> test() {
		Range range = new Range();
		range.setFrom(LocalDateTime.of(2020, 8, 24, 13, 25));
		range.setTo(LocalDateTime.now());
		List<List<Object>> datapoints = sonarApiService.getDataPoint(range, "coverage");
		System.out.println("datapoints - \n"+datapoints);
		return datapoints;
	}
	
}

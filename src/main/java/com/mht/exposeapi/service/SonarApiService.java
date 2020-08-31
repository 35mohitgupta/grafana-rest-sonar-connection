package com.mht.exposeapi.service;

import java.util.List;

import com.mht.exposeapi.dto.Range;

public interface SonarApiService {

	public List<List<Object>> getDataPoint(Range range, String metrics);
}

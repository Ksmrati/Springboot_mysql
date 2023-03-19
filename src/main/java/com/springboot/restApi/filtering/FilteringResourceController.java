package com.springboot.restApi.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringResourceController {

	@GetMapping("/filtering")
	public MappingJacksonValue someBean(){
		 SomeBean someBean = new SomeBean("value1", "value2", "value3");
	MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
	SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
	FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter );
	mappingJacksonValue.setFilters(filters );
		return mappingJacksonValue;
	}
	
	

	@GetMapping("/filtering-list")
	public MappingJacksonValue someListBean(){
		List<SomeBean> asList = Arrays.asList(new SomeBean("a", "b", "c"), 
				new SomeBean("d", "e", "f"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(asList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter );
		mappingJacksonValue.setFilters(filters );
		return mappingJacksonValue;
	}
	
	
}

package com.springboot.restApi.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class versioningPersonController {

	//URI Versionning
	@GetMapping("v1/personName")
	public PersonV1 getFirstVersionofPerson() {
		return new PersonV1(" smrati kushwah");
	}
	
	//URI Versionning
	@GetMapping("v2/personName")
	public PersonV2 getSecondVersionofPerson() {
		return new PersonV2(new Name("smrati", "kushwah"));
	}
	
	//Request parameter versionning
	@GetMapping(path= "/person", params="version=1")
	public PersonV1 getFirstVersionofPersonRequestParameter() {
		return new PersonV1(" smrati kushwah");
	}
	
	//Request parameter versionning
	@GetMapping(path= "/person", params="version=2")
	public PersonV2 getSecondVersionofPersonRequestParameter() {
		return new PersonV2(new Name("smrati", "kushwah"));
	}
	
	//Custom header versionning
	@GetMapping(path= "/person/header", headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionofPersonHeader() {
		return new PersonV1(" smrati kushwah");
	}

	//Custom header versioning
	@GetMapping(path= "/person/header", headers="X-API-VERSION=2")
	public PersonV2 getSecondVersionofPersonHeader() {
		return new PersonV2(new Name("smrati", "kushwah"));
	}
	
	//Media type header versioning
	@GetMapping(path= "/person/acceptHeader", produces="application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionofPersonAcceptHeader() {
		return new PersonV1(" smrati kushwah");
	}

	//Custom header versionning
	@GetMapping(path= "/person/acceptHeader", produces="application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionofPersonAcceptHeader() {
		return new PersonV2(new Name("smrati", "kushwah"));
	}
}

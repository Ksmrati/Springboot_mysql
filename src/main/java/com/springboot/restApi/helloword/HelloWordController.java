package com.springboot.restApi.helloword;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class HelloWordController {

	private MessageSource messageSource;
	
	public HelloWordController(MessageSource messageSource) {
		this.messageSource= messageSource;
	}
	
	@GetMapping("/hello-word")
	public String getHelloword() {
		return 	"Hello";
	}
	
	@GetMapping("/hello-word-bean")
	public HelloWordBean hellowordBean() {
		return 	new HelloWordBean("hello-word");
	}
	
	@GetMapping("/hello-word-bean/pathvaraible/{name}")
	public HelloWordBean hellowordPathVariable(@PathVariable String name) {
//		return 	new HelloWordBean("hello-word: "+name); or
		return 	new HelloWordBean(String.format("hello-word, %s", name));
	}
	
	@GetMapping("/hello-word-internationalization")
	public String hellowordInternationalization() {
        Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "defaultMessage", locale );
	}
	
	
}

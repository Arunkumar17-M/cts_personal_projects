package com.demo.project.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		
		return "Hello, What are you learning Today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<title>My First Hello world in Html</title>");
		buffer.append("<body>");
		buffer.append("My First Hello world in Html");
		buffer.append("</body>");
		buffer.append("</html>");
		
		return buffer.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		
		return "sayHello";
	}
}

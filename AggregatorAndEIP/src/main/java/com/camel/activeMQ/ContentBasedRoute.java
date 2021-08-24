package com.camel.activeMQ;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ContentBasedRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
	from("file:D:\\CamelDocs\\EIP\\content").split().tokenize("\n").to("direct:test");
	
	from("direct:test").choice()
	.when(body().contains("SampleQueue1"))
	.to("activemq:queue:activeMQ1")
	.when(body().contains("SampleQueue2"))
	.to("activemq:queue:activeMQ2")
	.otherwise()
	.to("activemq:queue:otherwise");
		
	}

}

package com.camel.activeMQ;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SplitRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {


		from("file:D:\\CamelDocs\\EIP").routeId("1st route")
		.log(LoggingLevel.INFO,"sample").split().tokenize("\n")
		.to("activemq:queue:activeMQ1").log("Message split successfully");
		
		
	}
	

}

/*
 * Copyright 2005-2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.openshiftintegration.esb.wsresttest.transformations;

import org.springframework.stereotype.Component;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("transformationComponent")
public class TransformationComponent {

	private static final Logger logger = LoggerFactory.getLogger("wsresttestLogger");

	public static String returnMessage(String body, Exchange ex) {
		body = "{\"status\": \"active\"}";
		logger.info("Servicio activo, prueba de webhook para Altice.com... Finalizado");
		ex.getIn().setHeader("CamelHttpResponseCode", 200);
		ex.getIn().setHeader("Content-Type", "application/json");
		return body;
	}

}

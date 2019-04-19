package com.messages.errors;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ObjectMapperErrorMapper implements ExceptionMapper<ObjectMapperException> {

	private final static Logger logger = LoggerFactory.getLogger(MongodbExceptionMapper.class);
	private final static String genericErrorMessage = "Failed to parse JSON object";

	public Response toResponse(ObjectMapperException objectMapperException) {
		logger.error("Threw a object mapper exception error message: {} Throw error: {}", objectMapperException.getMessage(), objectMapperException.getCause());

		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(genericErrorMessage).build();
	}
}
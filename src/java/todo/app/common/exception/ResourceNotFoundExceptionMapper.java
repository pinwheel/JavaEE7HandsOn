/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package todo.app.common.exception;

import java.util.Arrays;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import todo.domain.common.exception.ResourceNotFoundException;

/**
 *
 * @author hoi
 */
@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {
    
    @Override
    public Response toResponse(ResourceNotFoundException exception) {
	System.out.println("error:" + exception.getMessage());
        ErrorModel errorModel;
	    errorModel = new ErrorModel(Arrays.asList(exception.getMessage()));
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorModel).build();
    }
}

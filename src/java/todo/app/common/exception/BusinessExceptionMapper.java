/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package todo.app.common.exception;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import todo.domain.common.exception.BusinessException;
/**
 *
 * @author hoi
 */
@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {
  
    @Override
    public Response toResponse(BusinessException exception) {
        List<String> arr = Arrays.asList(exception.getMessage());
	System.out.println("error:" + arr);
        ErrorModel errorModel = new ErrorModel(arr);
        return Response.status(Response.Status.CONFLICT)
                .entity(errorModel).build();
    }
}

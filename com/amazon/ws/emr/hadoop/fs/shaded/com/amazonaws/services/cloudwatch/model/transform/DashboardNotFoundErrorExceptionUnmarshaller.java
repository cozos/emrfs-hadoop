package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DashboardNotFoundErrorException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class DashboardNotFoundErrorExceptionUnmarshaller
  extends StandardErrorUnmarshaller
{
  public DashboardNotFoundErrorExceptionUnmarshaller()
  {
    super(DashboardNotFoundErrorException.class);
  }
  
  public AmazonServiceException unmarshall(Node node)
    throws Exception
  {
    String errorCode = parseErrorCode(node);
    if ((errorCode == null) || (!errorCode.equals("ResourceNotFound"))) {
      return null;
    }
    DashboardNotFoundErrorException e = (DashboardNotFoundErrorException)super.unmarshall(node);
    
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DashboardNotFoundErrorExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
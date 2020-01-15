package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ResourceNotFoundException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class ResourceNotFoundExceptionUnmarshaller
  extends StandardErrorUnmarshaller
{
  public ResourceNotFoundExceptionUnmarshaller()
  {
    super(ResourceNotFoundException.class);
  }
  
  public AmazonServiceException unmarshall(Node node)
    throws Exception
  {
    String errorCode = parseErrorCode(node);
    if ((errorCode == null) || (!errorCode.equals("ResourceNotFoundException"))) {
      return null;
    }
    ResourceNotFoundException e = (ResourceNotFoundException)super.unmarshall(node);
    e.setResourceType(XpathUtils.asString(getErrorPropertyPath("ResourceType"), node));
    e.setResourceId(XpathUtils.asString(getErrorPropertyPath("ResourceId"), node));
    
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ResourceNotFoundExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
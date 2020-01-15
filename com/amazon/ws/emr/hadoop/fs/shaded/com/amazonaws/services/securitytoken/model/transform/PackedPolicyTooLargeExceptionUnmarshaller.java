package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.PackedPolicyTooLargeException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class PackedPolicyTooLargeExceptionUnmarshaller
  extends StandardErrorUnmarshaller
{
  public PackedPolicyTooLargeExceptionUnmarshaller()
  {
    super(PackedPolicyTooLargeException.class);
  }
  
  public AmazonServiceException unmarshall(Node node)
    throws Exception
  {
    String errorCode = parseErrorCode(node);
    if ((errorCode == null) || (!errorCode.equals("PackedPolicyTooLarge"))) {
      return null;
    }
    PackedPolicyTooLargeException e = (PackedPolicyTooLargeException)super.unmarshall(node);
    
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.PackedPolicyTooLargeExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
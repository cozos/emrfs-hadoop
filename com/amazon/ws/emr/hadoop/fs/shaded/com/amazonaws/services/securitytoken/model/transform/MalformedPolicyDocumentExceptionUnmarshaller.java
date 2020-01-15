package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.MalformedPolicyDocumentException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class MalformedPolicyDocumentExceptionUnmarshaller
  extends StandardErrorUnmarshaller
{
  public MalformedPolicyDocumentExceptionUnmarshaller()
  {
    super(MalformedPolicyDocumentException.class);
  }
  
  public AmazonServiceException unmarshall(Node node)
    throws Exception
  {
    String errorCode = parseErrorCode(node);
    if ((errorCode == null) || (!errorCode.equals("MalformedPolicyDocument"))) {
      return null;
    }
    MalformedPolicyDocumentException e = (MalformedPolicyDocumentException)super.unmarshall(node);
    
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.MalformedPolicyDocumentExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
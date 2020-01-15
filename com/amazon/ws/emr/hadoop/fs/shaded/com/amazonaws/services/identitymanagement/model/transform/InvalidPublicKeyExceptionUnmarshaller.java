package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.InvalidPublicKeyException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidPublicKeyExceptionUnmarshaller
  extends StandardErrorUnmarshaller
{
  public InvalidPublicKeyExceptionUnmarshaller()
  {
    super(InvalidPublicKeyException.class);
  }
  
  public AmazonServiceException unmarshall(Node node)
    throws Exception
  {
    String errorCode = parseErrorCode(node);
    if ((errorCode == null) || (!errorCode.equals("InvalidPublicKey"))) {
      return null;
    }
    InvalidPublicKeyException e = (InvalidPublicKeyException)super.unmarshall(node);
    
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.InvalidPublicKeyExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
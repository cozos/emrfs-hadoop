package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EntityTemporarilyUnmodifiableException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class EntityTemporarilyUnmodifiableExceptionUnmarshaller
  extends StandardErrorUnmarshaller
{
  public EntityTemporarilyUnmodifiableExceptionUnmarshaller()
  {
    super(EntityTemporarilyUnmodifiableException.class);
  }
  
  public AmazonServiceException unmarshall(Node node)
    throws Exception
  {
    String errorCode = parseErrorCode(node);
    if ((errorCode == null) || (!errorCode.equals("EntityTemporarilyUnmodifiable"))) {
      return null;
    }
    EntityTemporarilyUnmodifiableException e = (EntityTemporarilyUnmodifiableException)super.unmarshall(node);
    
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.EntityTemporarilyUnmodifiableExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.PutKeyPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class PutKeyPolicyResultJsonUnmarshaller
  implements Unmarshaller<PutKeyPolicyResult, JsonUnmarshallerContext>
{
  private static PutKeyPolicyResultJsonUnmarshaller instance;
  
  public PutKeyPolicyResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    PutKeyPolicyResult putKeyPolicyResult = new PutKeyPolicyResult();
    
    return putKeyPolicyResult;
  }
  
  public static PutKeyPolicyResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PutKeyPolicyResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.PutKeyPolicyResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
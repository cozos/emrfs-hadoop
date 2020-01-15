package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RevokeGrantResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class RevokeGrantResultJsonUnmarshaller
  implements Unmarshaller<RevokeGrantResult, JsonUnmarshallerContext>
{
  private static RevokeGrantResultJsonUnmarshaller instance;
  
  public RevokeGrantResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    RevokeGrantResult revokeGrantResult = new RevokeGrantResult();
    
    return revokeGrantResult;
  }
  
  public static RevokeGrantResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RevokeGrantResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.RevokeGrantResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
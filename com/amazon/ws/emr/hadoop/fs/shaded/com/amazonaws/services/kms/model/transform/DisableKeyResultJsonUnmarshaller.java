package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisableKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class DisableKeyResultJsonUnmarshaller
  implements Unmarshaller<DisableKeyResult, JsonUnmarshallerContext>
{
  private static DisableKeyResultJsonUnmarshaller instance;
  
  public DisableKeyResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DisableKeyResult disableKeyResult = new DisableKeyResult();
    
    return disableKeyResult;
  }
  
  public static DisableKeyResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DisableKeyResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DisableKeyResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
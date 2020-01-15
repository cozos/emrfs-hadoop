package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisableKeyRotationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class DisableKeyRotationResultJsonUnmarshaller
  implements Unmarshaller<DisableKeyRotationResult, JsonUnmarshallerContext>
{
  private static DisableKeyRotationResultJsonUnmarshaller instance;
  
  public DisableKeyRotationResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DisableKeyRotationResult disableKeyRotationResult = new DisableKeyRotationResult();
    
    return disableKeyRotationResult;
  }
  
  public static DisableKeyRotationResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DisableKeyRotationResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DisableKeyRotationResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
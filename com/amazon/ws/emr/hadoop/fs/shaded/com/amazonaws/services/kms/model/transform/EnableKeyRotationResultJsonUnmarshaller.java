package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EnableKeyRotationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class EnableKeyRotationResultJsonUnmarshaller
  implements Unmarshaller<EnableKeyRotationResult, JsonUnmarshallerContext>
{
  private static EnableKeyRotationResultJsonUnmarshaller instance;
  
  public EnableKeyRotationResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    EnableKeyRotationResult enableKeyRotationResult = new EnableKeyRotationResult();
    
    return enableKeyRotationResult;
  }
  
  public static EnableKeyRotationResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EnableKeyRotationResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.EnableKeyRotationResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
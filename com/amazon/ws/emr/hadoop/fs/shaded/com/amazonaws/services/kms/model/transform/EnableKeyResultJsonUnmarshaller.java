package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EnableKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class EnableKeyResultJsonUnmarshaller
  implements Unmarshaller<EnableKeyResult, JsonUnmarshallerContext>
{
  private static EnableKeyResultJsonUnmarshaller instance;
  
  public EnableKeyResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    EnableKeyResult enableKeyResult = new EnableKeyResult();
    
    return enableKeyResult;
  }
  
  public static EnableKeyResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EnableKeyResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.EnableKeyResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RetireGrantResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class RetireGrantResultJsonUnmarshaller
  implements Unmarshaller<RetireGrantResult, JsonUnmarshallerContext>
{
  private static RetireGrantResultJsonUnmarshaller instance;
  
  public RetireGrantResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    RetireGrantResult retireGrantResult = new RetireGrantResult();
    
    return retireGrantResult;
  }
  
  public static RetireGrantResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RetireGrantResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.RetireGrantResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
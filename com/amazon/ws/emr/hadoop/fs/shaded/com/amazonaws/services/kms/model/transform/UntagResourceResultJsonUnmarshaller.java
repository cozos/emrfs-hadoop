package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UntagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class UntagResourceResultJsonUnmarshaller
  implements Unmarshaller<UntagResourceResult, JsonUnmarshallerContext>
{
  private static UntagResourceResultJsonUnmarshaller instance;
  
  public UntagResourceResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    UntagResourceResult untagResourceResult = new UntagResourceResult();
    
    return untagResourceResult;
  }
  
  public static UntagResourceResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UntagResourceResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UntagResourceResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
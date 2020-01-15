package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateKeyDescriptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class UpdateKeyDescriptionResultJsonUnmarshaller
  implements Unmarshaller<UpdateKeyDescriptionResult, JsonUnmarshallerContext>
{
  private static UpdateKeyDescriptionResultJsonUnmarshaller instance;
  
  public UpdateKeyDescriptionResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    UpdateKeyDescriptionResult updateKeyDescriptionResult = new UpdateKeyDescriptionResult();
    
    return updateKeyDescriptionResult;
  }
  
  public static UpdateKeyDescriptionResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateKeyDescriptionResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateKeyDescriptionResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
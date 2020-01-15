package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateAliasResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class UpdateAliasResultJsonUnmarshaller
  implements Unmarshaller<UpdateAliasResult, JsonUnmarshallerContext>
{
  private static UpdateAliasResultJsonUnmarshaller instance;
  
  public UpdateAliasResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    UpdateAliasResult updateAliasResult = new UpdateAliasResult();
    
    return updateAliasResult;
  }
  
  public static UpdateAliasResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateAliasResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateAliasResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
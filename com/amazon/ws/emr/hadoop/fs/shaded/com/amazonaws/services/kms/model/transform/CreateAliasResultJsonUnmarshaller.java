package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateAliasResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class CreateAliasResultJsonUnmarshaller
  implements Unmarshaller<CreateAliasResult, JsonUnmarshallerContext>
{
  private static CreateAliasResultJsonUnmarshaller instance;
  
  public CreateAliasResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    CreateAliasResult createAliasResult = new CreateAliasResult();
    
    return createAliasResult;
  }
  
  public static CreateAliasResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateAliasResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateAliasResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
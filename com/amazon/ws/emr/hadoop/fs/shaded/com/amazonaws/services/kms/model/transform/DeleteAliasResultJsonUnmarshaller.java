package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteAliasResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class DeleteAliasResultJsonUnmarshaller
  implements Unmarshaller<DeleteAliasResult, JsonUnmarshallerContext>
{
  private static DeleteAliasResultJsonUnmarshaller instance;
  
  public DeleteAliasResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DeleteAliasResult deleteAliasResult = new DeleteAliasResult();
    
    return deleteAliasResult;
  }
  
  public static DeleteAliasResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteAliasResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DeleteAliasResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetVisibleToAllUsersResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class SetVisibleToAllUsersResultJsonUnmarshaller
  implements Unmarshaller<SetVisibleToAllUsersResult, JsonUnmarshallerContext>
{
  private static SetVisibleToAllUsersResultJsonUnmarshaller instance;
  
  public SetVisibleToAllUsersResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    SetVisibleToAllUsersResult setVisibleToAllUsersResult = new SetVisibleToAllUsersResult();
    
    return setVisibleToAllUsersResult;
  }
  
  public static SetVisibleToAllUsersResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SetVisibleToAllUsersResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SetVisibleToAllUsersResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
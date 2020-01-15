package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class RemoveTagsResultJsonUnmarshaller
  implements Unmarshaller<RemoveTagsResult, JsonUnmarshallerContext>
{
  private static RemoveTagsResultJsonUnmarshaller instance;
  
  public RemoveTagsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    RemoveTagsResult removeTagsResult = new RemoveTagsResult();
    
    return removeTagsResult;
  }
  
  public static RemoveTagsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RemoveTagsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.RemoveTagsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
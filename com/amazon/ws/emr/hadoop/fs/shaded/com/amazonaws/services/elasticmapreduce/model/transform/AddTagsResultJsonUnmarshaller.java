package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class AddTagsResultJsonUnmarshaller
  implements Unmarshaller<AddTagsResult, JsonUnmarshallerContext>
{
  private static AddTagsResultJsonUnmarshaller instance;
  
  public AddTagsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AddTagsResult addTagsResult = new AddTagsResult();
    
    return addTagsResult;
  }
  
  public static AddTagsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AddTagsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddTagsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
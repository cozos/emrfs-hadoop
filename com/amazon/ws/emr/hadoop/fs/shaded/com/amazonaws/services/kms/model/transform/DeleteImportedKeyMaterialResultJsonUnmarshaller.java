package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteImportedKeyMaterialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class DeleteImportedKeyMaterialResultJsonUnmarshaller
  implements Unmarshaller<DeleteImportedKeyMaterialResult, JsonUnmarshallerContext>
{
  private static DeleteImportedKeyMaterialResultJsonUnmarshaller instance;
  
  public DeleteImportedKeyMaterialResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DeleteImportedKeyMaterialResult deleteImportedKeyMaterialResult = new DeleteImportedKeyMaterialResult();
    
    return deleteImportedKeyMaterialResult;
  }
  
  public static DeleteImportedKeyMaterialResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteImportedKeyMaterialResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DeleteImportedKeyMaterialResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
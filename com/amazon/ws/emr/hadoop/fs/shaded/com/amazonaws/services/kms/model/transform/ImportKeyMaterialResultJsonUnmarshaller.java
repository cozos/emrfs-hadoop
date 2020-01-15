package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ImportKeyMaterialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class ImportKeyMaterialResultJsonUnmarshaller
  implements Unmarshaller<ImportKeyMaterialResult, JsonUnmarshallerContext>
{
  private static ImportKeyMaterialResultJsonUnmarshaller instance;
  
  public ImportKeyMaterialResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ImportKeyMaterialResult importKeyMaterialResult = new ImportKeyMaterialResult();
    
    return importKeyMaterialResult;
  }
  
  public static ImportKeyMaterialResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ImportKeyMaterialResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ImportKeyMaterialResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
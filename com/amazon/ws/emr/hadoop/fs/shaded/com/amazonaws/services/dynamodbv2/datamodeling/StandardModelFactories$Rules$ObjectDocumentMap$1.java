package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Map;

class StandardModelFactories$Rules$ObjectDocumentMap$1
  implements DynamoDBTypeConverter<Map<String, AttributeValue>, T>
{
  StandardModelFactories$Rules$ObjectDocumentMap$1(StandardModelFactories.Rules.ObjectDocumentMap this$1, ConvertibleType paramConvertibleType) {}
  
  public final Map<String, AttributeValue> convert(T o)
  {
    return StandardModelFactories.Rules.ObjectDocumentMap.access$2900(this$1).getTableFactory(StandardModelFactories.Rules.ObjectDocumentMap.access$2800(this$1)).getTable(val$type.targetType()).convert(o);
  }
  
  public final T unconvert(Map<String, AttributeValue> o)
  {
    return (T)StandardModelFactories.Rules.ObjectDocumentMap.access$2900(this$1).getTableFactory(StandardModelFactories.Rules.ObjectDocumentMap.access$2800(this$1)).getTable(val$type.targetType()).unconvert(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.ObjectDocumentMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
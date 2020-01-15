package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import java.util.Collections;
import java.util.Map;

@Beta
public final class DeleteItemExpressionSpec
  extends ExpressionSpec
{
  private final String conditionExpression;
  private final Map<String, String> nameMap;
  private final Map<String, Object> valueMap;
  
  DeleteItemExpressionSpec(ExpressionSpecBuilder builder)
  {
    SubstitutionContext context = new SubstitutionContext();
    conditionExpression = builder.buildConditionExpression(context);
    Map<String, String> nameMap = context.getNameMap();
    this.nameMap = (nameMap == null ? null : Collections.unmodifiableMap(nameMap));
    Map<String, Object> valueMap = context.getValueMap();
    this.valueMap = (valueMap == null ? null : Collections.unmodifiableMap(valueMap));
  }
  
  public final String getConditionExpression()
  {
    return conditionExpression;
  }
  
  public final Map<String, String> getNameMap()
  {
    return nameMap;
  }
  
  public final Map<String, Object> getValueMap()
  {
    return valueMap;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.DeleteItemExpressionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
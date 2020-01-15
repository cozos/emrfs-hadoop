package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import java.util.Collections;
import java.util.Map;

@Beta
public class UpdateItemExpressionSpec
  extends ExpressionSpec
{
  private final String updateExpression;
  private final String conditionExpression;
  private final Map<String, String> nameMap;
  private final Map<String, Object> valueMap;
  
  UpdateItemExpressionSpec(ExpressionSpecBuilder builder)
  {
    SubstitutionContext context = new SubstitutionContext();
    updateExpression = builder.buildUpdateExpression(context);
    conditionExpression = builder.buildConditionExpression(context);
    Map<String, String> nameMap = context.getNameMap();
    this.nameMap = (nameMap == null ? null : Collections.unmodifiableMap(nameMap));
    Map<String, Object> valueMap = context.getValueMap();
    this.valueMap = (valueMap == null ? null : Collections.unmodifiableMap(valueMap));
  }
  
  public String getUpdateExpression()
  {
    return updateExpression;
  }
  
  public String getConditionExpression()
  {
    return conditionExpression;
  }
  
  public Map<String, String> getNameMap()
  {
    return nameMap;
  }
  
  public Map<String, Object> getValueMap()
  {
    return valueMap;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.UpdateItemExpressionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.Collections;
import java.util.Map;

@Beta
@Immutable
public final class GetItemExpressionSpec
  extends ExpressionSpec
{
  private final String projectionExpression;
  private final Map<String, String> nameMap;
  
  GetItemExpressionSpec(ExpressionSpecBuilder builder)
  {
    SubstitutionContext context = new SubstitutionContext();
    projectionExpression = builder.buildProjectionExpression(context);
    Map<String, String> nameMap = context.getNameMap();
    this.nameMap = (nameMap == null ? null : Collections.unmodifiableMap(nameMap));
  }
  
  public final String getProjectionExpression()
  {
    return projectionExpression;
  }
  
  public final Map<String, String> getNameMap()
  {
    return nameMap;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.GetItemExpressionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
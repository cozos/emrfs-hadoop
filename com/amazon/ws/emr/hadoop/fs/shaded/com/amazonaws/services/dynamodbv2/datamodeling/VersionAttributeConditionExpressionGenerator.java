package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.HashMap;
import java.util.Map;

@SdkInternalApi
public class VersionAttributeConditionExpressionGenerator
{
  private static final String VERSION_ATTRIBUTE_NAME_BASE_TOKEN = "#versionAttributeName";
  private static final String VERSION_ATTRIBUTE_VALUE_BASE_TOKEN = ":versionAttributeValue";
  private final DynamoDBTransactionWriteExpression versionAttributeConditionExpression = new DynamoDBTransactionWriteExpression();
  private Long versionAttributeCounterValue = Long.valueOf(0L);
  
  public void appendVersionAttributeToConditionExpression(DynamoDBMapperFieldModel<Object, Object> field, Object fieldValue)
  {
    versionAttributeCounterValue = Long.valueOf(versionAttributeCounterValue.longValue() + 1L);
    String versionAttributeNameToken = "#versionAttributeName" + versionAttributeCounterValue;
    String versionAttributeValueToken = ":versionAttributeValue" + versionAttributeCounterValue;
    Map<String, String> currentVersionedAttributeConditionExpressionNames = new HashMap();
    currentVersionedAttributeConditionExpressionNames.put(versionAttributeNameToken, field.name());
    Map<String, AttributeValue> currentVersionedAttributeConditionExpressionValues = null;
    String currentVersionConditionExpression = null;
    if (fieldValue == null)
    {
      currentVersionConditionExpression = String.format("attribute_not_exists(%s)", new Object[] { versionAttributeNameToken });
    }
    else
    {
      currentVersionedAttributeConditionExpressionValues = new HashMap();
      currentVersionedAttributeConditionExpressionValues.put(versionAttributeValueToken, field
        .convert(fieldValue));
      currentVersionConditionExpression = String.format("attribute_exists(%s) AND %s = %s", new Object[] { versionAttributeNameToken, versionAttributeNameToken, versionAttributeValueToken });
    }
    if (versionAttributeConditionExpression.getConditionExpression() != null)
    {
      String currentConditionExpression = versionAttributeConditionExpression.getConditionExpression();
      if (versionAttributeCounterValue.longValue() == 2L) {
        currentConditionExpression = "(" + currentConditionExpression + ")";
      }
      versionAttributeConditionExpression.withConditionExpression(currentConditionExpression + " AND (" + currentVersionConditionExpression + ")");
    }
    else
    {
      versionAttributeConditionExpression.withConditionExpression(currentVersionConditionExpression);
    }
    if (versionAttributeConditionExpression.getExpressionAttributeNames() != null) {
      versionAttributeConditionExpression.getExpressionAttributeNames().putAll(currentVersionedAttributeConditionExpressionNames);
    } else {
      versionAttributeConditionExpression.withExpressionAttributeNames(currentVersionedAttributeConditionExpressionNames);
    }
    if (currentVersionedAttributeConditionExpressionValues != null) {
      if (versionAttributeConditionExpression.getExpressionAttributeValues() != null) {
        versionAttributeConditionExpression.getExpressionAttributeValues().putAll(currentVersionedAttributeConditionExpressionValues);
      } else {
        versionAttributeConditionExpression.withExpressionAttributeValues(currentVersionedAttributeConditionExpressionValues);
      }
    }
  }
  
  public DynamoDBTransactionWriteExpression getVersionAttributeConditionExpression()
  {
    return versionAttributeConditionExpression;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.VersionAttributeConditionExpressionGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
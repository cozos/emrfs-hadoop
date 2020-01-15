package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.AttributeUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.VersionInfoUtils;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Deprecated
public enum InternalUtils
{
  private InternalUtils() {}
  
  public static List<Item> toItemList(List<Map<String, AttributeValue>> items)
  {
    return ItemUtils.toItemList(items);
  }
  
  public static Map<String, AttributeValue> toAttributeValues(Item item)
  {
    return ItemUtils.toAttributeValues(item);
  }
  
  public static Map<String, AttributeValue> fromSimpleMap(Map<String, Object> map)
  {
    return ItemUtils.fromSimpleMap(map);
  }
  
  public static Map<String, AttributeValueUpdate> toAttributeValueUpdate(List<AttributeUpdate> attributesToUpdate)
  {
    return ItemUtils.toAttributeValueUpdate(attributesToUpdate);
  }
  
  public static AttributeValue toAttributeValue(Object value)
  {
    return ItemUtils.toAttributeValue(value);
  }
  
  public static List<Object> toSimpleList(List<AttributeValue> attrValues)
  {
    return ItemUtils.toSimpleList(attrValues);
  }
  
  public static <T> List<T> toSimpleListValue(List<AttributeValue> values)
  {
    return ItemUtils.toSimpleListValue(values);
  }
  
  public static <T> Map<String, T> toSimpleMapValue(Map<String, AttributeValue> values)
  {
    return ItemUtils.toSimpleMapValue(values);
  }
  
  public static String valToString(Object val)
  {
    return ItemUtils.valToString(val);
  }
  
  static <T> T toSimpleValue(AttributeValue value)
  {
    return (T)ItemUtils.toSimpleValue(value);
  }
  
  public static Integer minimum(Integer one, Integer two)
  {
    return ItemUtils.minimum(one, two);
  }
  
  public static Map<String, ExpectedAttributeValue> toExpectedAttributeValueMap(Collection<Expected> expectedSet)
  {
    return ItemUtils.toExpectedAttributeValueMap(expectedSet);
  }
  
  public static Map<String, Condition> toAttributeConditionMap(Collection<? extends Filter<?>> filters)
  {
    return ItemUtils.toAttributeConditionMap(filters);
  }
  
  public static AttributeValue[] toAttributeValues(Object[] values)
  {
    return ItemUtils.toAttributeValues(values);
  }
  
  public static Map<String, AttributeValue> toAttributeValueMap(Collection<KeyAttribute> primaryKey)
  {
    return ItemUtils.toAttributeValueMap(primaryKey);
  }
  
  public static Map<String, AttributeValue> toAttributeValueMap(PrimaryKey primaryKey)
  {
    return ItemUtils.toAttributeValueMap(primaryKey);
  }
  
  public static Map<String, AttributeValue> toAttributeValueMap(KeyAttribute... primaryKey)
  {
    return ItemUtils.toAttributeValueMap(primaryKey);
  }
  
  public static BigDecimal toBigDecimal(Number n)
  {
    return ItemUtils.toBigDecimal(n);
  }
  
  public static Set<BigDecimal> toBigDecimalSet(Number... val)
  {
    return ItemUtils.toBigDecimalSet(val);
  }
  
  public static Set<BigDecimal> toBigDecimalSet(Set<Number> vals)
  {
    return ItemUtils.toBigDecimalSet(vals);
  }
  
  public static <X extends AmazonWebServiceRequest> X applyUserAgent(X request)
  {
    String USER_AGENT = "dynamodb-table-api/" + VersionInfoUtils.getVersion();
    
    request.getRequestClientOptions().appendUserAgent(USER_AGENT);
    return request;
  }
  
  public static void rejectNullValue(Object val)
  {
    ValidationUtils.assertNotNull(val, "val");
  }
  
  public static void rejectNullInput(Object input)
  {
    ValidationUtils.assertNotNull(input, "val");
  }
  
  public static void rejectEmptyInput(Object[] input)
  {
    ValidationUtils.assertNotEmpty(input, "input");
  }
  
  public static void rejectNullOrEmptyInput(Object[] input)
  {
    rejectNullInput(input);
    rejectEmptyInput(input);
  }
  
  public static void checkInvalidAttrName(String attrName)
  {
    ItemUtils.checkInvalidAttrName(attrName);
  }
  
  public static void checkInvalidAttribute(String attrName, Object val)
  {
    ItemUtils.checkInvalidAttribute(attrName, val);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnItemCollectionMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.DeleteItemExpressionSpec;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DeleteItemSpec
  extends AbstractSpecWithPrimaryKey<DeleteItemRequest>
{
  private Collection<Expected> expected;
  private Map<String, String> nameMap;
  private Map<String, Object> valueMap;
  
  public DeleteItemSpec()
  {
    super(new DeleteItemRequest());
  }
  
  public DeleteItemSpec withPrimaryKey(KeyAttribute... components)
  {
    super.withPrimaryKey(components);
    return this;
  }
  
  public DeleteItemSpec withPrimaryKey(PrimaryKey primaryKey)
  {
    super.withPrimaryKey(primaryKey);
    return this;
  }
  
  public DeleteItemSpec withPrimaryKey(String hashKeyName, Object hashKeyValue)
  {
    super.withPrimaryKey(hashKeyName, hashKeyValue);
    return this;
  }
  
  public DeleteItemSpec withPrimaryKey(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    super.withPrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue);
    return this;
  }
  
  public Collection<Expected> getExpected()
  {
    return expected;
  }
  
  public DeleteItemSpec withExpected(Expected... expected)
  {
    if (expected == null)
    {
      this.expected = null;
      return this;
    }
    return withExpected(Arrays.asList(expected));
  }
  
  public DeleteItemSpec withExpected(Collection<Expected> expected)
  {
    if (expected == null)
    {
      this.expected = null;
      return this;
    }
    Set<String> names = new LinkedHashSet();
    for (Expected e : expected) {
      names.add(e.getAttribute());
    }
    if (names.size() != expected.size()) {
      throw new IllegalArgumentException("attribute names must not duplicate in the list of expected");
    }
    this.expected = Collections.unmodifiableCollection(expected);
    return this;
  }
  
  public String getConditionExpression()
  {
    return ((DeleteItemRequest)getRequest()).getConditionExpression();
  }
  
  public DeleteItemSpec withConditionExpression(String conditionExpression)
  {
    ((DeleteItemRequest)getRequest()).setConditionExpression(conditionExpression);
    return this;
  }
  
  public Map<String, String> getNameMap()
  {
    return nameMap;
  }
  
  public DeleteItemSpec withNameMap(Map<String, String> nameMap)
  {
    if (nameMap == null) {
      this.nameMap = null;
    } else {
      this.nameMap = Collections.unmodifiableMap(new LinkedHashMap(nameMap));
    }
    return this;
  }
  
  public Map<String, Object> getValueMap()
  {
    return valueMap;
  }
  
  public DeleteItemSpec withValueMap(Map<String, Object> valueMap)
  {
    if (valueMap == null) {
      this.valueMap = null;
    } else {
      this.valueMap = Collections.unmodifiableMap(new LinkedHashMap(valueMap));
    }
    return this;
  }
  
  public String getConditionalOperator()
  {
    return ((DeleteItemRequest)getRequest()).getConditionalOperator();
  }
  
  public DeleteItemSpec withConditionalOperator(ConditionalOperator conditionalOperator)
  {
    ((DeleteItemRequest)getRequest()).setConditionalOperator(conditionalOperator);
    return this;
  }
  
  public String getReturnConsumedCapacity()
  {
    return ((DeleteItemRequest)getRequest()).getReturnConsumedCapacity();
  }
  
  public DeleteItemSpec withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    ((DeleteItemRequest)getRequest()).setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public String getReturnItemCollectionMetrics()
  {
    return ((DeleteItemRequest)getRequest()).getReturnItemCollectionMetrics();
  }
  
  public DeleteItemSpec withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics)
  {
    ((DeleteItemRequest)getRequest()).setReturnItemCollectionMetrics(returnItemCollectionMetrics);
    return this;
  }
  
  public String getReturnValues()
  {
    return ((DeleteItemRequest)getRequest()).getReturnValues();
  }
  
  public DeleteItemSpec withReturnValues(ReturnValue returnValues)
  {
    ((DeleteItemRequest)getRequest()).setReturnValues(returnValues);
    return this;
  }
  
  public DeleteItemSpec withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    return this;
  }
  
  public DeleteItemSpec withRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    setRequestMetricCollector(requestMetricCollector);
    return this;
  }
  
  @Beta
  public DeleteItemSpec withExpressionSpec(DeleteItemExpressionSpec xspec)
  {
    return 
    
      withConditionExpression(xspec.getConditionExpression()).withNameMap(xspec.getNameMap()).withValueMap(xspec.getValueMap());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
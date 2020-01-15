package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnItemCollectionMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.PutItemExpressionSpec;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class PutItemSpec
  extends AbstractSpec<PutItemRequest>
{
  private Item item;
  private Collection<Expected> expected;
  private Map<String, String> nameMap;
  private Map<String, Object> valueMap;
  
  public PutItemSpec()
  {
    super(new PutItemRequest());
  }
  
  public Item getItem()
  {
    return item;
  }
  
  public PutItemSpec withItem(Item item)
  {
    this.item = item;
    return this;
  }
  
  public Collection<Expected> getExpected()
  {
    return expected;
  }
  
  public PutItemSpec withExpected(Expected... expected)
  {
    if (expected == null)
    {
      this.expected = null;
      return this;
    }
    return withExpected(Arrays.asList(expected));
  }
  
  public PutItemSpec withExpected(Collection<Expected> expected)
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
    return ((PutItemRequest)getRequest()).getConditionExpression();
  }
  
  public PutItemSpec withConditionExpression(String conditionExpression)
  {
    ((PutItemRequest)getRequest()).setConditionExpression(conditionExpression);
    return this;
  }
  
  public Map<String, String> getNameMap()
  {
    return nameMap;
  }
  
  public PutItemSpec withNameMap(Map<String, String> nameMap)
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
  
  public PutItemSpec withValueMap(Map<String, Object> valueMap)
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
    return ((PutItemRequest)getRequest()).getConditionalOperator();
  }
  
  public PutItemSpec withConditionalOperator(ConditionalOperator conditionalOperator)
  {
    ((PutItemRequest)getRequest()).setConditionalOperator(conditionalOperator);
    return this;
  }
  
  public String getReturnConsumedCapacity()
  {
    return ((PutItemRequest)getRequest()).getReturnConsumedCapacity();
  }
  
  public PutItemSpec withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    ((PutItemRequest)getRequest()).setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public String getReturnItemCollectionMetrics()
  {
    return ((PutItemRequest)getRequest()).getReturnItemCollectionMetrics();
  }
  
  public PutItemSpec withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics)
  {
    ((PutItemRequest)getRequest()).setReturnItemCollectionMetrics(returnItemCollectionMetrics);
    return this;
  }
  
  public String getReturnValues()
  {
    return ((PutItemRequest)getRequest()).getReturnValues();
  }
  
  public PutItemSpec withReturnValues(ReturnValue returnValues)
  {
    ((PutItemRequest)getRequest()).setReturnValues(returnValues);
    return this;
  }
  
  public PutItemSpec withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    return this;
  }
  
  public PutItemSpec withRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    setRequestMetricCollector(requestMetricCollector);
    return this;
  }
  
  @Beta
  public PutItemSpec withExpressionSpec(PutItemExpressionSpec xspec)
  {
    return 
    
      withConditionExpression(xspec.getConditionExpression()).withNameMap(xspec.getNameMap()).withValueMap(xspec.getValueMap());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.AttributeUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnItemCollectionMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.UpdateItemExpressionSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UpdateItemSpec
  extends AbstractSpecWithPrimaryKey<UpdateItemRequest>
{
  private List<AttributeUpdate> attributes;
  private Collection<Expected> expected;
  private Map<String, String> nameMap;
  private Map<String, Object> valueMap;
  
  public UpdateItemSpec()
  {
    super(new UpdateItemRequest());
  }
  
  public UpdateItemSpec withPrimaryKey(KeyAttribute... components)
  {
    super.withPrimaryKey(components);
    return this;
  }
  
  public UpdateItemSpec withPrimaryKey(PrimaryKey primaryKey)
  {
    super.withPrimaryKey(primaryKey);
    return this;
  }
  
  public UpdateItemSpec withPrimaryKey(String hashKeyName, Object hashKeyValue)
  {
    super.withPrimaryKey(hashKeyName, hashKeyValue);
    return this;
  }
  
  public UpdateItemSpec withPrimaryKey(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    super.withPrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue);
    return this;
  }
  
  public List<AttributeUpdate> getAttributeUpdate()
  {
    return attributes;
  }
  
  public UpdateItemSpec withAttributeUpdate(List<AttributeUpdate> attributeUpdates)
  {
    attributes = attributeUpdates;
    return this;
  }
  
  public UpdateItemSpec withAttributeUpdate(AttributeUpdate... attributeUpdates)
  {
    attributes = new ArrayList(Arrays.asList(attributeUpdates));
    return this;
  }
  
  public UpdateItemSpec addAttributeUpdate(AttributeUpdate attributeUpdate)
  {
    if (null == attributes) {
      attributes = new ArrayList();
    }
    attributes.add(attributeUpdate);
    return this;
  }
  
  public UpdateItemSpec clearAttributeUpdate()
  {
    attributes = null;
    return this;
  }
  
  public Collection<Expected> getExpected()
  {
    return expected;
  }
  
  public UpdateItemSpec withExpected(Expected... expected)
  {
    if (expected == null)
    {
      this.expected = null;
      return this;
    }
    return withExpected(Arrays.asList(expected));
  }
  
  public UpdateItemSpec withExpected(Collection<Expected> expected)
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
  
  public String getUpdateExpression()
  {
    return ((UpdateItemRequest)getRequest()).getUpdateExpression();
  }
  
  public UpdateItemSpec withUpdateExpression(String updateExpression)
  {
    ((UpdateItemRequest)getRequest()).setUpdateExpression(updateExpression);
    return this;
  }
  
  public String getConditionExpression()
  {
    return ((UpdateItemRequest)getRequest()).getConditionExpression();
  }
  
  public UpdateItemSpec withConditionExpression(String conditionExpression)
  {
    ((UpdateItemRequest)getRequest()).setConditionExpression(conditionExpression);
    return this;
  }
  
  public Map<String, String> getNameMap()
  {
    return nameMap;
  }
  
  public UpdateItemSpec withNameMap(Map<String, String> nameMap)
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
  
  public UpdateItemSpec withValueMap(Map<String, Object> valueMap)
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
    return ((UpdateItemRequest)getRequest()).getConditionalOperator();
  }
  
  public String getReturnConsumedCapacity()
  {
    return ((UpdateItemRequest)getRequest()).getReturnConsumedCapacity();
  }
  
  public UpdateItemSpec withReturnConsumedCapacity(String returnConsumedCapacity)
  {
    ((UpdateItemRequest)getRequest()).setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public UpdateItemSpec withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    ((UpdateItemRequest)getRequest()).setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public String getReturnItemCollectionMetrics()
  {
    return ((UpdateItemRequest)getRequest()).getReturnItemCollectionMetrics();
  }
  
  public UpdateItemSpec withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics)
  {
    ((UpdateItemRequest)getRequest()).setReturnItemCollectionMetrics(returnItemCollectionMetrics);
    return this;
  }
  
  public UpdateItemSpec withReturnItemCollectionMetrics(String returnItemCollectionMetrics)
  {
    ((UpdateItemRequest)getRequest()).setReturnItemCollectionMetrics(returnItemCollectionMetrics);
    return this;
  }
  
  public String getReturnValues()
  {
    return ((UpdateItemRequest)getRequest()).getReturnValues();
  }
  
  public UpdateItemSpec withReturnValues(ReturnValue returnValues)
  {
    ((UpdateItemRequest)getRequest()).setReturnValues(returnValues);
    return this;
  }
  
  public UpdateItemSpec withReturnValues(String returnValues)
  {
    ((UpdateItemRequest)getRequest()).setReturnValues(returnValues);
    return this;
  }
  
  public UpdateItemSpec withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    return this;
  }
  
  public UpdateItemSpec withRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    setRequestMetricCollector(requestMetricCollector);
    return this;
  }
  
  @Beta
  public UpdateItemSpec withExpressionSpec(UpdateItemExpressionSpec xspec)
  {
    return 
    
      withUpdateExpression(xspec.getUpdateExpression()).withConditionExpression(xspec.getConditionExpression()).withNameMap(xspec.getNameMap()).withValueMap(xspec.getValueMap());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
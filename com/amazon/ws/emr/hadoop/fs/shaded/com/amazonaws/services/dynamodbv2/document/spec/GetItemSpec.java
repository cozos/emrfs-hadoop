package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.GetItemExpressionSpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GetItemSpec
  extends AbstractSpecWithPrimaryKey<GetItemRequest>
{
  private Map<String, String> nameMap;
  
  public GetItemSpec()
  {
    super(new GetItemRequest());
  }
  
  public GetItemSpec withPrimaryKey(KeyAttribute... components)
  {
    super.withPrimaryKey(components);
    return this;
  }
  
  public GetItemSpec withPrimaryKey(PrimaryKey primaryKey)
  {
    super.withPrimaryKey(primaryKey);
    return this;
  }
  
  public GetItemSpec withPrimaryKey(String hashKeyName, Object hashKeyValue)
  {
    super.withPrimaryKey(hashKeyName, hashKeyValue);
    return this;
  }
  
  public GetItemSpec withPrimaryKey(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    super.withPrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue);
    return this;
  }
  
  public String getReturnConsumedCapacity()
  {
    return ((GetItemRequest)getRequest()).getReturnConsumedCapacity();
  }
  
  public GetItemSpec withReturnConsumedCapacity(ReturnConsumedCapacity capacity)
  {
    ((GetItemRequest)getRequest()).setReturnConsumedCapacity(capacity);
    return this;
  }
  
  public List<String> getAttributesToGet()
  {
    return ((GetItemRequest)getRequest()).getAttributesToGet();
  }
  
  public GetItemSpec withAttributesToGet(String... attrNames)
  {
    if (attrNames == null) {
      ((GetItemRequest)getRequest()).setAttributesToGet(null);
    } else {
      ((GetItemRequest)getRequest()).setAttributesToGet(Arrays.asList(attrNames));
    }
    return this;
  }
  
  public Boolean isConsistentRead()
  {
    return ((GetItemRequest)getRequest()).isConsistentRead();
  }
  
  public GetItemSpec withConsistentRead(boolean consistentRead)
  {
    ((GetItemRequest)getRequest()).setConsistentRead(Boolean.valueOf(consistentRead));
    return this;
  }
  
  public String getProjectionExpression()
  {
    return ((GetItemRequest)getRequest()).getProjectionExpression();
  }
  
  public GetItemSpec withProjectionExpression(String projectionExpression)
  {
    ((GetItemRequest)getRequest()).setProjectionExpression(projectionExpression);
    return this;
  }
  
  public Map<String, String> getNameMap()
  {
    return nameMap;
  }
  
  public GetItemSpec withNameMap(Map<String, String> nameMap)
  {
    if (nameMap == null) {
      this.nameMap = null;
    } else {
      this.nameMap = Collections.unmodifiableMap(new LinkedHashMap(nameMap));
    }
    return this;
  }
  
  public GetItemSpec withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    return this;
  }
  
  public GetItemSpec withRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    setRequestMetricCollector(requestMetricCollector);
    return this;
  }
  
  @Beta
  public GetItemSpec withExpressionSpec(GetItemExpressionSpec xspec)
  {
    return 
      withProjectionExpression(xspec.getProjectionExpression()).withNameMap(xspec.getNameMap());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.QueryFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.RangeKeyCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Select;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.QueryExpressionSpec;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QuerySpec
  extends AbstractCollectionSpec<QueryRequest>
{
  private KeyAttribute hashKey;
  private RangeKeyCondition rangeKeyCondition;
  private Collection<QueryFilter> queryFilters;
  private Map<String, String> nameMap;
  private Map<String, Object> valueMap;
  private Collection<KeyAttribute> exclusiveStartKey;
  
  public QuerySpec()
  {
    super(new QueryRequest());
  }
  
  public KeyAttribute getHashKey()
  {
    return hashKey;
  }
  
  public QuerySpec withHashKey(KeyAttribute hashKey)
  {
    this.hashKey = hashKey;
    return this;
  }
  
  public QuerySpec withHashKey(String hashKeyName, Object hashKeyValue)
  {
    hashKey = new KeyAttribute(hashKeyName, hashKeyValue);
    return this;
  }
  
  public RangeKeyCondition getRangeKeyCondition()
  {
    return rangeKeyCondition;
  }
  
  public QuerySpec withRangeKeyCondition(RangeKeyCondition rangeKeyCondition)
  {
    this.rangeKeyCondition = rangeKeyCondition;
    return this;
  }
  
  public QuerySpec withKeyConditionExpression(String keyConditionExpression)
  {
    ((QueryRequest)getRequest()).withKeyConditionExpression(keyConditionExpression);
    return this;
  }
  
  public String getKeyConditionExpression()
  {
    return ((QueryRequest)getRequest()).getKeyConditionExpression();
  }
  
  public QuerySpec withAttributesToGet(String... attributes)
  {
    ((QueryRequest)getRequest()).withAttributesToGet(Arrays.asList(attributes));
    return this;
  }
  
  public List<String> getAttributesToGet()
  {
    return ((QueryRequest)getRequest()).getAttributesToGet();
  }
  
  public QuerySpec withConditionalOperator(ConditionalOperator op)
  {
    ((QueryRequest)getRequest()).withConditionalOperator(op);
    return this;
  }
  
  public String getConditionalOperator()
  {
    return ((QueryRequest)getRequest()).getConditionalOperator();
  }
  
  public QuerySpec withConsistentRead(boolean consistentRead)
  {
    ((QueryRequest)getRequest()).setConsistentRead(Boolean.valueOf(consistentRead));
    return this;
  }
  
  public boolean isConsistentRead()
  {
    return ((QueryRequest)getRequest()).isConsistentRead().booleanValue();
  }
  
  public QuerySpec withQueryFilters(QueryFilter... queryFilters)
  {
    if (queryFilters == null)
    {
      this.queryFilters = null;
    }
    else
    {
      Set<String> names = new LinkedHashSet();
      for (QueryFilter e : queryFilters) {
        names.add(e.getAttribute());
      }
      if (names.size() != queryFilters.length) {
        throw new IllegalArgumentException("attribute names must not duplicate in the list of query filters");
      }
      this.queryFilters = Arrays.asList(queryFilters);
    }
    return this;
  }
  
  public Collection<QueryFilter> getQueryFilters()
  {
    return queryFilters;
  }
  
  public QuerySpec withFilterExpression(String filterExpression)
  {
    ((QueryRequest)getRequest()).withFilterExpression(filterExpression);
    return this;
  }
  
  public String getFilterExpression()
  {
    return ((QueryRequest)getRequest()).getFilterExpression();
  }
  
  public QuerySpec withProjectionExpression(String projectionExpression)
  {
    ((QueryRequest)getRequest()).withProjectionExpression(projectionExpression);
    return this;
  }
  
  public String getProjectionExpression()
  {
    return ((QueryRequest)getRequest()).getProjectionExpression();
  }
  
  public Map<String, String> getNameMap()
  {
    return nameMap;
  }
  
  public QuerySpec withNameMap(Map<String, String> nameMap)
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
  
  public QuerySpec withValueMap(Map<String, Object> valueMap)
  {
    if (valueMap == null) {
      this.valueMap = null;
    } else {
      this.valueMap = Collections.unmodifiableMap(new LinkedHashMap(valueMap));
    }
    return this;
  }
  
  public String getReturnConsumedCapacity()
  {
    return ((QueryRequest)getRequest()).getReturnConsumedCapacity();
  }
  
  public QuerySpec withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity)
  {
    ((QueryRequest)getRequest()).setReturnConsumedCapacity(returnConsumedCapacity);
    return this;
  }
  
  public QuerySpec withScanIndexForward(boolean scanIndexForward)
  {
    ((QueryRequest)getRequest()).withScanIndexForward(Boolean.valueOf(scanIndexForward));
    return this;
  }
  
  public boolean isScanIndexForward()
  {
    return ((QueryRequest)getRequest()).isScanIndexForward().booleanValue();
  }
  
  public QuerySpec withSelect(Select select)
  {
    ((QueryRequest)getRequest()).withSelect(select);
    return this;
  }
  
  public String getSelect()
  {
    return ((QueryRequest)getRequest()).getSelect();
  }
  
  public Collection<KeyAttribute> getExclusiveStartKey()
  {
    return exclusiveStartKey;
  }
  
  public QuerySpec withExclusiveStartKey(KeyAttribute... exclusiveStartKey)
  {
    if (exclusiveStartKey == null) {
      this.exclusiveStartKey = null;
    } else {
      this.exclusiveStartKey = Arrays.asList(exclusiveStartKey);
    }
    return this;
  }
  
  public QuerySpec withExclusiveStartKey(PrimaryKey exclusiveStartKey)
  {
    if (exclusiveStartKey == null) {
      this.exclusiveStartKey = null;
    } else {
      this.exclusiveStartKey = exclusiveStartKey.getComponents();
    }
    return this;
  }
  
  public QuerySpec withExclusiveStartKey(String hashKeyName, Object hashKeyValue)
  {
    return withExclusiveStartKey(new KeyAttribute[] { new KeyAttribute(hashKeyName, hashKeyValue) });
  }
  
  public QuerySpec withExclusiveStartKey(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    return withExclusiveStartKey(new KeyAttribute[] { new KeyAttribute(hashKeyName, hashKeyValue), new KeyAttribute(rangeKeyName, rangeKeyValue) });
  }
  
  public QuerySpec withMaxResultSize(Integer maxResultSize)
  {
    setMaxResultSize(maxResultSize);
    return this;
  }
  
  public QuerySpec withMaxResultSize(int maxResultSize)
  {
    setMaxResultSize(maxResultSize);
    return this;
  }
  
  public QuerySpec withMaxPageSize(Integer maxPageSize)
  {
    setMaxPageSize(maxPageSize);
    return this;
  }
  
  public QuerySpec withMaxPageSize(int maxPageSize)
  {
    setMaxPageSize(Integer.valueOf(maxPageSize));
    return this;
  }
  
  public QuerySpec withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    return this;
  }
  
  public QuerySpec withRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    setRequestMetricCollector(requestMetricCollector);
    return this;
  }
  
  @Beta
  public QuerySpec withExpressionSpec(QueryExpressionSpec xspec)
  {
    return 
    
      withKeyConditionExpression(xspec.getKeyConditionExpression()).withFilterExpression(xspec.getFilterExpression()).withProjectionExpression(xspec.getProjectionExpression()).withNameMap(xspec.getNameMap()).withValueMap(xspec.getValueMap());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.QuerySpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
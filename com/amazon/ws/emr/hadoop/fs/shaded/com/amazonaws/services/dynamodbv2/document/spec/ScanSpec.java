package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ScanFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Select;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.ScanExpressionSpec;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScanSpec
  extends AbstractCollectionSpec<ScanRequest>
{
  private Collection<ScanFilter> scanFilters;
  private Map<String, String> nameMap;
  private Map<String, Object> valueMap;
  private Collection<KeyAttribute> exclusiveStartKey;
  
  public ScanSpec()
  {
    super(new ScanRequest());
  }
  
  public Collection<ScanFilter> getScanFilters()
  {
    return scanFilters;
  }
  
  public ScanSpec withScanFilters(ScanFilter... scanFilters)
  {
    if (scanFilters == null)
    {
      this.scanFilters = null;
    }
    else
    {
      Set<String> names = new LinkedHashSet();
      for (ScanFilter e : scanFilters) {
        names.add(e.getAttribute());
      }
      if (names.size() != scanFilters.length) {
        throw new IllegalArgumentException("attribute names must not duplicate in the list of scan filters");
      }
      this.scanFilters = Arrays.asList(scanFilters);
    }
    return this;
  }
  
  public String getConditionalOperator()
  {
    return ((ScanRequest)getRequest()).getConditionalOperator();
  }
  
  public ScanSpec withConditionalOperator(ConditionalOperator op)
  {
    ((ScanRequest)getRequest()).setConditionalOperator(op);
    return this;
  }
  
  public List<String> getAttributesToGet()
  {
    return ((ScanRequest)getRequest()).getAttributesToGet();
  }
  
  public ScanSpec withAttributesToGet(String... attributes)
  {
    if (attributes == null) {
      ((ScanRequest)getRequest()).setAttributesToGet(null);
    } else {
      ((ScanRequest)getRequest()).setAttributesToGet(Arrays.asList(attributes));
    }
    return this;
  }
  
  public String getFilterExpression()
  {
    return ((ScanRequest)getRequest()).getFilterExpression();
  }
  
  public ScanSpec withFilterExpression(String filterExpression)
  {
    ((ScanRequest)getRequest()).setFilterExpression(filterExpression);
    return this;
  }
  
  public String getProjectionExpression()
  {
    return ((ScanRequest)getRequest()).getProjectionExpression();
  }
  
  public ScanSpec withProjectionExpression(String projectionExpression)
  {
    ((ScanRequest)getRequest()).setProjectionExpression(projectionExpression);
    return this;
  }
  
  public Map<String, String> getNameMap()
  {
    return nameMap;
  }
  
  public ScanSpec withNameMap(Map<String, String> nameMap)
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
  
  public ScanSpec withValueMap(Map<String, Object> valueMap)
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
    return ((ScanRequest)getRequest()).getReturnConsumedCapacity();
  }
  
  public ScanSpec withReturnConsumedCapacity(ReturnConsumedCapacity capacity)
  {
    ((ScanRequest)getRequest()).setReturnConsumedCapacity(capacity);
    return this;
  }
  
  public String getSelect()
  {
    return ((ScanRequest)getRequest()).getSelect();
  }
  
  public ScanSpec withSelect(Select select)
  {
    ((ScanRequest)getRequest()).setSelect(select);
    return this;
  }
  
  public Integer getSegment()
  {
    return ((ScanRequest)getRequest()).getSegment();
  }
  
  public ScanSpec withSegment(Integer segment)
  {
    ((ScanRequest)getRequest()).setSegment(segment);
    return this;
  }
  
  public Integer getTotalSegments()
  {
    return ((ScanRequest)getRequest()).getTotalSegments();
  }
  
  public ScanSpec withTotalSegments(Integer totalSegments)
  {
    ((ScanRequest)getRequest()).setTotalSegments(totalSegments);
    return this;
  }
  
  public Boolean isConsistentRead()
  {
    return ((ScanRequest)getRequest()).isConsistentRead();
  }
  
  public ScanSpec withConsistentRead(Boolean consistentRead)
  {
    ((ScanRequest)getRequest()).withConsistentRead(consistentRead);
    return this;
  }
  
  public Collection<KeyAttribute> getExclusiveStartKey()
  {
    return exclusiveStartKey;
  }
  
  public ScanSpec withExclusiveStartKey(KeyAttribute... exclusiveStartKey)
  {
    if (exclusiveStartKey == null) {
      this.exclusiveStartKey = null;
    } else {
      this.exclusiveStartKey = Arrays.asList(exclusiveStartKey);
    }
    return this;
  }
  
  public ScanSpec withExclusiveStartKey(PrimaryKey exclusiveStartKey)
  {
    if (exclusiveStartKey == null) {
      this.exclusiveStartKey = null;
    } else {
      this.exclusiveStartKey = exclusiveStartKey.getComponents();
    }
    return this;
  }
  
  public ScanSpec withExclusiveStartKey(String hashKeyName, Object hashKeyValue)
  {
    return withExclusiveStartKey(new KeyAttribute[] { new KeyAttribute(hashKeyName, hashKeyValue) });
  }
  
  public ScanSpec withExclusiveStartKey(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    return withExclusiveStartKey(new KeyAttribute[] { new KeyAttribute(hashKeyName, hashKeyValue), new KeyAttribute(rangeKeyName, rangeKeyValue) });
  }
  
  public ScanSpec withMaxResultSize(Integer maxResultSize)
  {
    setMaxResultSize(maxResultSize);
    return this;
  }
  
  public ScanSpec withMaxResultSize(int maxResultSize)
  {
    setMaxResultSize(maxResultSize);
    return this;
  }
  
  public ScanSpec withMaxPageSize(Integer maxPageSize)
  {
    setMaxPageSize(maxPageSize);
    return this;
  }
  
  public ScanSpec withMaxPageSize(int maxPageSize)
  {
    setMaxPageSize(Integer.valueOf(maxPageSize));
    return this;
  }
  
  public ScanSpec withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    return this;
  }
  
  public ScanSpec withRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    setRequestMetricCollector(requestMetricCollector);
    return this;
  }
  
  @Beta
  public ScanSpec withExpressionSpec(ScanExpressionSpec xspec)
  {
    return 
    
      withFilterExpression(xspec.getFilterExpression()).withProjectionExpression(xspec.getProjectionExpression()).withNameMap(xspec.getNameMap()).withValueMap(xspec.getValueMap());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ScanSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
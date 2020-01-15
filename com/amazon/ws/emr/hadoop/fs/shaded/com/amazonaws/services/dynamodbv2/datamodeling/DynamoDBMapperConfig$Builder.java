package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;

public class DynamoDBMapperConfig$Builder
{
  private DynamoDBMapperConfig.SaveBehavior saveBehavior;
  private DynamoDBMapperConfig.ConsistentReads consistentReads;
  private DynamoDBMapperConfig.TableNameOverride tableNameOverride;
  private DynamoDBMapperConfig.TableNameResolver tableNameResolver;
  private DynamoDBMapperConfig.ObjectTableNameResolver objectTableNameResolver;
  private DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy;
  private RequestMetricCollector requestMetricCollector;
  private ConversionSchema conversionSchema;
  private DynamoDBMapperConfig.BatchWriteRetryStrategy batchWriteRetryStrategy;
  private DynamoDBMapperConfig.BatchLoadRetryStrategy batchLoadRetryStrategy;
  private DynamoDBTypeConverterFactory typeConverterFactory;
  
  public DynamoDBMapperConfig$Builder()
  {
    this(true);
  }
  
  private DynamoDBMapperConfig$Builder(boolean defaults)
  {
    if (defaults == true)
    {
      saveBehavior = DynamoDBMapperConfig.DEFAULT.getSaveBehavior();
      consistentReads = DynamoDBMapperConfig.DEFAULT.getConsistentReads();
      paginationLoadingStrategy = DynamoDBMapperConfig.DEFAULT.getPaginationLoadingStrategy();
      conversionSchema = DynamoDBMapperConfig.DEFAULT.getConversionSchema();
      batchWriteRetryStrategy = DynamoDBMapperConfig.DEFAULT.getBatchWriteRetryStrategy();
      batchLoadRetryStrategy = DynamoDBMapperConfig.DEFAULT.getBatchLoadRetryStrategy();
    }
  }
  
  private final Builder merge(DynamoDBMapperConfig o)
  {
    if (o == null) {
      return this;
    }
    if (DynamoDBMapperConfig.access$100(o) != null) {
      saveBehavior = DynamoDBMapperConfig.access$100(o);
    }
    if (DynamoDBMapperConfig.access$200(o) != null) {
      consistentReads = DynamoDBMapperConfig.access$200(o);
    }
    if (DynamoDBMapperConfig.access$300(o) != null) {
      tableNameOverride = DynamoDBMapperConfig.access$300(o);
    }
    if (DynamoDBMapperConfig.access$400(o) != null) {
      tableNameResolver = DynamoDBMapperConfig.access$400(o);
    }
    if (DynamoDBMapperConfig.access$500(o) != null) {
      objectTableNameResolver = DynamoDBMapperConfig.access$500(o);
    }
    if (DynamoDBMapperConfig.access$600(o) != null) {
      paginationLoadingStrategy = DynamoDBMapperConfig.access$600(o);
    }
    if (DynamoDBMapperConfig.access$700(o) != null) {
      requestMetricCollector = DynamoDBMapperConfig.access$700(o);
    }
    if (DynamoDBMapperConfig.access$800(o) != null) {
      conversionSchema = DynamoDBMapperConfig.access$800(o);
    }
    if (DynamoDBMapperConfig.access$900(o) != null) {
      batchWriteRetryStrategy = DynamoDBMapperConfig.access$900(o);
    }
    if (DynamoDBMapperConfig.access$1000(o) != null) {
      batchLoadRetryStrategy = DynamoDBMapperConfig.access$1000(o);
    }
    if (DynamoDBMapperConfig.access$1100(o) != null) {
      typeConverterFactory = DynamoDBMapperConfig.access$1100(o);
    }
    return this;
  }
  
  public DynamoDBMapperConfig.SaveBehavior getSaveBehavior()
  {
    return saveBehavior;
  }
  
  public void setSaveBehavior(DynamoDBMapperConfig.SaveBehavior value)
  {
    saveBehavior = value;
  }
  
  public Builder withSaveBehavior(DynamoDBMapperConfig.SaveBehavior value)
  {
    setSaveBehavior(value);
    return this;
  }
  
  public DynamoDBMapperConfig.ConsistentReads getConsistentReads()
  {
    return consistentReads;
  }
  
  public void setConsistentReads(DynamoDBMapperConfig.ConsistentReads value)
  {
    consistentReads = value;
  }
  
  public Builder withConsistentReads(DynamoDBMapperConfig.ConsistentReads value)
  {
    setConsistentReads(value);
    return this;
  }
  
  public DynamoDBMapperConfig.TableNameOverride getTableNameOverride()
  {
    return tableNameOverride;
  }
  
  public void setTableNameOverride(DynamoDBMapperConfig.TableNameOverride value)
  {
    tableNameOverride = value;
  }
  
  public Builder withTableNameOverride(DynamoDBMapperConfig.TableNameOverride value)
  {
    setTableNameOverride(value);
    return this;
  }
  
  public DynamoDBMapperConfig.TableNameResolver getTableNameResolver()
  {
    return tableNameResolver;
  }
  
  public void setTableNameResolver(DynamoDBMapperConfig.TableNameResolver value)
  {
    tableNameResolver = value;
  }
  
  public Builder withTableNameResolver(DynamoDBMapperConfig.TableNameResolver value)
  {
    setTableNameResolver(value);
    return this;
  }
  
  public DynamoDBMapperConfig.ObjectTableNameResolver getObjectTableNameResolver()
  {
    return objectTableNameResolver;
  }
  
  public void setObjectTableNameResolver(DynamoDBMapperConfig.ObjectTableNameResolver value)
  {
    objectTableNameResolver = value;
  }
  
  public Builder withObjectTableNameResolver(DynamoDBMapperConfig.ObjectTableNameResolver value)
  {
    setObjectTableNameResolver(value);
    return this;
  }
  
  public DynamoDBMapperConfig.PaginationLoadingStrategy getPaginationLoadingStrategy()
  {
    return paginationLoadingStrategy;
  }
  
  public void setPaginationLoadingStrategy(DynamoDBMapperConfig.PaginationLoadingStrategy value)
  {
    paginationLoadingStrategy = value;
  }
  
  public Builder withPaginationLoadingStrategy(DynamoDBMapperConfig.PaginationLoadingStrategy value)
  {
    setPaginationLoadingStrategy(value);
    return this;
  }
  
  public RequestMetricCollector getRequestMetricCollector()
  {
    return requestMetricCollector;
  }
  
  public void setRequestMetricCollector(RequestMetricCollector value)
  {
    requestMetricCollector = value;
  }
  
  public Builder withRequestMetricCollector(RequestMetricCollector value)
  {
    setRequestMetricCollector(value);
    return this;
  }
  
  public ConversionSchema getConversionSchema()
  {
    return conversionSchema;
  }
  
  public void setConversionSchema(ConversionSchema value)
  {
    conversionSchema = value;
  }
  
  public Builder withConversionSchema(ConversionSchema value)
  {
    setConversionSchema(value);
    return this;
  }
  
  public DynamoDBMapperConfig.BatchWriteRetryStrategy getBatchWriteRetryStrategy()
  {
    return batchWriteRetryStrategy;
  }
  
  public void setBatchWriteRetryStrategy(DynamoDBMapperConfig.BatchWriteRetryStrategy value)
  {
    batchWriteRetryStrategy = value;
  }
  
  public Builder withBatchWriteRetryStrategy(DynamoDBMapperConfig.BatchWriteRetryStrategy value)
  {
    setBatchWriteRetryStrategy(value);
    return this;
  }
  
  public DynamoDBMapperConfig.BatchLoadRetryStrategy getBatchLoadRetryStrategy()
  {
    return batchLoadRetryStrategy;
  }
  
  public void setBatchLoadRetryStrategy(DynamoDBMapperConfig.BatchLoadRetryStrategy value)
  {
    batchLoadRetryStrategy = value;
  }
  
  public Builder withBatchLoadRetryStrategy(DynamoDBMapperConfig.BatchLoadRetryStrategy value)
  {
    if (value == null) {
      value = DynamoDBMapperConfig.NoRetryBatchLoadRetryStrategy.INSTANCE;
    }
    setBatchLoadRetryStrategy(value);
    return this;
  }
  
  public final DynamoDBTypeConverterFactory getTypeConverterFactory()
  {
    return typeConverterFactory;
  }
  
  public final void setTypeConverterFactory(DynamoDBTypeConverterFactory value)
  {
    typeConverterFactory = value;
  }
  
  public final Builder withTypeConverterFactory(DynamoDBTypeConverterFactory value)
  {
    setTypeConverterFactory(value);
    return this;
  }
  
  public DynamoDBMapperConfig build()
  {
    return new DynamoDBMapperConfig(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
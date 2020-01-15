package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DynamoDBMapperConfig
{
  public static final DynamoDBMapperConfig DEFAULT = builder()
    .withSaveBehavior(SaveBehavior.UPDATE)
    .withConsistentReads(ConsistentReads.EVENTUAL)
    .withPaginationLoadingStrategy(PaginationLoadingStrategy.LAZY_LOADING)
    .withTableNameResolver(DefaultTableNameResolver.INSTANCE)
    .withBatchWriteRetryStrategy(DefaultBatchWriteRetryStrategy.INSTANCE)
    .withBatchLoadRetryStrategy(DefaultBatchLoadRetryStrategy.INSTANCE)
    .withTypeConverterFactory(DynamoDBTypeConverterFactory.standard())
    .withConversionSchema(ConversionSchemas.DEFAULT)
    .build();
  private final SaveBehavior saveBehavior;
  private final ConsistentReads consistentReads;
  private final TableNameOverride tableNameOverride;
  private final TableNameResolver tableNameResolver;
  private final ObjectTableNameResolver objectTableNameResolver;
  private final PaginationLoadingStrategy paginationLoadingStrategy;
  private final RequestMetricCollector requestMetricCollector;
  private final ConversionSchema conversionSchema;
  private final BatchWriteRetryStrategy batchWriteRetryStrategy;
  private final BatchLoadRetryStrategy batchLoadRetryStrategy;
  private final DynamoDBTypeConverterFactory typeConverterFactory;
  
  public static final Builder builder()
  {
    return new Builder(false, null);
  }
  
  public static class Builder
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
    
    public Builder()
    {
      this(true);
    }
    
    private Builder(boolean defaults)
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
      if (saveBehavior != null) {
        saveBehavior = saveBehavior;
      }
      if (consistentReads != null) {
        consistentReads = consistentReads;
      }
      if (tableNameOverride != null) {
        tableNameOverride = tableNameOverride;
      }
      if (tableNameResolver != null) {
        tableNameResolver = tableNameResolver;
      }
      if (objectTableNameResolver != null) {
        objectTableNameResolver = objectTableNameResolver;
      }
      if (paginationLoadingStrategy != null) {
        paginationLoadingStrategy = paginationLoadingStrategy;
      }
      if (requestMetricCollector != null) {
        requestMetricCollector = requestMetricCollector;
      }
      if (conversionSchema != null) {
        conversionSchema = conversionSchema;
      }
      if (batchWriteRetryStrategy != null) {
        batchWriteRetryStrategy = batchWriteRetryStrategy;
      }
      if (batchLoadRetryStrategy != null) {
        batchLoadRetryStrategy = batchLoadRetryStrategy;
      }
      if (typeConverterFactory != null) {
        typeConverterFactory = typeConverterFactory;
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
  
  public static enum SaveBehavior
  {
    UPDATE,  UPDATE_SKIP_NULL_ATTRIBUTES,  CLOBBER,  PUT,  APPEND_SET;
    
    private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withSaveBehavior(this).build();
    
    private SaveBehavior() {}
    
    public final DynamoDBMapperConfig config()
    {
      return config;
    }
  }
  
  public static enum ConsistentReads
  {
    CONSISTENT,  EVENTUAL;
    
    private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withConsistentReads(this).build();
    
    private ConsistentReads() {}
    
    public final DynamoDBMapperConfig config()
    {
      return config;
    }
  }
  
  public static enum PaginationLoadingStrategy
  {
    LAZY_LOADING,  ITERATION_ONLY,  EAGER_LOADING;
    
    private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withPaginationLoadingStrategy(this).build();
    
    private PaginationLoadingStrategy() {}
    
    public final DynamoDBMapperConfig config()
    {
      return config;
    }
  }
  
  public static final class TableNameOverride
  {
    private final String tableNameOverride;
    private final String tableNamePrefix;
    
    public static TableNameOverride withTableNamePrefix(String tableNamePrefix)
    {
      return new TableNameOverride(null, tableNamePrefix);
    }
    
    public static TableNameOverride withTableNameReplacement(String tableNameReplacement)
    {
      return new TableNameOverride(tableNameReplacement, null);
    }
    
    private TableNameOverride(String tableNameOverride, String tableNamePrefix)
    {
      this.tableNameOverride = tableNameOverride;
      this.tableNamePrefix = tableNamePrefix;
    }
    
    public TableNameOverride(String tableNameOverride)
    {
      this(tableNameOverride, null);
    }
    
    public String getTableName()
    {
      return tableNameOverride;
    }
    
    public String getTableNamePrefix()
    {
      return tableNamePrefix;
    }
    
    private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withTableNameOverride(this).build();
    
    public final DynamoDBMapperConfig config()
    {
      return config;
    }
  }
  
  public static abstract interface TableNameResolver
  {
    public abstract String getTableName(Class<?> paramClass, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  }
  
  public static abstract interface ObjectTableNameResolver
  {
    public abstract String getTableName(Object paramObject, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  }
  
  public static class DefaultTableNameResolver
    implements DynamoDBMapperConfig.TableNameResolver
  {
    public static final DefaultTableNameResolver INSTANCE = new DefaultTableNameResolver();
    
    public String getTableName(Class<?> clazz, DynamoDBMapperConfig config)
    {
      DynamoDBMapperConfig.TableNameOverride override = config.getTableNameOverride();
      if (override != null)
      {
        String tableName = override.getTableName();
        if (tableName != null) {
          return tableName;
        }
      }
      StandardBeanProperties.Beans<?> beans = StandardBeanProperties.of(clazz);
      if (beans.properties().tableName() == null) {
        throw new DynamoDBMappingException(clazz + " not annotated with @DynamoDBTable");
      }
      String prefix = override == null ? null : override.getTableNamePrefix();
      return prefix + beans.properties().tableName();
    }
    
    private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withTableNameResolver(this).build();
    
    public final DynamoDBMapperConfig config()
    {
      return config;
    }
  }
  
  public static abstract interface BatchWriteRetryStrategy
  {
    public abstract int getMaxRetryOnUnprocessedItems(Map<String, List<WriteRequest>> paramMap);
    
    public abstract long getDelayBeforeRetryUnprocessedItems(Map<String, List<WriteRequest>> paramMap, int paramInt);
  }
  
  public static abstract interface BatchLoadRetryStrategy
  {
    public abstract boolean shouldRetry(BatchLoadContext paramBatchLoadContext);
    
    public abstract long getDelayBeforeNextRetry(BatchLoadContext paramBatchLoadContext);
  }
  
  public static class NoRetryBatchLoadRetryStrategy
    implements DynamoDBMapperConfig.BatchLoadRetryStrategy
  {
    public static final NoRetryBatchLoadRetryStrategy INSTANCE = new NoRetryBatchLoadRetryStrategy();
    
    public boolean shouldRetry(BatchLoadContext batchLoadContext)
    {
      return false;
    }
    
    public long getDelayBeforeNextRetry(BatchLoadContext batchLoadContext)
    {
      return -1L;
    }
    
    private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withBatchLoadRetryStrategy(this).build();
    
    public final DynamoDBMapperConfig config()
    {
      return config;
    }
  }
  
  public static class DefaultBatchLoadRetryStrategy
    implements DynamoDBMapperConfig.BatchLoadRetryStrategy
  {
    public static final DefaultBatchLoadRetryStrategy INSTANCE = new DefaultBatchLoadRetryStrategy();
    private static final int MAX_RETRIES = 5;
    private static final long MAX_BACKOFF_IN_MILLISECONDS = 3000L;
    
    public long getDelayBeforeNextRetry(BatchLoadContext batchLoadContext)
    {
      Map<String, KeysAndAttributes> requestedKeys = batchLoadContext.getBatchGetItemRequest().getRequestItems();
      
      Map<String, KeysAndAttributes> unprocessedKeys = batchLoadContext.getBatchGetItemResult().getUnprocessedKeys();
      
      long delay = 0L;
      if ((unprocessedKeys != null) && (requestedKeys != null) && (unprocessedKeys.size() == requestedKeys.size()))
      {
        Random random = new Random();
        long scaleFactor = 500 + random.nextInt(100);
        int retriesAttempted = batchLoadContext.getRetriesAttempted();
        delay = (Math.pow(2.0D, retriesAttempted) * scaleFactor);
        delay = Math.min(delay, 3000L);
      }
      return delay;
    }
    
    public boolean shouldRetry(BatchLoadContext batchLoadContext)
    {
      Map<String, KeysAndAttributes> unprocessedKeys = batchLoadContext.getBatchGetItemResult().getUnprocessedKeys();
      return (unprocessedKeys != null) && (unprocessedKeys.size() > 0) && (batchLoadContext.getRetriesAttempted() < 5);
    }
    
    private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withBatchLoadRetryStrategy(this).build();
    
    public final DynamoDBMapperConfig config()
    {
      return config;
    }
  }
  
  public static class DefaultBatchWriteRetryStrategy
    implements DynamoDBMapperConfig.BatchWriteRetryStrategy
  {
    public static final DefaultBatchWriteRetryStrategy INSTANCE = new DefaultBatchWriteRetryStrategy();
    private static final long MAX_BACKOFF_IN_MILLISECONDS = 3000L;
    private static final int DEFAULT_MAX_RETRY = -1;
    private final int maxRetry;
    
    public DefaultBatchWriteRetryStrategy()
    {
      this(-1);
    }
    
    public DefaultBatchWriteRetryStrategy(int maxRetry)
    {
      this.maxRetry = maxRetry;
    }
    
    public int getMaxRetryOnUnprocessedItems(Map<String, List<WriteRequest>> batchWriteItemInput)
    {
      return maxRetry;
    }
    
    public long getDelayBeforeRetryUnprocessedItems(Map<String, List<WriteRequest>> unprocessedItems, int retriesAttempted)
    {
      if (retriesAttempted < 0) {
        return 0L;
      }
      Random random = new Random();
      long scaleFactor = 1000 + random.nextInt(200);
      long delay = (Math.pow(2.0D, retriesAttempted) * scaleFactor);
      return Math.min(delay, 3000L);
    }
    
    private final DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withBatchWriteRetryStrategy(this).build();
    
    public final DynamoDBMapperConfig config()
    {
      return config;
    }
  }
  
  private DynamoDBMapperConfig(Builder builder)
  {
    saveBehavior = saveBehavior;
    consistentReads = consistentReads;
    tableNameOverride = tableNameOverride;
    tableNameResolver = tableNameResolver;
    objectTableNameResolver = objectTableNameResolver;
    paginationLoadingStrategy = paginationLoadingStrategy;
    requestMetricCollector = requestMetricCollector;
    conversionSchema = conversionSchema;
    batchWriteRetryStrategy = batchWriteRetryStrategy;
    batchLoadRetryStrategy = batchLoadRetryStrategy;
    typeConverterFactory = typeConverterFactory;
  }
  
  final DynamoDBMapperConfig merge(DynamoDBMapperConfig overrides)
  {
    return (overrides == null) || (this == overrides) ? this : Builder.access$2400(builder(), this).merge(overrides).build();
  }
  
  @Deprecated
  public DynamoDBMapperConfig(SaveBehavior saveBehavior, ConsistentReads consistentReads, TableNameOverride tableNameOverride)
  {
    this(saveBehavior, consistentReads, tableNameOverride, null, null);
  }
  
  @Deprecated
  public DynamoDBMapperConfig(SaveBehavior saveBehavior, ConsistentReads consistentReads, TableNameOverride tableNameOverride, PaginationLoadingStrategy paginationLoadingStrategy)
  {
    this(saveBehavior, consistentReads, tableNameOverride, paginationLoadingStrategy, null);
  }
  
  @Deprecated
  public DynamoDBMapperConfig(SaveBehavior saveBehavior, ConsistentReads consistentReads, TableNameOverride tableNameOverride, PaginationLoadingStrategy paginationLoadingStrategy, RequestMetricCollector requestMetricCollector)
  {
    this(saveBehavior, consistentReads, tableNameOverride, null, null, paginationLoadingStrategy, requestMetricCollector, DEFAULT
    
      .getConversionSchema(), DEFAULT
      .getBatchWriteRetryStrategy(), DEFAULT
      .getBatchLoadRetryStrategy());
  }
  
  private DynamoDBMapperConfig(SaveBehavior saveBehavior, ConsistentReads consistentReads, TableNameOverride tableNameOverride, TableNameResolver tableNameResolver, ObjectTableNameResolver objectTableNameResolver, PaginationLoadingStrategy paginationLoadingStrategy, RequestMetricCollector requestMetricCollector, ConversionSchema conversionSchema, BatchWriteRetryStrategy batchWriteRetryStrategy, BatchLoadRetryStrategy batchLoadRetryStrategy)
  {
    this.saveBehavior = saveBehavior;
    this.consistentReads = consistentReads;
    this.tableNameOverride = tableNameOverride;
    this.tableNameResolver = tableNameResolver;
    this.objectTableNameResolver = objectTableNameResolver;
    this.paginationLoadingStrategy = paginationLoadingStrategy;
    this.requestMetricCollector = requestMetricCollector;
    this.conversionSchema = conversionSchema;
    this.batchWriteRetryStrategy = batchWriteRetryStrategy;
    this.batchLoadRetryStrategy = batchLoadRetryStrategy;
    typeConverterFactory = null;
  }
  
  @Deprecated
  public DynamoDBMapperConfig(SaveBehavior saveBehavior)
  {
    this(saveBehavior, null, null, null, null, null, null, DEFAULT
      .getConversionSchema(), DEFAULT.getBatchWriteRetryStrategy(), DEFAULT.getBatchLoadRetryStrategy());
  }
  
  @Deprecated
  public DynamoDBMapperConfig(ConsistentReads consistentReads)
  {
    this(null, consistentReads, null, null, null, null, null, DEFAULT
      .getConversionSchema(), DEFAULT.getBatchWriteRetryStrategy(), DEFAULT.getBatchLoadRetryStrategy());
  }
  
  @Deprecated
  public DynamoDBMapperConfig(TableNameOverride tableNameOverride)
  {
    this(null, null, tableNameOverride, null, null, null, null, DEFAULT
      .getConversionSchema(), DEFAULT.getBatchWriteRetryStrategy(), DEFAULT.getBatchLoadRetryStrategy());
  }
  
  @Deprecated
  public DynamoDBMapperConfig(TableNameResolver tableNameResolver)
  {
    this(null, null, null, tableNameResolver, null, null, null, DEFAULT
      .getConversionSchema(), DEFAULT.getBatchWriteRetryStrategy(), DEFAULT.getBatchLoadRetryStrategy());
  }
  
  @Deprecated
  public DynamoDBMapperConfig(ObjectTableNameResolver objectTableNameResolver)
  {
    this(null, null, null, null, objectTableNameResolver, null, null, DEFAULT
      .getConversionSchema(), DEFAULT.getBatchWriteRetryStrategy(), DEFAULT.getBatchLoadRetryStrategy());
  }
  
  @Deprecated
  public DynamoDBMapperConfig(TableNameResolver tableNameResolver, ObjectTableNameResolver objectTableNameResolver)
  {
    this(null, null, null, tableNameResolver, objectTableNameResolver, null, null, DEFAULT
      .getConversionSchema(), DEFAULT.getBatchWriteRetryStrategy(), DEFAULT.getBatchLoadRetryStrategy());
  }
  
  @Deprecated
  public DynamoDBMapperConfig(PaginationLoadingStrategy paginationLoadingStrategy)
  {
    this(null, null, null, null, null, paginationLoadingStrategy, null, DEFAULT
      .getConversionSchema(), DEFAULT.getBatchWriteRetryStrategy(), DEFAULT.getBatchLoadRetryStrategy());
  }
  
  @Deprecated
  public DynamoDBMapperConfig(ConversionSchema conversionSchema)
  {
    this(null, null, null, null, null, null, null, conversionSchema, DEFAULT.getBatchWriteRetryStrategy(), DEFAULT.getBatchLoadRetryStrategy());
  }
  
  @Deprecated
  public DynamoDBMapperConfig(DynamoDBMapperConfig defaults, DynamoDBMapperConfig overrides)
  {
    this(Builder.access$2400(builder(), defaults).merge(overrides));
  }
  
  public BatchLoadRetryStrategy getBatchLoadRetryStrategy()
  {
    return batchLoadRetryStrategy;
  }
  
  public SaveBehavior getSaveBehavior()
  {
    return saveBehavior;
  }
  
  public ConsistentReads getConsistentReads()
  {
    return consistentReads;
  }
  
  public TableNameOverride getTableNameOverride()
  {
    return tableNameOverride;
  }
  
  public TableNameResolver getTableNameResolver()
  {
    return tableNameResolver;
  }
  
  public ObjectTableNameResolver getObjectTableNameResolver()
  {
    return objectTableNameResolver;
  }
  
  public PaginationLoadingStrategy getPaginationLoadingStrategy()
  {
    return paginationLoadingStrategy;
  }
  
  public RequestMetricCollector getRequestMetricCollector()
  {
    return requestMetricCollector;
  }
  
  public ConversionSchema getConversionSchema()
  {
    return conversionSchema;
  }
  
  public BatchWriteRetryStrategy getBatchWriteRetryStrategy()
  {
    return batchWriteRetryStrategy;
  }
  
  public final DynamoDBTypeConverterFactory getTypeConverterFactory()
  {
    return typeConverterFactory;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
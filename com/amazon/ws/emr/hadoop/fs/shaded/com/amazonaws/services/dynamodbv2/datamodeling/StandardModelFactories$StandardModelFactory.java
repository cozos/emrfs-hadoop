package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class StandardModelFactories$StandardModelFactory
  implements DynamoDBMapperModelFactory
{
  private final ConcurrentMap<ConversionSchema, DynamoDBMapperModelFactory.TableFactory> cache;
  private final S3Link.Factory s3Links;
  
  private StandardModelFactories$StandardModelFactory(S3Link.Factory s3Links)
  {
    cache = new ConcurrentHashMap();
    this.s3Links = s3Links;
  }
  
  public DynamoDBMapperModelFactory.TableFactory getTableFactory(DynamoDBMapperConfig config)
  {
    ConversionSchema schema = config.getConversionSchema();
    if (!cache.containsKey(schema))
    {
      StandardModelFactories.RuleFactory<Object> rules = StandardModelFactories.access$100(config, s3Links, this);
      rules = new ConversionSchemas.ItemConverterRuleFactory(config, s3Links, rules);
      cache.putIfAbsent(schema, new StandardModelFactories.StandardTableFactory(rules, null));
    }
    return (DynamoDBMapperModelFactory.TableFactory)cache.get(schema);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.StandardModelFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
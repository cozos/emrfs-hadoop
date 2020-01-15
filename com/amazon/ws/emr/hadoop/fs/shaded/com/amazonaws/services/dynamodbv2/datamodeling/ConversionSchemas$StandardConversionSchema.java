package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

class ConversionSchemas$StandardConversionSchema
  implements ConversionSchema
{
  private final String name;
  private final ConversionSchemas.MarshallerSet marshallers;
  private final ConversionSchemas.UnmarshallerSet unmarshallers;
  
  public ConversionSchemas$StandardConversionSchema(String name, ConversionSchemas.MarshallerSet marshallers, ConversionSchemas.UnmarshallerSet unmarshallers)
  {
    this.name = name;
    this.marshallers = new ConversionSchemas.CachingMarshallerSet(new ConversionSchemas.AnnotationAwareMarshallerSet(marshallers));
    
    this.unmarshallers = new ConversionSchemas.CachingUnmarshallerSet(new ConversionSchemas.AnnotationAwareUnmarshallerSet(unmarshallers));
  }
  
  public ItemConverter getConverter(ConversionSchema.Dependencies dependencies)
  {
    S3ClientCache s3cc = (S3ClientCache)dependencies.get(S3ClientCache.class);
    
    return new ConversionSchemas.StandardItemConverter(marshallers, unmarshallers, s3cc);
  }
  
  public String toString()
  {
    return name;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.StandardConversionSchema
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
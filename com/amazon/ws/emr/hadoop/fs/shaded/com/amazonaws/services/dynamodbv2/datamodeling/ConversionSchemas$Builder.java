package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.List;

public class ConversionSchemas$Builder
{
  private final String name;
  private final List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers;
  private final List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers;
  private final List<ConversionSchemas.Pair<ArgumentUnmarshaller>> unmarshallers;
  private final List<ConversionSchemas.Pair<ArgumentUnmarshaller>> setUnmarshallers;
  
  ConversionSchemas$Builder(String name, List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers, List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers, List<ConversionSchemas.Pair<ArgumentUnmarshaller>> unmarshallers, List<ConversionSchemas.Pair<ArgumentUnmarshaller>> setUnmarshallers)
  {
    this.name = name;
    this.marshallers = marshallers;
    this.setMarshallers = setMarshallers;
    this.unmarshallers = unmarshallers;
    this.setUnmarshallers = setUnmarshallers;
  }
  
  public Builder addFirstType(Class<?> clazz, ArgumentMarshaller marshaller, ArgumentUnmarshaller unmarshaller)
  {
    marshallers.add(0, ConversionSchemas.Pair.of(clazz, marshaller));
    unmarshallers.add(0, ConversionSchemas.Pair.of(clazz, unmarshaller));
    return this;
  }
  
  public Builder addFirstSetType(Class<?> clazz, ArgumentMarshaller marshaller, ArgumentUnmarshaller unmarshaller)
  {
    setMarshallers.add(0, ConversionSchemas.Pair.of(clazz, marshaller));
    setUnmarshallers.add(0, ConversionSchemas.Pair.of(clazz, unmarshaller));
    return this;
  }
  
  public ConversionSchema build()
  {
    return new ConversionSchemas.StandardConversionSchema(name, new ConversionSchemas.AbstractMarshallerSet(marshallers, setMarshallers), new ConversionSchemas.StandardUnmarshallerSet(unmarshallers, setUnmarshallers));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
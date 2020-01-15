package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.List;

class StandardModelFactories$Rules$NativeBoolSet
  extends StandardModelFactories.Rules<T>.ObjectSet
{
  private StandardModelFactories$Rules$NativeBoolSet(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(paramRules, supported, null);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (super.isAssignableFrom(type)) && (type.param(0).is(StandardTypeConverters.Scalar.BOOLEAN));
  }
  
  public List<AttributeValue> unconvert(AttributeValue o)
  {
    if ((o.getL() == null) && (o.getNS() != null)) {
      return StandardTypeConverters.Vector.LIST.convert(o.getNS(), new StandardModelFactories.Rules.NativeBool(this$0, true, null).join(StandardModelFactories.Rules.access$2600(this$0).getConverter(Boolean.class, String.class)));
    }
    return (List)super.unconvert(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.NativeBoolSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
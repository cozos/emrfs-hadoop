package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.HashSet;

public class ThrowableDeserializer
  extends BeanDeserializer
{
  private static final long serialVersionUID = 1L;
  protected static final String PROP_NAME_MESSAGE = "message";
  
  public ThrowableDeserializer(BeanDeserializer baseDeserializer)
  {
    super(baseDeserializer);
    
    _vanillaProcessing = false;
  }
  
  protected ThrowableDeserializer(BeanDeserializer src, NameTransformer unwrapper)
  {
    super(src, unwrapper);
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer unwrapper)
  {
    if (getClass() != ThrowableDeserializer.class) {
      return this;
    }
    return new ThrowableDeserializer(this, unwrapper);
  }
  
  public Object deserializeFromObject(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (_propertyBasedCreator != null) {
      return _deserializeUsingPropertyBased(jp, ctxt);
    }
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(jp, ctxt));
    }
    if (_beanType.isAbstract()) {
      throw JsonMappingException.from(jp, "Can not instantiate abstract type " + _beanType + " (need to add/enable type information?)");
    }
    boolean hasStringCreator = _valueInstantiator.canCreateFromString();
    boolean hasDefaultCtor = _valueInstantiator.canCreateUsingDefault();
    if ((!hasStringCreator) && (!hasDefaultCtor)) {
      throw new JsonMappingException("Can not deserialize Throwable of type " + _beanType + " without having a default contructor, a single-String-arg constructor; or explicit @JsonCreator");
    }
    Object throwable = null;
    Object[] pending = null;
    int pendingIx = 0;
    for (; jp.getCurrentToken() != JsonToken.END_OBJECT; jp.nextToken())
    {
      String propName = jp.getCurrentName();
      SettableBeanProperty prop = _beanProperties.find(propName);
      jp.nextToken();
      if (prop != null)
      {
        if (throwable != null)
        {
          prop.deserializeAndSet(jp, ctxt, throwable);
        }
        else
        {
          if (pending == null)
          {
            int len = _beanProperties.size();
            pending = new Object[len + len];
          }
          pending[(pendingIx++)] = prop;
          pending[(pendingIx++)] = prop.deserialize(jp, ctxt);
        }
      }
      else if (("message".equals(propName)) && 
        (hasStringCreator))
      {
        throwable = _valueInstantiator.createFromString(ctxt, jp.getText());
        if (pending != null)
        {
          int i = 0;
          for (int len = pendingIx; i < len; i += 2)
          {
            prop = (SettableBeanProperty)pending[i];
            prop.set(throwable, pending[(i + 1)]);
          }
          pending = null;
        }
      }
      else if ((_ignorableProps != null) && (_ignorableProps.contains(propName)))
      {
        jp.skipChildren();
      }
      else if (_anySetter != null)
      {
        _anySetter.deserializeAndSet(jp, ctxt, throwable, propName);
      }
      else
      {
        handleUnknownProperty(jp, ctxt, throwable, propName);
      }
    }
    if (throwable == null)
    {
      if (hasStringCreator) {
        throwable = _valueInstantiator.createFromString(ctxt, null);
      } else {
        throwable = _valueInstantiator.createUsingDefault(ctxt);
      }
      if (pending != null)
      {
        int i = 0;
        for (int len = pendingIx; i < len; i += 2)
        {
          SettableBeanProperty prop = (SettableBeanProperty)pending[i];
          prop.set(throwable, pending[(i + 1)]);
        }
      }
    }
    return throwable;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
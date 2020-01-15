package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal..Gson.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;

class TreeTypeAdapter$SingleTypeFactory
  implements TypeAdapterFactory
{
  private final TypeToken<?> exactType;
  private final boolean matchRawType;
  private final Class<?> hierarchyType;
  private final JsonSerializer<?> serializer;
  private final JsonDeserializer<?> deserializer;
  
  private TreeTypeAdapter$SingleTypeFactory(Object typeAdapter, TypeToken<?> exactType, boolean matchRawType, Class<?> hierarchyType)
  {
    serializer = ((typeAdapter instanceof JsonSerializer) ? (JsonSerializer)typeAdapter : null);
    
    deserializer = ((typeAdapter instanceof JsonDeserializer) ? (JsonDeserializer)typeAdapter : null);
    
    .Gson.Preconditions.checkArgument((serializer != null) || (deserializer != null));
    this.exactType = exactType;
    this.matchRawType = matchRawType;
    this.hierarchyType = hierarchyType;
  }
  
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type)
  {
    boolean matches = exactType != null ? false : (exactType.equals(type)) || ((matchRawType) && (exactType.getType() == type.getRawType())) ? true : hierarchyType.isAssignableFrom(type.getRawType());
    
    return matches ? new TreeTypeAdapter(serializer, deserializer, gson, type, this, null) : null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TreeTypeAdapter.SingleTypeFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
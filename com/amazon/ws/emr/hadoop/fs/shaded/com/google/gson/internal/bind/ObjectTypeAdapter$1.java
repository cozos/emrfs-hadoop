package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;

final class ObjectTypeAdapter$1
  implements TypeAdapterFactory
{
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type)
  {
    if (type.getRawType() == Object.class) {
      return new ObjectTypeAdapter(gson, null);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.ObjectTypeAdapter.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class ImmutableBiMap$SerializedForm
  extends ImmutableMap.SerializedForm
{
  private static final long serialVersionUID = 0L;
  
  ImmutableBiMap$SerializedForm(ImmutableBiMap<?, ?> bimap)
  {
    super(bimap);
  }
  
  Object readResolve()
  {
    ImmutableBiMap.Builder<Object, Object> builder = new ImmutableBiMap.Builder();
    return createMap(builder);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableBiMap.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
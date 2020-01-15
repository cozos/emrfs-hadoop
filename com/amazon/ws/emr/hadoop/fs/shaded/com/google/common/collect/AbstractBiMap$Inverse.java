package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

class AbstractBiMap$Inverse<K, V>
  extends AbstractBiMap<K, V>
{
  @GwtIncompatible("Not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  
  private AbstractBiMap$Inverse(Map<K, V> backward, AbstractBiMap<V, K> forward)
  {
    super(backward, forward, null);
  }
  
  K checkKey(K key)
  {
    return (K)inverse.checkValue(key);
  }
  
  V checkValue(V value)
  {
    return (V)inverse.checkKey(value);
  }
  
  @GwtIncompatible("java.io.ObjectOuputStream")
  private void writeObject(ObjectOutputStream stream)
    throws IOException
  {
    stream.defaultWriteObject();
    stream.writeObject(inverse());
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private void readObject(ObjectInputStream stream)
    throws IOException, ClassNotFoundException
  {
    stream.defaultReadObject();
    setInverse((AbstractBiMap)stream.readObject());
  }
  
  @GwtIncompatible("Not needed in the emulated source.")
  Object readResolve()
  {
    return inverse().inverse();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractBiMap.Inverse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
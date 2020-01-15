package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite
{
  private static volatile boolean eagerlyParseMessageSets = false;
  private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;
  
  public static boolean isEagerlyParseMessageSets()
  {
    return eagerlyParseMessageSets;
  }
  
  public static void setEagerlyParseMessageSets(boolean isEagerlyParse)
  {
    eagerlyParseMessageSets = isEagerlyParse;
  }
  
  public static ExtensionRegistryLite newInstance()
  {
    return new ExtensionRegistryLite();
  }
  
  public static ExtensionRegistryLite getEmptyRegistry()
  {
    return EMPTY;
  }
  
  public ExtensionRegistryLite getUnmodifiable()
  {
    return new ExtensionRegistryLite(this);
  }
  
  public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingTypeDefaultInstance, int fieldNumber)
  {
    return (GeneratedMessageLite.GeneratedExtension)extensionsByNumber.get(new ObjectIntPair(containingTypeDefaultInstance, fieldNumber));
  }
  
  public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> extension)
  {
    extensionsByNumber.put(new ObjectIntPair(extension.getContainingTypeDefaultInstance(), extension.getNumber()), extension);
  }
  
  ExtensionRegistryLite()
  {
    extensionsByNumber = new HashMap();
  }
  
  ExtensionRegistryLite(ExtensionRegistryLite other)
  {
    if (other == EMPTY) {
      extensionsByNumber = Collections.emptyMap();
    } else {
      extensionsByNumber = Collections.unmodifiableMap(extensionsByNumber);
    }
  }
  
  private ExtensionRegistryLite(boolean empty)
  {
    extensionsByNumber = Collections.emptyMap();
  }
  
  private static final ExtensionRegistryLite EMPTY = new ExtensionRegistryLite(true);
  
  private static final class ObjectIntPair
  {
    private final Object object;
    private final int number;
    
    ObjectIntPair(Object object, int number)
    {
      this.object = object;
      this.number = number;
    }
    
    public int hashCode()
    {
      return System.identityHashCode(object) * 65535 + number;
    }
    
    public boolean equals(Object obj)
    {
      if (!(obj instanceof ObjectIntPair)) {
        return false;
      }
      ObjectIntPair other = (ObjectIntPair)obj;
      return (object == object) && (number == number);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ExtensionRegistryLite
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
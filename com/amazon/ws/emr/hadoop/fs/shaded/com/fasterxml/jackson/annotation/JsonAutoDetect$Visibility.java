package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public enum JsonAutoDetect$Visibility
{
  ANY,  NON_PRIVATE,  PROTECTED_AND_PUBLIC,  PUBLIC_ONLY,  NONE,  DEFAULT;
  
  private JsonAutoDetect$Visibility() {}
  
  public boolean isVisible(Member m)
  {
    switch (JsonAutoDetect.1.$SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[ordinal()])
    {
    case 1: 
      return true;
    case 2: 
      return false;
    case 3: 
      return !Modifier.isPrivate(m.getModifiers());
    case 4: 
      if (Modifier.isProtected(m.getModifiers())) {
        return true;
      }
    case 5: 
      return Modifier.isPublic(m.getModifiers());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
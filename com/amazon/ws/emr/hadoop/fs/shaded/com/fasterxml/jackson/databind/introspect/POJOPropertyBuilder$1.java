package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$1
  implements POJOPropertyBuilder.WithMember<Class<?>[]>
{
  POJOPropertyBuilder$1(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public Class<?>[] withMember(AnnotatedMember member)
  {
    return this$0._annotationIntrospector.findViews(member);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
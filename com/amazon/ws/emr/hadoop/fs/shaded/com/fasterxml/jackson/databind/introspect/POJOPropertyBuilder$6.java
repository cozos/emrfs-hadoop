package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$6
  implements POJOPropertyBuilder.WithMember<Integer>
{
  POJOPropertyBuilder$6(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public Integer withMember(AnnotatedMember member)
  {
    return this$0._annotationIntrospector.findPropertyIndex(member);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
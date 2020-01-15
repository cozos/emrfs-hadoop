package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$7
  implements POJOPropertyBuilder.WithMember<String>
{
  POJOPropertyBuilder$7(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public String withMember(AnnotatedMember member)
  {
    return this$0._annotationIntrospector.findPropertyDefaultValue(member);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
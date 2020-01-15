package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;

class POJOPropertyBuilder$2
  implements POJOPropertyBuilder.WithMember<AnnotationIntrospector.ReferenceProperty>
{
  POJOPropertyBuilder$2(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public AnnotationIntrospector.ReferenceProperty withMember(AnnotatedMember member)
  {
    return this$0._annotationIntrospector.findReferenceType(member);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$3
  implements POJOPropertyBuilder.WithMember<Boolean>
{
  POJOPropertyBuilder$3(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public Boolean withMember(AnnotatedMember member)
  {
    return this$0._annotationIntrospector.isTypeId(member);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
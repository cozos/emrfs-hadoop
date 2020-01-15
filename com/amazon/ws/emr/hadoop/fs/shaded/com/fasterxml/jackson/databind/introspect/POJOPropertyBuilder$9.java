package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$9
  implements POJOPropertyBuilder.WithMember<JsonProperty.Access>
{
  POJOPropertyBuilder$9(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public JsonProperty.Access withMember(AnnotatedMember member)
  {
    return this$0._annotationIntrospector.findPropertyAccess(member);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
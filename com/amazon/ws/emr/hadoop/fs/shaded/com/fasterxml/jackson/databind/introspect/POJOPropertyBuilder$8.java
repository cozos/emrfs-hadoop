package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$8
  implements POJOPropertyBuilder.WithMember<ObjectIdInfo>
{
  POJOPropertyBuilder$8(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public ObjectIdInfo withMember(AnnotatedMember member)
  {
    ObjectIdInfo info = this$0._annotationIntrospector.findObjectIdInfo(member);
    if (info != null) {
      info = this$0._annotationIntrospector.findObjectReferenceInfo(member, info);
    }
    return info;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
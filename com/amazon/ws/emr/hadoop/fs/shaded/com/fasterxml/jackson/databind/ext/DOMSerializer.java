package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

public class DOMSerializer
  extends StdSerializer<Node>
{
  protected final DOMImplementationLS _domImpl;
  
  public DOMSerializer()
  {
    super(Node.class);
    DOMImplementationRegistry registry;
    try
    {
      registry = DOMImplementationRegistry.newInstance();
    }
    catch (Exception e)
    {
      throw new IllegalStateException("Could not instantiate DOMImplementationRegistry: " + e.getMessage(), e);
    }
    _domImpl = ((DOMImplementationLS)registry.getDOMImplementation("LS"));
  }
  
  public void serialize(Node value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    if (_domImpl == null) {
      throw new IllegalStateException("Could not find DOM LS");
    }
    LSSerializer writer = _domImpl.createLSSerializer();
    jgen.writeString(writer.writeToString(value));
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    return createSchemaNode("string", true);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    if (visitor != null) {
      visitor.expectAnyFormat(typeHint);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.DOMSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class TextFormat$Printer
{
  boolean singleLineMode = false;
  boolean escapeNonAscii = true;
  
  private Printer setSingleLineMode(boolean singleLineMode)
  {
    this.singleLineMode = singleLineMode;
    return this;
  }
  
  private Printer setEscapeNonAscii(boolean escapeNonAscii)
  {
    this.escapeNonAscii = escapeNonAscii;
    return this;
  }
  
  private void print(MessageOrBuilder message, TextFormat.TextGenerator generator)
    throws IOException
  {
    for (Map.Entry<Descriptors.FieldDescriptor, Object> field : message.getAllFields().entrySet()) {
      printField((Descriptors.FieldDescriptor)field.getKey(), field.getValue(), generator);
    }
    printUnknownFields(message.getUnknownFields(), generator);
  }
  
  private void printField(Descriptors.FieldDescriptor field, Object value, TextFormat.TextGenerator generator)
    throws IOException
  {
    if (field.isRepeated()) {
      for (Object element : (List)value) {
        printSingleField(field, element, generator);
      }
    } else {
      printSingleField(field, value, generator);
    }
  }
  
  private void printSingleField(Descriptors.FieldDescriptor field, Object value, TextFormat.TextGenerator generator)
    throws IOException
  {
    if (field.isExtension())
    {
      generator.print("[");
      if ((field.getContainingType().getOptions().getMessageSetWireFormat()) && (field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) && (field.isOptional()) && (field.getExtensionScope() == field.getMessageType())) {
        generator.print(field.getMessageType().getFullName());
      } else {
        generator.print(field.getFullName());
      }
      generator.print("]");
    }
    else if (field.getType() == Descriptors.FieldDescriptor.Type.GROUP)
    {
      generator.print(field.getMessageType().getName());
    }
    else
    {
      generator.print(field.getName());
    }
    if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
    {
      if (singleLineMode)
      {
        generator.print(" { ");
      }
      else
      {
        generator.print(" {\n");
        generator.indent();
      }
    }
    else {
      generator.print(": ");
    }
    printFieldValue(field, value, generator);
    if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
    {
      if (singleLineMode)
      {
        generator.print("} ");
      }
      else
      {
        generator.outdent();
        generator.print("}\n");
      }
    }
    else if (singleLineMode) {
      generator.print(" ");
    } else {
      generator.print("\n");
    }
  }
  
  private void printFieldValue(Descriptors.FieldDescriptor field, Object value, TextFormat.TextGenerator generator)
    throws IOException
  {
    switch (TextFormat.1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[field.getType().ordinal()])
    {
    case 1: 
    case 2: 
    case 3: 
      generator.print(((Integer)value).toString());
      break;
    case 4: 
    case 5: 
    case 6: 
      generator.print(((Long)value).toString());
      break;
    case 7: 
      generator.print(((Boolean)value).toString());
      break;
    case 8: 
      generator.print(((Float)value).toString());
      break;
    case 9: 
      generator.print(((Double)value).toString());
      break;
    case 10: 
    case 11: 
      generator.print(TextFormat.access$800(((Integer)value).intValue()));
      break;
    case 12: 
    case 13: 
      generator.print(TextFormat.access$900(((Long)value).longValue()));
      break;
    case 14: 
      generator.print("\"");
      generator.print(escapeNonAscii ? TextFormat.escapeText((String)value) : (String)value);
      
      generator.print("\"");
      break;
    case 15: 
      generator.print("\"");
      generator.print(TextFormat.escapeBytes((ByteString)value));
      generator.print("\"");
      break;
    case 16: 
      generator.print(((Descriptors.EnumValueDescriptor)value).getName());
      break;
    case 17: 
    case 18: 
      print((Message)value, generator);
    }
  }
  
  private void printUnknownFields(UnknownFieldSet unknownFields, TextFormat.TextGenerator generator)
    throws IOException
  {
    for (Iterator i$ = unknownFields.asMap().entrySet().iterator(); i$.hasNext();)
    {
      entry = (Map.Entry)i$.next();
      int number = ((Integer)entry.getKey()).intValue();
      UnknownFieldSet.Field field = (UnknownFieldSet.Field)entry.getValue();
      printUnknownField(number, 0, field.getVarintList(), generator);
      
      printUnknownField(number, 5, field.getFixed32List(), generator);
      
      printUnknownField(number, 1, field.getFixed64List(), generator);
      
      printUnknownField(number, 2, field.getLengthDelimitedList(), generator);
      for (UnknownFieldSet value : field.getGroupList())
      {
        generator.print(((Integer)entry.getKey()).toString());
        if (singleLineMode)
        {
          generator.print(" { ");
        }
        else
        {
          generator.print(" {\n");
          generator.indent();
        }
        printUnknownFields(value, generator);
        if (singleLineMode)
        {
          generator.print("} ");
        }
        else
        {
          generator.outdent();
          generator.print("}\n");
        }
      }
    }
    Map.Entry<Integer, UnknownFieldSet.Field> entry;
  }
  
  private void printUnknownField(int number, int wireType, List<?> values, TextFormat.TextGenerator generator)
    throws IOException
  {
    for (Object value : values)
    {
      generator.print(String.valueOf(number));
      generator.print(": ");
      TextFormat.access$1000(wireType, value, generator);
      generator.print(singleLineMode ? " " : "\n");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.TextFormat.Printer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package chapter05;

public class GettersAndSetters {
  private String readOnly = "Only getter defined";
  private String writeOnly = "Only setter defined";
  private String readWrite = "Both defined";

  public String getReadOnly() { return readOnly; }
  public void setWriteOnly(String writeOnly) { this.writeOnly = writeOnly; }
  public String getReadWrite() { return readWrite; }
  public void setReadWrite(String readWrite) { this.readWrite = readWrite; }
}


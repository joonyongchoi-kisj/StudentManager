public class TestData {
  private String cumulativeGPA;
  private String TestDate;
  private String SATTotal;
  private String SATEBRW;
  private String SATMath;
  private String PSATTotal;
  private String PSATEBRW;
  private String PSATMath;

  public TestData(String cumulativeGPA, String TestDate, String SATTotal, String SATEBRW, String SATMath, String PSATTotal, String PSATEBRW, String PSATMath) {
    this.cumulativeGPA = cumulativeGPA;
    this.TestDate = TestDate;
    this.SATTotal = SATTotal;
    this.SATEBRW = SATEBRW;
    this.SATMath = SATMath;
    this.PSATTotal = PSATTotal;
    this.PSATEBRW = PSATEBRW;
    this.PSATMath = PSATMath;
  }
  
  public String getcumulativeGPA() {
    return cumulativeGPA;
  }
  public String getTestDate() {
    return TestDate;
  }
  public String getSATTotal() {
    return SATTotal;
  }
  public String getSATEBRW() {
    return SATEBRW;
  }
  public String getSATMath() {
    return SATMath;
  }
  public String getPSATTotal() {
    return PSATTotal;
  }
  public String getPSATEBRW() {
    return PSATEBRW;
  }
  public String getPSATMath() {
    return PSATMath;
  }


  public int DateConverToInt(){
    return Integer.parseInt(TestDate.substring(6)+TestDate.substring(0,2)+TestDate.substring(3,5));
  }
  
  public void setcumulativeGPA(String c) {
    cumulativeGPA = c;
  }
  public void setTestDate(String c) {
    TestDate = c;
  }
  public void setSATTotal(String c) {
    SATTotal = c;
  }
  public void setSATEBRW(String c) {
    SATEBRW = c;
  }
  public void setSATMath(String c) {
    SATMath = c;
  }
  public void setPSATTotal(String c) {
    PSATTotal = c;
  }
  public void setPSATEBRW(String c) {
    PSATEBRW = c;
  }
  public void setPSATMath(String c) {
    PSATMath = c;
  }
}
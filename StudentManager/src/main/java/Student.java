import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Student {
  private String name;
  private String ID;
  private String GradeLevel;
  private ArrayList<HistoricalGrade> historicalGradeList;
  private ArrayList<TestData> testDataList;

  public Student(String name, String ID, String GradeLevel) {
    this.name = name;
    this.ID = ID;
    this.GradeLevel = GradeLevel;
    this.historicalGradeList = new ArrayList<HistoricalGrade>();
    this.testDataList = new ArrayList<TestData>();

    // CSV File Import
    String[][] HistoricalGrade = null;
    String[][] TestData = null;
    try {
      HistoricalGrade = readCSV("StudentHistoricGrades.csv");
      TestData = readCSV("test1.csv");

    } catch (IOException e) {
      System.err.println("An error occurred while reading the CSV file: " + e.getMessage());
      e.printStackTrace();
    }

    // add historicalGradeList
    for (int i = 4; i < HistoricalGrade.length; i++) { // starts in 4 due to StudentHistoricGrades.csv
      if (HistoricalGrade[i][2].equals(ID)) {
        String courseName = HistoricalGrade[i][3]; // course name
        String courseNumber = HistoricalGrade[i][4]; // course number
        String courseGPA = HistoricalGrade[i][6]; // course GPA
        historicalGradeList.add(new HistoricalGrade(courseName, courseNumber, courseGPA));
      }
    }

    // add testDataList
    for (int i = 1; i < TestData.length; i++) {
      if (TestData[i][1].equals(ID)) {
        String cumulativeGPA = TestData[i][6]; // cumulative GPA
        String TestDate = TestData[i][7]; // Test-taken date
        String SATTotal = TestData[i][8]; // SAT Total
        String SATEBRW = TestData[i][9]; // SAT EBRW
        String SATMath = TestData[i][10]; // SAT Math
        String PSATTotal = TestData[i][11]; // PSAT Total
        String PSATEBRW = TestData[i][12]; // PSAT EBRW
        String PSATMath = TestData[i][13]; // PSAT Math
        testDataList.add(new TestData(cumulativeGPA, TestDate, SATTotal, SATEBRW, SATMath, PSATTotal, PSATEBRW, PSATMath));
      }
    }
  }

  // readCSV method
  public static String[][] readCSV(String CSVFile) throws IOException {
    List<String[]> csvFile = new ArrayList<String[]>();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(CSVFile));
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        csvFile.add(values);
      }
    } finally {
      if (br != null) {
        br.close();
      }
    }
    String[][] array = new String[csvFile.size()][0];
    csvFile.toArray(array);
    return array;
  }

  // get Recent SAT, PSAT Total Scores
  public String getRecentSATTotal() {
    String result = "";
    int len = testDataList.size();
    int[] Scores = new int [len];
    for(int i = 0; i<Scores.length; i++) {
      Scores[i] = testDataList.get(i).DateConverToInt();
    }
    Arrays.sort(Scores);
    
    int date = Scores[Scores.length-1];
    int day = date % 100;
    date = date / 100;
    int month = date % 100 ; 
    date = date / 100; 
    int year = date; 
    
    String dateNew = "";
    if(month < 10){
      dateNew += "0"+month;
    }else{
      dateNew += ""+ month;
    }
    if(day < 10){
      dateNew += "/0"+day +"/"+year;
    }else{
      dateNew += "/"+day +"/"+year;
    }
    
    for(int j = 0 ; j < testDataList.size(); j++) {
      if(dateNew.equals(testDataList.get(j).getTestDate())) {
        result = testDataList.get(j).getSATTotal(); //SAT Total
      }
    }
    return result;
  }
  public String getRecentPSATTotal() {
    String result = "";
    int len = testDataList.size();
    int[] Scores = new int [len];
    for(int i = 0; i<Scores.length; i++) {
      Scores[i] = testDataList.get(i).DateConverToInt();
    }
    Arrays.sort(Scores);

    int date = Scores[Scores.length-1];
    int day = date % 100;
    date = date / 100;
    int month = date % 100 ; 
    date = date / 100; 
    int year = date; 

    String dateNew = "";
    if(month < 10){
      dateNew += "0"+month;
    }else{
      dateNew += ""+ month;
    }
    if(day < 10){
      dateNew += "/0"+day +"/"+year;
    }else{
      dateNew += "/"+day +"/"+year;
    }

    for(int j = 0 ; j<testDataList.size(); j++){
      if(dateNew.equals(testDataList.get(j).getTestDate())) {
        result = testDataList.get(j).getPSATTotal(); // PSAT Total
      }
    }
    return result;
  }

  // get student's Maximum SAT, PSAT Total Scores
  public String getMaxSATTotal() {
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < testDataList.size(); i++) {
      int n = Integer.parseInt(testDataList.get(i).getSATTotal());
      if(n > max) {
        max = n;
      }
    }
    return max+"";
  }
  public String getMaxPSATTotal() {
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < testDataList.size(); i++) {
      int n = Integer.parseInt(testDataList.get(i).getPSATTotal());
      if(n > max) {
        max = n;
      }
    }
    return max+"";
  }

  // getters
  public String getName() {
    return name;
  }

  public String getID() {
    return ID;
  }

  public String getGradeLevel() {
    return GradeLevel;
  }

  // setters
  public void setName(String k) {
    name = k;
  }

  public void setID(String k) {
    ID = k;
  }

  public void setGradeLevel(String k) {
    GradeLevel = k;
  }

  // print method for student historical grades & test data
  public String toString() {
    String result = "";
    result = "***** " + "Name: " + name + " ID: " + ID + " GradeLevel: " + GradeLevel + " *****\n\n";
    for (int i = 0; i < historicalGradeList.size(); i++) {
      result += "Course Name: " + historicalGradeList.get(i).getCourseName() + " ";
      result += "Course Number: " + historicalGradeList.get(i).getCourseNumber() + " ";
      result += "CourseGPA: " + historicalGradeList.get(i).getCourseGPA() + " \n";
    }

    for (int j = 0; j < testDataList.size(); j++) {
      result += "CumulativeGPA: " + testDataList.get(j).getcumulativeGPA() + " ";
      result += "Test Date: " + testDataList.get(j).getTestDate() + " ";
      result += "SAT Total: " + testDataList.get(j).getSATTotal() + " ";
      result += "SAT EBRW: " + testDataList.get(j).getSATEBRW() + " ";
      result += "SAT Math: " + testDataList.get(j).getSATMath() + " ";
      
      result += "PSAT Total: " + testDataList.get(j).getPSATTotal() + " ";
      result += "PSAT EBRW: " + testDataList.get(j).getPSATEBRW() + " ";
      result += "PSAT Math: " + testDataList.get(j).getPSATMath() + " \n";
    }
    result += "Recent SAT Total: " + getRecentSATTotal() + " ";
    result += "Recent PSAT Total: " + getRecentPSATTotal() + " ";
    result += "Max SAT Total: " + getMaxSATTotal()+ " ";
    result += "Max PSAT Total: "+ getMaxPSATTotal()+ " \n";
    return result;
  }
}
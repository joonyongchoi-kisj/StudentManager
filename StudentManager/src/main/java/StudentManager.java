import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class StudentManager {
  private static ArrayList<Student> studentList;
  
  public StudentManager() {
    studentList = new ArrayList<Student>();

    // CSV File Import
    String[][] HistoricalGrade = null;
    String[][] TestData = null;
 
    // CSV File Import-related try-catch method
    try {
      HistoricalGrade = readCSV("StudentHistoricGrades.csv");
      TestData = readCSV("test1.csv");
    } catch (IOException e) {
      System.err.println("An error occurred while reading the CSV file: " + e.getMessage());
      e.printStackTrace();
    }

    // Create student from HistoricalGrade arraylist
    for (int i = 4; i < HistoricalGrade.length; i++) {
      addStudent(HistoricalGrade[i][0], HistoricalGrade[i][1], HistoricalGrade[i][2]);
    }

    // Create student from TestData arraylist
    for(int j = 1; j < TestData.length; j++) {
      // String name, String gradeLevel , String ID
      addStudent(TestData[j][0], TestData[j][5], TestData[j][1]);
    }
  }
  
  // CSV file-related method
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

  // method for adding new student to studentList
  public static void addStudent(String name,String gradeLevel, String ID) {
    for (int i = 0; i < studentList.size(); i++) {
      if (studentList.get(i).getID().equals(ID)) {
        return;
      }
    }
    studentList.add(new Student(name, ID, gradeLevel));
  }

  // print method for studentList
  public String toString() {
    String result ="";
    for(int i = 0 ; i<studentList.size(); i++){
      result += studentList.get(i)+"\n";
    }
    return result;
  }

  public ArrayList<Student> getStudentList() {
    return studentList;
  }
}
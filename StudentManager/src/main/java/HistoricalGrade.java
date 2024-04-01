public class HistoricalGrade {
  private String courseName;
  private String courseNumber;
  private String courseGPA;

  public HistoricalGrade(String courseName, String courseNumber, String courseGPA) {
    this.courseName = courseName;
    this.courseNumber = courseNumber;
    this.courseGPA = courseGPA;
  }

  public String getCourseName() {
    return courseName;
  }

  public String getCourseNumber() {
    return courseNumber;
  }

  public String getCourseGPA() {
    return courseGPA;
  }

  public void setCourseName(String c) {
    courseName = c;
  }

  public void setCourseNumber(String c) {
    courseNumber = c;
  }

  public void setCourseGPA(String c) {
    courseGPA = c;
  }
}
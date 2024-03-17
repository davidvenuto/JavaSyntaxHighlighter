package sourceFiles;

public class Course {
    private String courseName;
    private String courseCode;
    private int credits;

    public Course(String courseName, String courseCode, int credits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public String displayCourseInfo() {
        return "Course Name: " + courseName + ", Course Code: " + courseCode + ", Credits: " + credits;
    }
}


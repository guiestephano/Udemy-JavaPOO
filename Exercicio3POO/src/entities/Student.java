package entities;

public class Student {
    public String name;
    public double firstTrimester;
    public double secondTrimester;
    public double thirdQTrimester;
    public boolean isApproved;

    public Student(String name, double fistTrimester, double secondTrimester, double thirdQTrimester){
        this.name = name;
        this.firstTrimester = fistTrimester;
        this.secondTrimester = secondTrimester;
        this.thirdQTrimester = thirdQTrimester;
        this.isApproved = finalGrade() >= 60.0;
    }

    public double finalGrade(){
        return firstTrimester + secondTrimester + thirdQTrimester;
    }

    public double missingPoints(){
        if(!isApproved)
            return 60 - finalGrade();
        return 0;
    }

    public String toString(){
        if(isApproved){
            return "FINAL GRADE = " + String.format("%.2f", finalGrade()) + "\nPASS";
        }
        return "FINAL GRADE = " + String.format("%.2f", finalGrade()) + "\nFAILED\nMISSING " + String.format("%.2f", missingPoints()) + " POINTS";
    }
}

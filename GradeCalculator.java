import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {

        System.out.print("Enter The Number of Subjects: ");
        Scanner sc = new Scanner(System.in);
        int sub = sc.nextInt();
        int Marks[] = new int[sub];
        int SumOfMarks=0;

        System.out.println("Enter the marks of each subjects out of 100:");
        for (int i = 0; i < Marks.length; i++) {
            int marks = sc.nextInt();
            try {
                if (marks < 0 || marks > 100) {
                    throw new Exception("Marks out of bounds. Please enter marks between 0 and 100.");
                } else {
                    Marks[i] = marks;
                }
            } 
            catch (Exception e) {
                System.out.println(e.getMessage());
                i--;
            }
        }

        for(int i=0;i<Marks.length;i++){
            SumOfMarks+=Marks[i];
        }
        System.out.println("You scored "+SumOfMarks+" out of "+sub*100);

        int AvgPercentage = SumOfMarks/sub;
        System.out.println("You Average Percentage is: "+AvgPercentage+" %");

        String grade;
        if(AvgPercentage>90){
            grade="O";
        }
        else if(AvgPercentage>80 && AvgPercentage>=90){
            grade="A";
        }
        else if(AvgPercentage>70 && AvgPercentage>=80){
            grade="B";
        }
        else if(AvgPercentage>60 && AvgPercentage>=70){
            grade="C";
        }
        else if(AvgPercentage>50 && AvgPercentage>=60){
            grade="D";
        }
        else if(AvgPercentage>40 && AvgPercentage>=50){
            grade="E";
        }
        else{
            grade="F";
        }
        System.out.println("Your Grade is: "+grade);
    }
}

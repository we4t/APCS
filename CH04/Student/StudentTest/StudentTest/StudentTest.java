public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student();
        Student g = new GradStudent();
        Student u = new UnderGrad();

        /*not valid
        GradStudnet g = new Student();
        UnderGrad u = new Studend();
        */

        s = new Student("Brain Lorenzen", new int[] {90,94,99}, "none");
        u = new UnderGrad("Tim Broder", new int[] {90,90,100}, "none");
        g = new GradStudent("Kevin Cristella", new int[] {85, 70, 90}, "none", 1234);

        s.setGrade("Pass");
        g.setGrade("Pass");
        u.setGrade("pass");
        s.computeGrade();
        g.computeGrade();
        u.computeGrade();

        
    }
}

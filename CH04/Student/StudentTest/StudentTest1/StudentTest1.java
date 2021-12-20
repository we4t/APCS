public class StudentTest1 {
    public static void main(String[] args) {
        Student s = null;
        Student g = new GradStudent("Kevin Cristella", new int[] {85, 70, 90}, "none", 1234);
        Student u = new UnderGrad("Tim Broder", new int[] {90,90,100}, "none");

        String str = "G";
        if(str.equals("G")){
            s = g;
        }
        else if(str.equals("U")){
            s = u;
        }
        else
            s = new Student();
        s.computeGrade(); // dynaminc binding
        System.out.println(s.getGrade());
    }
}

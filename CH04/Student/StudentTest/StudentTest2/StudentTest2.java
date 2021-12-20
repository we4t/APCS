class StudentTest2 {
    public static void main(String[] args) {
        Student[] stu = new Student[5];
        stu[0] = new Student("Brian lorenzen", new int[] {90,94,99}, "none");
        stu[1] = new UnderGrad("Tim Broder", new int[] {90,90,100}, "none");
        stu[2] = new GradStudent("Kevin Cristella", new int[] {85, 70, 90}, "none", 1234);
        computeAllGrades(stu);

    }   
    public static void computeAllGrades(Student[] studentList){
        for(Student s : studentList){
            if(s != null)
                s.computeGrade();
        }
    } 
}

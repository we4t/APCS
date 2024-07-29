public class Student {
    private String myName;
    private double myHeight;
    private int myAge;
    private float[] myScores;
    private float myAverage;

    // constructors
    public Student(String name, int age, double height, float[] scores) {
        myName = name;
        myHeight = height;
        myAge = age;
        myScores = scores;
        float sum = 0;
        for (int i = 0; i < myScores.length; i++) {
            sum += myScores[i];
        }
        myAverage = sum / 3;

    }

    // accessors
    public String getName() {
        return myName;
    }

    public int getAge() {
        return myAge;
    }

    public double getHeight() {
        return myHeight;
    }

    public float getMidScore() {
        return myScores[0];
    }

    public float getFinalScore() {
        return myScores[1];
    }

    public float getSoohangScore() {
        return myScores[2];
    }

    public float getAverage() {
        return myAverage;
    }

    public String getScoresByString() {
        String returnString = "";
        for (int i = 0; i < myScores.length; i++) {
            returnString += String.valueOf(myScores[i]);
            if (i != myScores.length - 1) {
                returnString += ", ";
            }
        }
        return returnString;
    }

    public static float getTotalAverage(Student[] st) {
        float sum = 0;
        for (int i = 0; i < st.length; i++) {
            sum += st[i].getAverage();
        }
        return sum / st.length;
    }

    public static float getTotalStandardDeviation(Student[] st) {
        float variance = 0, average = getTotalAverage(st);
        for (int i = 0; i < st.length; i++) {
            variance += (st[i].getAverage() - average) * (st[i].getAverage() - average);
        }
        variance /= st.length;
        return (float) Math.sqrt(variance);
    }

    // overloading
    public String toString() {
        return String.format("name : %s, age : %d, height : %f, scores : %s, avg : %f", myName, myAge, myHeight,
                getScoresByString(), getAverage());
    }

}

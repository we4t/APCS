import chn.util.*;

class StudentIndex {
    public static void main(String args[]) {
        FileInput filereader = new FileInput("D:/Programming/APCS/CH01/HW_OPEN_FILE/input.txt");
        int studentNumber = filereader.readInt(); // read how many students exists in current file
        int sortingMode = filereader.readInt(); // read the sorting criteria (1 : name, 2 : midScore,
                                                // 3 : finalScore, 4 : soohang, 5 : avg)
        boolean sortingValue = filereader.readInt() == 1 ? true : false; // 0 : ascending, 1 : descending
        final int testNumber = 3;

        Student[] apcs = new Student[studentNumber];
        for (int i = 0; i < studentNumber; i++) {
            String name = filereader.readToken();
            int age = filereader.readInt();
            double height = filereader.readDouble();
            float[] scores = new float[testNumber];
            for (int j = 0; j < testNumber; j++) {
                scores[j] = (float) filereader.readDouble();
            }
            apcs[i] = new Student(name, age, height, scores);
        }

        switch (sortingMode) {
            case 1:
                for (int i = 0; i < studentNumber; i++) {
                    String name = apcs[i].getName();
                    for (int j = 0; j < studentNumber - 1; j++) {
                        boolean compareValue = (name.compareTo(apcs[j].getName()) >= 0); // 1 : apcs[i].name >
                                                                                         // apcs[j].name,
                        // -1 : '' < ''
                        if (compareValue == sortingValue) {
                            Student tmp;
                            tmp = apcs[i];
                            apcs[i] = apcs[j];
                            apcs[j] = tmp;
                        }
                    }
                }
                break;

            case 2:
                for (int i = 0; i < studentNumber; i++) {
                    for (int j = 0; j < studentNumber - 1; j++) {
                        boolean compareValue = (apcs[i].getMidScore() - apcs[j].getMidScore() > 0);
                        if (compareValue == sortingValue) {
                            Student tmp;
                            tmp = apcs[i];
                            apcs[i] = apcs[j];
                            apcs[j] = tmp;
                        }
                    }
                }
                break;

            case 3:
                for (int i = 0; i < studentNumber; i++) {
                    for (int j = 0; j < studentNumber - 1; j++) {
                        boolean compareValue = (apcs[i].getFinalScore() - apcs[j].getFinalScore() > 0);
                        if (compareValue == sortingValue) {
                            Student tmp;
                            tmp = apcs[i];
                            apcs[i] = apcs[j];
                            apcs[j] = tmp;
                        }
                    }
                }
                break;

            case 4:
                for (int i = 0; i < studentNumber; i++) {
                    for (int j = 0; j < studentNumber - 1; j++) {
                        boolean compareValue = (apcs[i].getSoohangScore() - apcs[j].getSoohangScore() > 0);
                        if (compareValue == true) {
                            Student tmp;
                            tmp = apcs[i];
                            apcs[i] = apcs[j];
                            apcs[j] = tmp;
                        }
                    }
                }
                break;

            case 5:
                for (int i = 0; i < studentNumber; i++) {
                    for (int j = 0; j < studentNumber - 1; j++) {
                        boolean compareValue = (apcs[i].getAverage() - apcs[j].getAverage() > 0);
                        if (compareValue == sortingValue) {
                            Student tmp;
                            tmp = apcs[i];
                            apcs[i] = apcs[j];
                            apcs[j] = tmp;
                        }
                    }
                }
                break;
        }

        FileOutput fileWriter = new FileOutput("output.txt");
        fileWriter.println(studentNumber);
        fileWriter.println(sortingMode);

        for (int i = 0; i < apcs.length; i++) {
            String msg = String.valueOf(i + 1) + " ";
            msg += (apcs[i].toString());
            //byte[] tmpByte = msg.getBytes();
            //String msg_utf8 = new String(tmpByte, StandardCharsets.UTF_8);
            fileWriter.println(msg);
        }
        String indexOfScores = String.format("avg = %f, standard deviation = %f", Student.getTotalAverage(apcs),
                Student.getTotalStandardDeviation(apcs));
        //byte[] tmpByte = indexOfScores.getBytes();
        //String indexOfScores = new String(tmpByte, StandardCharsets.UTF_8);
        fileWriter.print(indexOfScores);
        fileWriter.close();
    }
}

class Student {
	private String myName;
	private int myAge;
	private float myHeight;
	private float[] myScores;
	public static int myStudentNum = 0;

	// constructors
	public Student() {
		this("Hong Gildong", 17, 180.0f, new float[] { 92.0f, 98.0f });
	}

	public Student(String name)
	{
		this(name, 18, 175.0f, new float[] { 95.0f, 98.0f });
	}

	public Student(String name, int age, float height, float[] scores)
	{
		myName = name;
		myAge = age;
		myHeight = height;
		myScores = new float[scores.length];
		for (int i = 0; i < scores.length; i++) {
			myScores[i] = scores[i];
		}
		myStudentNum++;
	}

	// accessors
	public String getName() {
		return myName;
	}

	public int getAge() {
		return myAge;
	}

	public float getHeight() {
		return myHeight;
	}

	public String getScoresByString() {
		String returnString ="";
		for (int i = 0; i < myScores.length; i++) {
			returnString += String.valueOf(myScores[i]);
			returnString += ", ";
		}
		return returnString;
	}

	public float[] getScoreByReference() {
		float[] a = new float[myScores.length];
		for(int i = 0; i < myScores.length; i++)
		{
			a[i] = myScores[i];
		}
		return a;
	}

	public float getAverage() {
		float totalscore = 0;
		for (int i = 0; i < myScores.length; i++) {
			totalscore += myScores[i];
		}
		return totalscore / myScores.length;
	}

	public static int findIndexByName(String Name, Student[] a) {
		int arrayleng = a.length;
		for (int i = 0; i < arrayleng; i++) {
			if (a[i].getName() == Name) {
				return i;
			}
		}
		return -1;
	}

	public void editScoreByName(Student st, String name, int scoreIndex, float newScore){

	}

	// modifiers
	public void setName(String name) {
		myName = name;
	}

	public void setAge(int age) {
		if (age >= 0 && age <= 120) {
			myAge = age;
			System.out.println("나이가" + myAge + "으로 설정됨");
		} else {
			System.out.println("나이는 음수이거나 120살 이상일 수 없음. 초기값 17로 저장함.");
			myAge = 17;
		}
	}

	public void setHeight(float height) {
		if (height >= 0) {
			myHeight = height;
			System.out.println("키가" + myHeight + "로 설정됨.");
		} else {
			System.out.println("키는 음수일 수 없음. 180cm로 설정함.");
			myHeight = 180.f;
		}
	}

	public void setScores(float[] a) {
		myScores = new float[a.length];
		for (int i = 0; i < a.length; i++) {
			myScores[i] = a[i];
		}
	}

	public void editScoreByIndex(Student st, int index, float score) {
		if (index >= 1 && index <= st.myScores.length) {
			st.myScores[index - 1] = score;
			System.out.println("수정 완료");
		} else {
			System.out.println("저장하고자 하는 성적의 순서가 잘못되었습니다.");
		}
	}

	public static int findStudentIndex(Student[] st, String name){
		for(int i = 0; i < st.length; i++)
		{
			if(st[i].getName() == name){
				return i;
			}
		}
		return -1;
	}


	// overloading
	public String toString() {
		return String.format("Student(%s, %d, %f, 점수들 : %s, 평균 : %f)", myName, myAge, myHeight, getScoresByString(), getAverage());
	}

}
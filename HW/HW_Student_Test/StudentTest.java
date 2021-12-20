import java.util.*;

class StudentTest {
	public static void main(String[] args) {
		// Initialize On/off boolean
		boolean onoff = true;

		// Initialize scanner
		Scanner sc = new Scanner(System.in);

		// Initialize array of students
		Student[] apcs = new Student[12];

		// Initialize Input Parameters
		String tmpName = " ", input;
		float tmpHeight = 0.0f, tmpMidScore = 0.0f, tmpFinalScore = 0.0f;
		int tmpAge = 0, tmpStIndex, tmpScoreNum; //

		// 학생 정보 입력
		while (onoff) {
			System.out.println(
					"학생 관리용 프로그램입니다. \n \n 원하는 옵션을 입력하세요. \n \n 1. 학생 정보 입력 2. 학생 정보 수정 3. 학생 정보 출력 4. 전체 학생 정보 출력 5. 프로그램 종료");
			input = sc.next();
			switch (input) {
				case "1": {
					System.out.println(
							"수정하고 싶은 정보를 이름, 나이, 키, 입력할 점수 수, 그리고 점수들을 차례로 입력해주세요.");
					tmpName = sc.next();
					tmpAge = sc.nextInt();
					tmpHeight = sc.nextFloat();
					tmpScoreNum = sc.nextInt();
					float[] a = new float[tmpScoreNum];
					for(int i = 0; i < tmpScoreNum; i++){
						float tmpScore = sc.nextFloat();
						a[i] = tmpScore;
					}
					apcs[Student.myStudentNum] = new Student(tmpName, tmpAge, tmpHeight, a);
					System.out.println("정보 입력이 완료되었습니다. 초기 메뉴로 돌아갑니다.");
					break;
				}

				case "2": {
					System.out.println("수정하고싶은 학생의 이름을 입력해주세요.");
					tmpName = sc.next();
					tmpStIndex = StudentTest.findStudentIndex(apcs, tmpName);
					if (tmpStIndex != -1 && tmpStIndex <= 11) {
						System.out.println(
								apcs[tmpStIndex] + "은 현재 입력한 학생의 정보입니다. 수정하고싶은 정보를 입력해주세요. \n \n 1. 키 2. 나이 3. 성적");
						int innerInput = sc.nextInt();
						if(innerInput == 3){
							System.out.println("수정하고싶은 성적의 순서와 성적을 차례대로 입력해주세요.");
							int tmpScoreIndex = sc.nextInt();
							float tmpScore = sc.nextFloat();
							editScoreByIndex(apcs[tmpStIndex], tmpScoreIndex, tmpScore);							
						}
						else if(innerInput == 1 || innerInput == 2){
							System.out.println("수정하고싶은 학생의 키와 나이를 입력해주세요.");
							String tmpInput = sc.next();
							editIndex(apcs[tmpStIndex], innerInput, tmpInput);
						}

					} else {
						System.out.println(
								"존재하지 않는 학생입니다. 메인 메뉴로 돌아갑니다.");
					}
					break;
				}

				case "3": {
					System.out.println("출력하고자하는 학생의 이름을 적어주세요");
					tmpName = sc.next();
					tmpStIndex = findName(tmpName, apcs);
					if (tmpStIndex != 0 && tmpStIndex <= 11) {
						System.out.println("학생의 정보는" + apcs[tmpStIndex] + "입니다");
					} else {
						System.out.println(
								"존재하지 않는 학생입니다. 메인 메뉴로 돌아갑니다.");
					}
					break;
				}

				case "4": {
					for(int i = 0; i < apcs.length; i++)
					{
						System.out.println(apcs[i]);
					}
					break;
				}

				case "5": {
					onoff = false;
					break;
				}
				default: {
					System.out.println("유효하지 않는 입력입니다. 메인 메뉴로 돌아갑니다.");
					break;
				}
			}
		}
	}
}
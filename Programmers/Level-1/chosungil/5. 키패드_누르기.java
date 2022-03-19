import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        Person person = new Person(hand);

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                person.left_finger = number;
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                person.right_finger = number;
            }
            else answer.append(person.pushCenterLine(number));
        }
        return answer.toString();
    }
}

class Person {
    int left_finger = 10;
    int right_finger = 11;
    int[] arrX = {3, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3}; // 키패드 x 좌표
    int[] arrY = {1, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 2}; // 키패드 y 좌표
    String lastHand = "";
    String hand;

    public Person(String hand) {
        this.hand = "left".equals(hand) ? "L" : "R";
    }

    // 가운데 라인(세로) 눌렀을 시
    String pushCenterLine(int push_number) {

        double left_distance = getDistance(
                arrX[push_number], arrY[push_number],
                arrX[left_finger], arrY[left_finger]
        );
        double right_distance = getDistance(
                arrX[push_number], arrY[push_number],
                arrX[right_finger], arrY[right_finger]
        );

        lastHand = left_distance == right_distance ? hand : left_distance < right_distance ? "L" : "R";

        if ("L".equals(lastHand)) {
            left_finger = push_number;
        } else {
            right_finger = push_number;
        }

        return lastHand;
    }

    // 거리
    private double getDistance(int pushX, int pushY, int fingerX, int fingerY) {
        double distance = 0.0;

        distance += Math.abs(pushX - fingerX);
        distance += Math.abs(pushY - fingerY);

        return distance;

    }
}

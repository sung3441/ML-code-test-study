import java.util.*;

public class Solution {

    HashMap<String, User> user_store; // 전체 유저 스토어

    static final int REPORTER_INDEX = 0;
    static final int BAD_USER_INDEX = 1;

    public int[] solution(String[] id_list, String[] report_list, int k) {

        user_store = new HashMap<>();

        saveId(id_list);

        saveReportHistory(report_list, k);

        receiveMailCntCal();

        return getAnswer(id_list);
    }

    // id 저장
    void saveId(String[] id_list) {
        for (String id : id_list) {
            User user = new User(id);
            user_store.put(user.getId(), user);
        }
    }

    // 신고 이력 저장
    void saveReportHistory(String[] report_list, int k) {
        // 중복 제거
        report_list = Arrays.stream(report_list).distinct().toArray(String[]::new);

        for (String report : report_list) {
            String[] users = report.split(" ");
            User reporter = user_store.get(users[REPORTER_INDEX]); // 0 신고자
            User bad_user = user_store.get(users[BAD_USER_INDEX]); // 1 신고 당한 사람

            reporter.addBadUser(bad_user); // 신고 이력에 추가
            bad_user.plusReportCnt();

            if (bad_user.getReportCnt() == k) {
                bad_user.setPauseUser(true);
            }

        }
    }

    // 유저가 받게 될 메일 수 계산
    void receiveMailCntCal() {
        for (String user_key : user_store.keySet()) {
            User user = user_store.get(user_key);
            Set<User> bad_user_store = user.getBad_user_store();

            for (User bad_user : bad_user_store) {
                 if (bad_user.isPauseUser()) {
                    user.plusReceiveMailCnt();
                }
            }
        }
    }

    // 정답 구하기
    int[] getAnswer(String[] id_list) {
        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            User user = user_store.get(id);
            answer[i] = user.getReceiveMailCnt();
        }
        return answer;
    }
}

class User {
    private final String id;
    private int reportCnt = 0; // 신고 당한 수
    private int receiveMailCnt = 0; // 받게 될 메일 수
    private boolean isPauseUser = false; // 정지 대상인지
    HashSet<User> bad_user_store = new HashSet<>(); // 신고한 유저 목록

    public User(String id) {
        this.id = id;
    }

    void addBadUser(User bad_user) {
        this.bad_user_store.add(bad_user);
    }

    void plusReportCnt() {
        this.reportCnt++;
    }

    void plusReceiveMailCnt() {
        this.receiveMailCnt++;
    }

    // Getter, Setter ==============================================================
    public String getId() {
        return id;
    }
    public int getReceiveMailCnt() {
        return receiveMailCnt;
    }
    public int getReportCnt() {
        return reportCnt;
    }
    public boolean isPauseUser() {
        return isPauseUser;
    }
    public void setPauseUser(boolean pauseUser) {
        isPauseUser = pauseUser;
    }
    public HashSet<User> getBad_user_store() {
        return bad_user_store;
    }
}

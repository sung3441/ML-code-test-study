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

// ==================================================================================================================================
// 2022/09/19 재풀이=================================================================================================================
// ==================================================================================================================================
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] solution(String[] id_list, String[] report_list, int k) {
        Map<String, Integer> userStore = getUserStore(id_list);
        Map<String, List<String>> reportUserStore = getReportUserStore(userStore, report_list);
        return getResult(id_list, userStore, reportUserStore, k);
    }

    // 전체 유저 저장소 생성
    public Map<String, Integer> getUserStore(String[] id_list) {

        Map<String, Integer> userStore = new HashMap<>();
        Arrays.stream(id_list)
                .forEach(id -> userStore.put(id, 0));

        return userStore;
    }

    // 신고자 저장소 생성 및 신고 이력 저장
    public Map<String, List<String>> getReportUserStore(Map<String, Integer> userStore, String[] report_list) {

        // 신고 이력 중복 제거
        report_list = Arrays.stream(report_list).distinct().toArray(String[]::new);

        // key: 신고자, value: 신고자가 신고한 목록
        Map<String, List<String>> reportUserStore = new HashMap<>();
        for (int i = 0; i < report_list.length; i++) {
            String reporter = report_list[i].split(" ")[0];
            String target = report_list[i].split(" ")[1];

            // 신고 당한 횟수 증가
            userStore.put(target, userStore.get(target) + 1);

            if (reportUserStore.containsKey(reporter)) {
                reportUserStore.get(reporter).add(target);
                continue;
            }
            reportUserStore.put(reporter, new ArrayList<>(Arrays.asList(target)));
        }
        return reportUserStore;
    }

    // 정답 구하기
    public int[] getResult(
            String[] id_list, Map<String, Integer> userStore,
            Map<String, List<String>> reportUserStore, int k) {

        int[] result = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            List<String> targetList = reportUserStore.get(id_list[i]);
            if (targetList == null)
                continue;
            result[i] = getMailCount(targetList, userStore, k);
        }
        return result;
    }

    // 신고자가 받게 될 메일 수 구하기
    public int getMailCount(List<String> targetList, Map<String, Integer> userStore, int k) {
        int mailCount = 0;
        for (String target : targetList) {
            if (userStore.get(target) >= k) {
                mailCount++;
            }
        }
        return mailCount;
    }
}

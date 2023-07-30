package Test;

class Solution {
  public int solution(String skill, String[] skill_trees) {
    int answer = 0;  
    int pin = 0;
    for (String skill_tree : skill_trees) {
      boolean possible = true;
      for(String s : skill_tree.split("")) {
        if(pin == skill.length()) {
          break;
        } else if(skill.indexOf(s) >= 0) {
          if(s.equals(skill.charAt(pin)+"")) {
            pin++;
          } else {
            possible = false;
            break;
          }
        }
      }
      if(possible) {
      answer++;
      }
      pin = 0;
    }
    return answer;
  }
}

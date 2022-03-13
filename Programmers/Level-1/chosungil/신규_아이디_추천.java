class Solution {
    public String solution(String new_id) {

        new_id = new_id
                .toLowerCase()
                .replaceAll("[^0-9a-z-_.]", "")
                .replaceAll("\\.{2,}", ".")
                .replaceAll("^\\.|\\.$", "");
        
        if (new_id.length() > 15) {   
            new_id = new_id
                    .substring(0, 15)
                    .replaceAll("\\.$", "");
        }
        
        if (new_id.length() < 1) return "aaa";
        
        if (new_id.length() < 3) {
            new_id += String.valueOf(new_id.charAt(new_id.length() - 1)).repeat(3 - new_id.length());
        }
        return new_id;
    }
}

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwitterHacking {

    public static String decrypt(String encrypted_message) {
        if (encrypted_message == null || encrypted_message.isEmpty()) {
            return null;
        }
        int n = encrypted_message.length();
        String endEncry = encrypted_message.substring(n - 18, n);
        System.out.println(endEncry);
        String endDecry = "Your friend, Alice";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < endEncry.length(); i++) {
            char cDecry = endDecry.charAt(i);
            char cEncry = endEncry.charAt(i);
            if (Character.isAlphabetic(cDecry)) {
                int k = Math.abs(cDecry - cEncry);
                if (k > 10) {
                    k = 26 - k;
                }
                sb.append(k);
            }
        }
        String key = findKey(sb.toString());
        //String key = "8251220";
        //System.out.println(key);
        int keyLen = key.length();
        int num = 0;
        sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char cEncry = encrypted_message.charAt(i);
            if (Character.isAlphabetic(cEncry)) {
                char cDecry = (char)(cEncry - (key.charAt(num % keyLen) - '0'));
                if (Character.isLowerCase(cEncry) && cDecry < 'a'
                        || Character.isUpperCase(cEncry) && cDecry < 'A') {
                    cDecry = (char)(cDecry + 26);
                }
                sb.append(cDecry);
                num++;
            } else {
                sb.append(cEncry);
            }
        }
        return sb.reverse().toString();
    }
    public static String findKey(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        Pattern p = Pattern.compile("(.+?)\\1+");
        Matcher m = p.matcher(sb.toString());
        
        String repeated;
        while (m.find()) {
            repeated = m.group(1);
            return repeated;
        }
        return null;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        
        String encrypted_message = "Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg";
        //String encrypted_message = "Atvt hrqgse, Cnikg";
        System.out.println(decrypt(encrypted_message));
//        String str = "251220825122082";
//        Pattern p = Pattern.compile("(.+?)\\1+");
//        Matcher m = p.matcher(str);
//        while (m.find()) {
//            String repeated = m.group(1);
//            System.out.println(repeated);
//        }
        
    }
    
}

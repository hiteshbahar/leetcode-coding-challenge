import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwitterMasking {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            while((input = br.readLine()) != null) {
                String[] words = input.split(":");
                StringBuilder sb = new StringBuilder();
                if (words[0].trim().equals("E")) { //words[1] is email.
                    String email = words[1].trim();
                    sb.append("E:");
                    sb.append(email.charAt(0));
                    sb.append("*****");
                    sb.append(email.substring(email.indexOf("@") - 1));
                } else if (words[0].trim().equals("P")){  // words[1] is phone
                    String phone = words[1].trim();
                    sb.append("P:");
                    char[] phoneArray = phone.toCharArray();
                    int num = 0;
                    for (int i = 0; i < phoneArray.length; i++) {
                        if (Character.isDigit(phoneArray[i])) {
                            num++;
                        }
                    }
                    if (num == 11) {
                        sb.append("+*-");
                    } else if (num == 12) {
                        sb.append("+**-");
                    } else if (num == 13) {
                        sb.append("+***-");
                    }
                    sb.append("***-***-");
                    sb.append(phone.substring(phone.length() - 4, phone.length()));
                }
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

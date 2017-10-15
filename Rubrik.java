import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Rubrik {
    
    class Contact {
        List<String> fieldsList;
        String name;
        boolean visited;
        
        Contact(List<String> fieldsList, String name, boolean visited) {
            this.fieldsList = fieldsList;
            this.name = name;
            this.visited = visited;
        }
    }
    
    // DFS find union
    Set<Contact> findUnion(Map<String, List<Contact>> map, Contact contact, Set<Contact> resultSet) {
        if(!contact.visited){
             contact.visited = true;
             resultSet.add(contact);
             for(String field : contact.fieldsList) {
                 for(Contact c : map.get(field)) {
                     if(!c.visited) {
                         resultSet.add(c);
                         findUnion(map, c, resultSet);
                     }
                 }
             }
        } 
        return resultSet;  
    }
    public static void main(String[] args) {
        Rubrik r = new Rubrik();
//        String[][] contacts =  {{"John", "john@gmail.com", "john@fb.com"}, 
//                                {"Dan", "dan@gmail.com", "+1234567"},
//                                {"john123", "5412312", "john123@skype.com"}, 
//                                {"john1985", "5412312", "john@fb.com"},
//                                {"john19856", "john123@skype.com", "john@fb1.com"},
//                                {"Dan2", "dan123@gmail.com", "+1234567"},
//                                {"Dan3", "dan@gmail.com", "+123456712312"},
//                                {"Sandy", "sandy@gmail.com", "+123456712"},
//                                {"sandy4", "sandy@fb.com", "sandy@gmail.com"}};
        
        String[][] contacts =  {{"John", "john@gmail.com", "john@fb.com"}, 
                {"Dan", "dan@gmail.com", "+1234567"},
                {"john123", "5412312", "john123@skype.com"}, 
                {"john1985", "5412312", "john@fb.com"}};
       
        List<Contact> wholeList = new ArrayList<Contact>();
        // construct list of Contact
        for(int i = 0 ; i < contacts.length; i++) {
            List<String> singleList = new ArrayList<String>();
            for(int j = 1 ; j < contacts[i].length; j++) {
                singleList.add(contacts[i][j]);
            }
            Contact contact = r.new Contact(singleList, contacts[i][0], false); 
            wholeList.add(contact);
        }
       
        Map<String, List<Contact>> map = new HashMap<String, List<Contact>>();
        // map each field to the Contact
        for(Contact contact : wholeList) {
            List<Contact> indexList = new ArrayList<Contact>();
            for(String field : contact.fieldsList) {
                if(map.containsKey(field)) {
                   indexList = map.get(field);
                   indexList.add(contact);
                   map.put(field, indexList); 
                } else {
                   indexList = new ArrayList<Contact>();
                   indexList.add(contact);
                   map.put(field, indexList);
                }
            }
        }
        
        List<Set<Contact>> resultList = new ArrayList<Set<Contact>>();
        for(List<Contact> list : map.values()) {
            Set<Contact> resultSet = new HashSet<Contact>();
            for(Contact c : list) {
                if(!c.visited) {
                    resultSet = r.findUnion(map, c, resultSet);
                }
            }        
            resultList.add(resultSet);
        }
       
       
        for(Set<Contact> contactSet: resultList) {
            if(contactSet.size() > 0) {
                for(Contact contact : contactSet) {
                    System.out.print(contact.name + ", ");
                }
                System.out.println();
            }
        }
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Rubrik {
    
    class Contact {
        List<String> contactList;
        String name;
        boolean visited;
        
        Contact(List<String> contactList, String name, boolean visited) {
            this.contactList = contactList;
            this.name = name;
            this.visited = visited;
        }
    }
    
    Set<Contact> findUnion(Map<String, List<Contact>> map, Contact cont, Set<Contact> resultSubList) {
        if(!cont.visited){
             cont.visited = true;
             resultSubList.add(cont);
             for(String contactListStr: cont.contactList) {
                 for(Contact c: map.get(contactListStr)) {
                     if(!c.visited) {
                         resultSubList.add(c);
                         findUnion(map, c, resultSubList);
                     }
                 }
             }
        } 
        return resultSubList;  
    }
    public static void main(String[] args) {
        Rubrik r = new Rubrik();
        String[][] contacts =  {{"John", "john@gmail.com", "john@fb.com"}, 
                                {"Dan", "dan@gmail.com", "+1234567"},
                                {"john123", "5412312", "john123@skype.com"}, 
                                {"john1985", "5412312", "john@fb.com"},
                                {"john19856", "john123@skype.com", "john@fb1.com"},
                                {"Dan2", "dan123@gmail.com", "+1234567"},
                                {"Dan3", "dan@gmail.com", "+123456712312"},
                                {"Sandy", "sandy@gmail.com", "+123456712"},
                                {"sandy4", "sandy@fb.com", "sandy@gmail.com"}};
       
        List<Contact> wholeList = new ArrayList<Contact>();
        // convert array to list of list
        for(int i = 0 ; i < contacts.length; i++) {
            List<String> singleList = new ArrayList<String>();
            for(int j = 1 ; j < contacts[i].length; j++) {
                singleList.add(contacts[i][j]);
            }
            Contact contact = r.new Contact(singleList, contacts[i][0], false); 
            wholeList.add(contact);
        }
       
        Map<String, List<Contact>> map = new HashMap<String, List<Contact>>();
        
        for(Contact c: wholeList) {
            List<Contact> indexList = new ArrayList<Contact>();
            for(String detail: c.contactList) {
                if(map.containsKey(detail)) {
                   indexList = map.get(detail);
                   indexList.add(c);
                   map.put(detail, indexList); 
                } else {
                   indexList = new ArrayList<Contact>();
                   indexList.add(c);
                   map.put(detail, indexList);
                }
            }
        }
        
        List<Set<Contact>> resultList = new ArrayList<Set<Contact>>();
        for(List<Contact> ls: map.values()) {
            Set<Contact> resultSubList = new HashSet<Contact>();
            for(Contact c : ls) {
                if(!c.visited) {
                    resultSubList = r.findUnion(map, c, resultSubList);
                }
            }        
            resultList.add(resultSubList);
        }
       
       
        for(Set<Contact> subList: resultList) {
            if(subList.size() > 0) {
                for(Contact co : subList) {
                    System.out.print(co.name + ", ");
                }
                System.out.println();
            }
        }
    }
}

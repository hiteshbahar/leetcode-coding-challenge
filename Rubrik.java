import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Rubrik {
    
    class Contact {
        List<String> fieldsList;
        int index;
        boolean visited;
        
        Contact(List<String> fieldsList, int i, boolean visited) {
            this.fieldsList = fieldsList;
            this.index = i;
            this.visited = visited;
        }
    }
    
    // DFS find union
    private void findUnion(Map<String, List<Contact>> map, Contact contact, List<Contact> subList) {
        if(!contact.visited) {
             contact.visited = true;
             subList.add(contact);
             for(String field : contact.fieldsList) {
                 for(Contact c : map.get(field)) {
                     if(!c.visited) {
                         findUnion(map, c, subList);
                     }
                 }
             }
        }  
    }
    public List<List<Contact>> findSameContacts(String[][] contacts) {
        List<Contact> wholeList = new ArrayList<Contact>();
        // construct list of Contact
        for(int i = 0 ; i < contacts.length; i++) {
            List<String> singleList = new ArrayList<String>();
            for(int j = 1 ; j < contacts[i].length; j++) {
                singleList.add(contacts[i][j]);
            }
            Contact contact = new Contact(singleList, i, false); 
            wholeList.add(contact);
        }
       
        Map<String, List<Contact>> map = new HashMap<String, List<Contact>>();
        // map each field to the Contact
        for(Contact contact : wholeList) {
            for(String field : contact.fieldsList) {
                List<Contact> indexList = map.getOrDefault(field, new ArrayList<Contact>());
                indexList.add(contact);
                map.put(field, indexList);
            }
        }
        
        List<List<Contact>> resultList = new ArrayList<List<Contact>>();
        for(List<Contact> list : map.values()) {
            List<Contact> subList = new ArrayList<Contact>();
            for(Contact c : list) {
                if(!c.visited) {
                    findUnion(map, c, subList);
                }
            }        
            resultList.add(subList);
        }
        return resultList;
    }
    
    /**
     * Minesweeper Game
     * http://minesweeperonline.com/
     *
     * 1) Game should take in a pre-populated matrix representing a minesweeper board like:
     * 
     *    B X B X         B = bomb
     *    B B X X         X = no bomb
     *    X B X X
     *    B X X X
     *
     * 2) Expose function clickTile(row, col) which clicks the tile and returns information about
     *    the clicked tile (and surrounding tiles) that satisfies the following:
     *  
     *    - If neighboring bombs, return the # surrounding bombs
     *    - If no neighboring bombs, return set of surrounding tiles with 
     *      neighboring bombs (and count of bombs)
     *    - If bomb clicked, indicate to player they lose
     *    - Should keep track of which tiles have been clicked
     *
     *    Example Calls:
     *     clickTile(0, 1) -> count of 4
     *     clickTile(3, 3) -> (3, 2) has 1 surrounding bomb
     *                               (3, 3) has 0 surrounding bombs
     *                               (2, 2) has 2 surrounding bombs
     *                               (2, 3) has 0 surrounding bombs
     *              (1, 2) has 2 surrounding bombs 
     *               (1, 3) has 1 surrounding bomb
     *
     */

    class Point {
      int x;
      int y;
      int count;
      Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
      }
    } 
    class ReturnType {
      boolean isAlive;
      List<Point> surroundings;
      ReturnType(boolean isAlive) {
        this.isAlive = isAlive;
        this.surroundings = new ArrayList<>();
      }
    }

    class Minesweeper {
      private final int[][] dirs = {
        { -1, -1 }, { -1, 0 }, { -1, 1 },
        { 0, -1 }, { 0, 1 },
        { 1, -1 }, { 1, 0 }, { 1, 1 }
      };
      
      private char[][] matrix;
      private int m;
      private int n;
      
      public Minesweeper(char[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
      }
      
      public ReturnType clickTile(int row, int col) {
        if (matrix[row][col] == 'B') {
          return new ReturnType(false);
        }
        
        int count = countNeighbors(row, col);
        if (count > 0) {
          Point here = new Point(row, col, count);
          ReturnType res = new ReturnType(true);
          res.surroundings.add(here);
          return res;
        }
        
        boolean[][] visited = new boolean[m][n];
        List<Point> surroundings = new ArrayList<>();
        visited[row][col] = true;
        dfs(row, col, visited, surroundings);
        
        ReturnType res = new ReturnType(true);
        res.surroundings = surroundings;
        return res;
      }
      
      private int countNeighbors(int x, int y) {
        int count = 0;
        for (int[] dir : dirs) {
          int xx = x + dir[0];
          int yy = y + dir[1];
          
          if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
            continue;
          }
          
          if (matrix[xx][yy] == 'B') {
            count++;
          }
        }
        return count;
      }
      
      private void dfs(int x, int y, boolean[][] visited, List<Point> surroundings) {
        int count = countNeighbors(x, y);
        if (count > 0) {
          Point point = new Point(x, y, count);
          surroundings.add(point);
        }
        for (int[] dir : dirs) {
          int xx = x + dir[0];
          int yy = y + dir[1];
          
          if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy] || matrix[xx][yy] == 'B') {
            continue;
          }
          
          visited[xx][yy] = true;
          dfs(xx, yy, visited, surroundings);
        }
      }
      
//      public void markTileAsBomb(row, col);
//      public boolean hasWon();
    }

    public static void main(String[] args) {
        Rubrik r = new Rubrik();
        /**
         * Find same contacts
         */
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
       
        List<List<Contact>> resultList = r.findSameContacts(contacts);
       
        for(List<Contact> contactList : resultList) {
            if(contactList.size() > 0) {
                for(Contact contact : contactList) {
                    System.out.print(contact.index + ", ");
                }
                System.out.println();
            }
        }
        
        /**
         * 
         */
    }
}

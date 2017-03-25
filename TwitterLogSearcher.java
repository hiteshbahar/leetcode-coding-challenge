import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * You have a large log file. Each log
 * entry has the date and time and a log 
 * message in some simple format.
 * Some messages are multi-line.
 * Find all log messages with timestamps
 * within a specific time range.
 * @author xinwang
 *
 */
public class TwitterLogSearcher {

    public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate) {
        if (logLines == null) {
            return null;
        }
        List<String> result = new ArrayList<String>();
        for (String line : logLines) {
            String[] words = line.split("\\s");
            LocalTime time = LocalTime.parse(words[0], DateTimeFormatter.ISO_DATE_TIME);
            if (time.compareTo(startDate) >= 0 && time.compareTo(endDate) < 0) {
                result.add(line);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TwitterLogSearcher tls = new TwitterLogSearcher();
        List<String> logs = new ArrayList<String>();
        logs.add("2016-02-12T03:21:54Z  Program x did operation y successfully.");
        logs.add("2016-02-12T03:21:56Z  Program x did operation y successfully.");
        logs.add("2016-02-12T03:21:57Z  Program x did operation y successfully.");
        logs.add("2016-02-12T03:21:58Z  Program x did operation y successfully.");
        logs.add("2016-02-12T03:21:59Z  Program x did operation y successfully.");
        logs.add("2016-02-12T03:22:01Z  Program x did operation y successfully.");
        logs.add("2016-02-12T03:22:02Z  Program x did operation y successfully.");
        logs.add("2016-02-12T03:22:03Z  Program x did operation y successfully.");
        LocalTime startDate = LocalTime.parse("2016-02-12T03:21:56Z", DateTimeFormatter.ISO_DATE_TIME);
        LocalTime endDate = LocalTime.parse("2016-02-12T03:22:02Z", DateTimeFormatter.ISO_DATE_TIME);
        Collection<String> range = tls.search(logs, startDate, endDate);
        for (String s : range) {
            System.out.println(s);
        }

    }

}

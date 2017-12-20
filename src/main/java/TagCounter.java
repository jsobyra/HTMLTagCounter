import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;

public class TagCounter {
    private Map<TagKey, Integer> tagsInHtmls= new HashMap<>();

    public boolean store(String url){
        try{
            System.out.println("Storing in progress!!!");
            Document doc = Jsoup.connect(url).get();
            doc.getAllElements().forEach(tag -> {
                Integer count = tagsInHtmls.get(new TagKey(url, tag.tagName()));
                tagsInHtmls.put(new TagKey(url, tag.tagName()), (count == null) ? 1 : count + 1);
            });
        } catch (IOException e){
            System.err.println("Problem with connecting to given url: " + url);
            return false;
        } catch (IllegalArgumentException e){
            System.err.println("Problem with given url: " + url);
            return false;
        }

        return true;
    }

    public int retrieve(String url, String tagName){
        return tagsInHtmls.getOrDefault(new TagKey(url, tagName), 0);
    }
}

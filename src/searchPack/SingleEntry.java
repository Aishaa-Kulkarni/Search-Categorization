package searchPack;


import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class SingleEntry implements Serializable {
    public String id;
    public String title;
    public String link;
    public String summary;

    public SingleEntry() {
        id = "";
        title = "";
        link = "";
        summary = "";
    }

    public SingleEntry(String id, String title, String link, String summary) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.summary = summary;
    }
    
    
}

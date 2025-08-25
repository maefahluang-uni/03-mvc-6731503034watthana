package th.mfu;

import java.util.Date;

public class Concert {
    private int id;
    private String title;
    private String description;
    private Date date;

    // ✅ Default constructor (ต้องมี)
    public Concert() {}

    // ✅ Constructor ใช้ใน test (title, description)
    public Concert(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // ✅ Constructor เต็ม (ใช้ใน production)
    public Concert(int id, String title, String description, Date date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    // ===== Getters & Setters =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}


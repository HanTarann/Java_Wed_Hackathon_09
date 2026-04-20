package ra.edu.hackathon09.model.entity;

public class GameDisk {
    private long id;
    private String title;
    private String genre;
    private int quantity;

    public GameDisk() {
    }

    public GameDisk(int quantity, long id, String title, String genre) {
        this.quantity = quantity;
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

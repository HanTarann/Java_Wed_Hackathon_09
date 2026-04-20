package ra.edu.hackathon09.model.entity;

public class GameDisk {
    private long id;
    private String title;
    private String genre;
    private int quantity;
    private String image;

    public GameDisk() {
    }

    public GameDisk(long id, String title, String genre, int quantity, String image) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.quantity = quantity;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
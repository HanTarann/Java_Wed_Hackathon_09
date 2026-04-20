package ra.edu.hackathon09.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GameDiskDTO {

    private long id;
    @NotBlank(message = "Chi tu 3-100 ky tu")
    private String title;
    @NotNull(message = "Khong duoc de trong")
    private String genre;
    @Min(0)
    private int quantity;
    
    private String coverlmage;

    public GameDiskDTO() {
    }

    public GameDiskDTO(int quantity, long id, String title, String genre, String coverlmage) {
        this.quantity = quantity;
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.coverlmage = coverlmage;
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

    public String getCoverlmage() {
        return this.coverlmage;
    }

    public void setCoverlmage(String coverlmage) {
        this.coverlmage = coverlmage;
    }
}

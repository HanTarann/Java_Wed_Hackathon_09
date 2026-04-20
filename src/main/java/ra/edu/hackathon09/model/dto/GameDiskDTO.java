package ra.edu.hackathon09.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class GameDiskDTO {
    private Long id;

    @NotBlank(message = "Title không được để trống")
    @Size(min = 3, max = 100, message = "Title từ 3 đến 100 ký tự")
    private String title;

    @NotBlank(message = "Genre không được để trống")
    private String genre;

    @Min(value = 1, message = "Quantity phải lớn hơn 0")
    private int quantity;

    // 🔥 FIX Ở ĐÂY: đổi sang coverImage cho khớp Spring binding
    private MultipartFile coverImage;

    public GameDiskDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public MultipartFile getCoverImage() {
        return this.coverImage;
    }

    public void setCoverImage(MultipartFile coverImage) {
        this.coverImage = coverImage;
    }
}
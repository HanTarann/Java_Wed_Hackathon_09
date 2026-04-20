package ra.edu.hackathon09.repository.impl;

import org.springframework.stereotype.Repository;
import ra.edu.hackathon09.model.entity.GameDisk;
import ra.edu.hackathon09.repository.GameDiskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GameDiskRepositoryImpl implements GameDiskRepository {
    private static final List<GameDisk> list = new ArrayList<>();
    private static long idCounter = 1;

    static {
        list.add(new GameDisk(idCounter++, "Grand Theft Auto V", "Hành động", 10, ""));
        list.add(new GameDisk(idCounter++, "FIFA 24", "Thể thao", 5, ""));
        list.add(new GameDisk(idCounter++, "Minecraft", "Sinh tồn", 20, ""));
        list.add(new GameDisk(idCounter++, "Liên Minh Huyền Thoại", "MOBA", 15, ""));
        list.add(new GameDisk(idCounter++, "Call of Duty", "Bắn súng", 8, ""));
    }

    @Override
    public List<GameDisk> findAll() {
        return list;
    }

    @Override
    public GameDisk findById(long id) {
        return list.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(GameDisk gameDisk) {
        gameDisk.setId(idCounter++);
        list.add(gameDisk);
    }

    @Override
    public void update(GameDisk gameDisk) {
        GameDisk old = findById(gameDisk.getId());
        if (old != null) {
            old.setTitle(gameDisk.getTitle());
            old.setGenre(gameDisk.getGenre());
            old.setQuantity(gameDisk.getQuantity());
            old.setImage(gameDisk.getImage());
        }
    }

    @Override
    public void delete(long id) {
        list.removeIf(g -> g.getId() == id);
    }

    @Override
    public List<GameDisk> search(String title, String genre) {
        return list.stream().filter(g -> (title == null || title.isEmpty() || g.getTitle().toLowerCase().contains(title.toLowerCase())) && (genre == null || genre.isEmpty() || g.getGenre().equalsIgnoreCase(genre)))
                .collect(Collectors.toList());
    }
}
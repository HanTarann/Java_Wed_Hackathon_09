package ra.edu.hackathon09.repository.impl;

import ra.edu.hackathon09.model.entity.GameDisk;
import ra.edu.hackathon09.repository.GameDiskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameDiskRepositoryImpl implements GameDiskRepository {
    private static final List<GameDisk> gameDisk = new ArrayList<>();
    private static Long idCounter = 1L;

    private final GameDiskRepository gameDiskRepository;
    public GameDiskRepositoryImpl(GameDiskRepository gameDiskRepository) {
        this.gameDiskRepository = gameDiskRepository;
    }

    @Override
    public List<GameDisk> findAll() {
        return gameDisk;
    }

    @Override
    public GameDisk findById(Long id) {
        return gameDisk.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(GameDisk gameDisk) {
        gameDisk.setId(idCounter++);
        gameDisk.add(gameDisk);
    }

    @Override
    public void update(GameDisk gameDisk) {

        GameDisk old = this.findById(gameDisk.getId());

        if(old != null){
            old.setTitle(gameDisk.getTitle());
            old.setGenre(gameDisk.getGenre());
            old.setGenre(gameDisk.getGenre());
            old.setQuantity(gameDisk.getQuantity());
        }
    }

    @Override
    public void delete(Long id) {
        gameDisk.removeIf(m -> m.getId().equals(id));
    }

    @Override
    public List<GameDisk> search(String keyword, String position) {

        return gameDisk.stream()
                .filter(m ->
                        (keyword == null || m.getTitle().toLowerCase().contains(keyword.toLowerCase())
                )
                .collect(Collectors.toList());
    }
}
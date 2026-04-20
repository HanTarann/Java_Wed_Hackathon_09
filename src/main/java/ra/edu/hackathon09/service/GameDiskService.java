package ra.edu.hackathon09.service;

import ra.edu.hackathon09.model.entity.GameDisk;

import java.util.List;

public interface GameDiskService {
    List<GameDisk> findAll();
    GameDisk findById(GameDisk Long id);
    void save(GameDisk gameDisk );
    void update(GameDisk gameDisk );
    void delete(Long id);
    List<GameDisk> search(String keyword, String position);
}

package ra.edu.hackathon09.service;

import ra.edu.hackathon09.model.entity.GameDisk;

import java.util.List;

public interface GameDiskService {
    List<GameDisk> findAll();
    GameDisk findById(long id);
    void save(GameDisk gameDisk);
    void update(GameDisk gameDisk);
    void delete(long id);
    List<GameDisk> search(String title, String genre);
}
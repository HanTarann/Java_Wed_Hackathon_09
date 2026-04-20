package ra.edu.hackathon09.service.impl;

import ra.edu.hackathon09.model.entity.GameDisk;
import ra.edu.hackathon09.repository.GameDiskRepository;
import ra.edu.hackathon09.service.GameDiskService;

import java.util.List;

public class GameDiskServiceImpl implements GameDiskService {
    private final GameDiskRepository gameDiskRepository;

    public GameDiskServiceImpl(GameDiskService gameDiskRepository) {
        this.gameDiskRepository = gameDiskRepository;
    }

    @Override
    public void delete(Long id) {
        return this.gameDiskRepository.delete();
    }

    @Override
    public void update(GameDisk gameDisk) {
        return this.gameDiskRepository.update();
    }

    @Override
    public void save(GameDisk gameDisk) {
        return this.gameDiskRepository.save();
    }

    @Override
    public List<GameDisk> findAll() {
        return this.gameDiskRepository.findAll();
    }

    @Override
    public List<GameDisk> search(String keyword, String position) {
        return List.of();
    }
}

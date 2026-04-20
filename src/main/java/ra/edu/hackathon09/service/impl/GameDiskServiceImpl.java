package ra.edu.hackathon09.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.hackathon09.model.entity.GameDisk;
import ra.edu.hackathon09.repository.GameDiskRepository;
import ra.edu.hackathon09.service.GameDiskService;

import java.util.List;

@Service
public class GameDiskServiceImpl implements GameDiskService {
    @Autowired
    private GameDiskRepository repository;

    @Override
    public List<GameDisk> findAll() {
        return repository.findAll();
    }

    @Override
    public GameDisk findById(long id) {
        return repository.findById(id);
    }

    @Override
    public void save(GameDisk gameDisk) {
        repository.save(gameDisk);
    }

    @Override
    public void update(GameDisk gameDisk) {
        repository.update(gameDisk);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public List<GameDisk> search(String title, String genre) {
        return repository.search(title, genre);
    }
}
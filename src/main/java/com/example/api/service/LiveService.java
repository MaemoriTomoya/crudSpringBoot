package com.example.api.service;

import com.example.api.model.Live;
import com.example.api.repository.LiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LiveService {
    @Autowired
    LiveRepository liveRepository;

    public Live postLive(Live live) {
        return liveRepository.save(live);
    }

    public List<Live> getLive() {
        return liveRepository.findAll();
    }

    public Live updateLive(Live live) {
        return liveRepository.save(live);
    }

    public void deleteLive(Integer id) {
        liveRepository.deleteById(id);
    }
}
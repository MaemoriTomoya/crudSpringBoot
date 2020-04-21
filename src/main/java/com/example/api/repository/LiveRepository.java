package com.example.api.repository;

import com.example.api.model.Live;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiveRepository extends JpaRepository<Live, Integer> {}
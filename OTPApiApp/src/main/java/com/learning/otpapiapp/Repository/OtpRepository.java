package com.learning.otpapiapp.Repository;

import com.learning.otpapiapp.Model.OtpData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<OtpData, Integer> {
    Optional<OtpData> findByEmail(String email);
}

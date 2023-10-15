package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findBuddyInfoByBuddyName(String buddyName);

    BuddyInfo findById(long l);
}

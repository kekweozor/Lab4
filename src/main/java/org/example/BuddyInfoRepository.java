package org.example;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddies", path = "buddies")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    List<BuddyInfo> findByAddress(String address);
    List<BuddyInfo> findByName(String name);
    BuddyInfo findById(int id);
}

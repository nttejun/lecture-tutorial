package entity.relation.boot.repository;

import entity.relation.boot.domain.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long>{
}

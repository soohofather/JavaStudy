package com.example.memorydb.user.db;

import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // SELECT * FROM USER WHERE SCORE >  [??]
    public List<UserEntity> findAllByScoreGreaterThan(int score);

    // SELECT * FROM USER WHERE SCORE >=  AND score <= ??
    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    @Query(
            "select u from user u where u.score >= :min2 AND u.score <= :max2"
    )
    List<UserEntity> score(
            @Param(value = "min2") int min2,
            @Param(value = "max2") int max2
    );

}

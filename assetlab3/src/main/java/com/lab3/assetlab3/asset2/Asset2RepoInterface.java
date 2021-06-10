package com.lab3.assetlab3.asset2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Asset2RepoInterface extends CrudRepository<Asset2, Long>{
    
}

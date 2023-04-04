package com.fptaptech.lab3.repository.impl;

import com.fptaptech.lab3.model.FileStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStoreRepository extends JpaRepository<FileStore,Long> {

}

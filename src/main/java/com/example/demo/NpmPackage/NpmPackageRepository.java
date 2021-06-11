package com.example.demo.NpmPackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpmPackageRepository extends JpaRepository<NpmPackage, Long> {}

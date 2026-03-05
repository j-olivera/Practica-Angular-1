package com.component.pc.infrasctructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentPcJpaRepository extends JpaRepository<ComponentPcEntity, Long> {
}

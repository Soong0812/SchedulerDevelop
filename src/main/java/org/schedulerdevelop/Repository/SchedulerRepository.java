package org.schedulerdevelop.Repository;

import org.schedulerdevelop.Entity.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<Scheduler,Long> {
}

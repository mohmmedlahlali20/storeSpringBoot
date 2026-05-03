package org.codewithmohamed.stores.repositories;

import org.codewithmohamed.stores.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

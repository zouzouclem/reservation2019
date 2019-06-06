package be.icc.reservation.repository;

import be.icc.reservation.entity.Shows;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShowRepository extends PagingAndSortingRepository<Shows, Integer> {

    Shows findById(int id);
}


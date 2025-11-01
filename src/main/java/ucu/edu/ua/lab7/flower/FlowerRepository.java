package ucu.edu.ua.lab7.flower;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower, Long> {

    Optional<Flower> findByColor(FlowerColor color);

}

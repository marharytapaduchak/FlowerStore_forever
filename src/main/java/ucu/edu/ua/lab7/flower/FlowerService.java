package ucu.edu.ua.lab7.flower;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FlowerService {
    private FlowerRepository flowerRepository;

    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getFlowers(){
        return flowerRepository.findAll();
    }

    public void addFlower(Flower flower) {
    if (flowerRepository.findByColor(flower.getColor()).isEmpty()) {
        flowerRepository.save(flower);
    }
	}
}

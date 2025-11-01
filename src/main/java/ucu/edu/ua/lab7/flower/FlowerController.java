package ucu.edu.ua.lab7.flower;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/flower")
public class FlowerController {
	private final FlowerService flowerService;

	@Autowired
	public FlowerController(FlowerService flowerService) {
		this.flowerService = flowerService;
	}

	@GetMapping
	public List<Flower> getFlowers(){
		return flowerService.getFlowers();
	}

	@PostMapping
	public void addFlower(@RequestBody Flower flower) {
		flowerService.addFlower(flower);
	}
	
}

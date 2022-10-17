package komal.example.redisController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import komal.example.entity.Product;
import komal.example.redisREpository.ProductDao;

@RestController
@RequestMapping("/product")
public class RedisController {
	
	@Autowired
	private ProductDao productDao;
	
	@PostMapping("/post")
	public Product save(@RequestBody Product product) {
		return productDao.save(product);
	}
	
	@GetMapping("/get")
	public List<Object> getAllProduct(){
		return productDao.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findProduct(@PathVariable Long id) {
		return productDao.FindProductById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable Long id) {
		return productDao.DeleteProduct(id);
	}
}

package  com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
@RestController
@RequestMapping(path = "/products")
public class ProductResource {

    private ProductRepository productRepository;

    public ProductResource(ProductRepository productRepository){
        super();
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = new ArrayList<>();
        products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable Integer id){
        Optional<Product> product;
        try {
            product = productRepository.findById(id);
            return new ResponseEntity<Optional<Product>>(product, HttpStatus.OK);
        }catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Product>>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Product>> deleteByID(@PathVariable Integer id){
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<Optional<Product>>(HttpStatus.OK);
        }catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Product>>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product newProduct){
        return productRepository.findById(id)
                .map(product -> {
                    product.setType(newProduct.getType());
                    product.setPrice(newProduct.getPrice());
                    product.setQuantity(newProduct.getQuantity());
                    Product productUpdated = productRepository.save(product);
                    return ResponseEntity.ok().body(productUpdated);
                }).orElse(ResponseEntity.notFound().build());

    }
}



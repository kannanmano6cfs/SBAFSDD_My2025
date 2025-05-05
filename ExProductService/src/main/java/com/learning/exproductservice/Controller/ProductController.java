package com.learning.exproductservice.Controller;

import com.learning.exproductservice.Model.Product;
import com.learning.exproductservice.Repository.ProductRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Environment environment;

    //Get Methods in REST
    @GetMapping("/welcome")
    public String welcome() {
        return environment.getProperty("welcome.msg");
    }

    @RequestMapping(path="/index", method= RequestMethod.GET)
    public String index(){
        return "Welcome to the Product Service-Home Page";
    }

    @GetMapping("/count")
    public ResponseEntity<String> count(){
        long count=productRepository.count();
        return new ResponseEntity<>("Number of products is:"+count, HttpStatus.OK);
    }

    @GetMapping("/products")
    public Iterable<Product> products(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){
        Optional<Product> product=productRepository.findById(id);
        return product.orElse(null);
    }

    @GetMapping("/productt")
    public Product getProductt(@RequestParam int id){
        Optional<Product> product=productRepository.findById(id);
        return product.orElse(null);
    }

    @GetMapping("/producttt")
    public Product getProducttt(@RequestParam String prdname){
        Optional<Product> product=productRepository.findByPrdname(prdname);
        return product.orElse(null);
    }
    //Pagination
    @GetMapping("/productss")
    public Page<Product> getallproducts(@PageableDefault(size=2) Pageable pageable){
        return productRepository.findAll(pageable);
    }

    //Filtering
    @GetMapping("/search")
    public ResponseEntity<Page<Product>> search(@RequestParam(required = true) String prdname,Pageable pageable){
        return ResponseEntity.ok(productRepository.findByPrdnameContainingIgnoreCase(prdname,pageable));
    }

    //Post Methods in REST

    @PostMapping("/addproduct")
    public ResponseEntity<String> addProduct(){
        Product product=new Product();
        product.setPrdname("Apple 14");
        product.setPrddesc("Apple Smart mobile device");
        product.setPrdprice("45000");
        product.setCount(10);
        productRepository.save(product);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/addproduct1")
    public ResponseEntity<String> addProduct1(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }

    //Put Method in REST
    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product){
        Product product1=productRepository.findById(id).orElseThrow();
        product1.setPrdname(product.getPrdname());
        product1.setPrddesc(product.getPrddesc());
        product1.setPrdprice(product.getPrdprice());
        product1.setCount(product.getCount());
        productRepository.save(product1);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    //Delete Method in REST
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        productRepository.deleteById(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }



}

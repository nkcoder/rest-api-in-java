package my.playground.merchantapi.product;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("")
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> allProducts = productService.getAllProducts();
    return new ResponseEntity<>(allProducts, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
    Product product = productService.getProductById(id)
        .orElseThrow(() -> new ProductNotFoundException("product not found: " + id));
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

}
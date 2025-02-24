package com.excel.exposingAPI.controller;
        import com.excel.exposingAPI.model.Product;
        import com.excel.exposingAPI.service.ProductService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // web endpoints
    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.findPaginated(pageable);

        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("size", size);
        return "home";
    }

    @GetMapping("/add-product")
    public String showAddProductPage() {
        return "add-product";
    }

    @GetMapping("/update-product/{id}")
    public String showUpdatePage(@PathVariable Long id, Model model) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
        model.addAttribute("product", product);
        return "update-product";
    }

    @PostMapping("/products/create")
    public String createProduct(@RequestParam String name, @RequestParam double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.save(product);
        return "redirect:/";
    }

    @PostMapping("products/update/{id}")
    public String updateProduct(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam double price) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
        product.setName(name);
        product.setPrice(price);
        productService.save(product);
        return "redirect:/";
    }

    // REST API endpoints
    @GetMapping("/api/products/{id}")
    @ResponseBody
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/products")
    @ResponseBody
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping("/api/products")
    @ResponseBody
    public ResponseEntity<Product> createProductApi(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("/api/products/{id}")
    @ResponseBody
    public ResponseEntity<Product> updateProductApi(
            @PathVariable Long id,
            @RequestBody Product product) {
        return productService.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setPrice(product.getPrice());
                    return ResponseEntity.ok(productService.save(existingProduct));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/api/products/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productService.findById(id).isPresent()) {
            productService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
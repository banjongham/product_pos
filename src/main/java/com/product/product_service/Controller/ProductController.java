package com.product.product_service.Controller;

import com.product.product_service.Common.CommonRs;
import com.product.product_service.Request.ProductRequest;
import com.product.product_service.Response.ProductCommonResponse;
import com.product.product_service.Response.ProductResponse;
import com.product.product_service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "v1/products")
public class ProductController {
    private final RestTemplate restTemplate;

    @Autowired
    public ProductController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<CommonRs<List<ProductResponse>>> getProductAll() {
        CommonRs<List<ProductResponse>> productResponse = new CommonRs<>();
        productResponse.setData(productService.getProductAll());
        return ResponseEntity.ok(productResponse);
    }

    @PostMapping("/save")
    public ProductCommonResponse saveProduct(@RequestBody ProductRequest request){
        return productService.saveProduct(request);
    }

    @PostMapping("/update")
    public ProductCommonResponse updateProduct(@RequestBody ProductRequest request){
        return productService.updateProduct(request);
    }

    @PostMapping("/delete")
    public ProductCommonResponse deleteProduct(@RequestBody ProductRequest request){
        return productService.deleteProduct(request);
    }

    @GetMapping("/getCountText")
    public int getCountText(){
        String text = "The head of Singapore Airlines has apologised after a flight on Tuesday was hit by severe extreme turbulence, killing one person and injuring dozens.\n" +
                "Goh Choon Phong said the airline was very sorry for the traumatic experience for those onboard  SQ321 from London to Singapore.\n" +
                "The  was forced to make an emergency landing in the Thai capital Bangkok.\n" +
                "Smitivej Hospital, in Bangkok, said 104 people were treated and 58 remain in hospital, 20 of whom are in the intensive care unit.\n" +
                "There are 15 Britons still being treated in hospital, with six in intensive care, the hospital said.\n" +
                "A relief  carrying the remaining passengers and crew members arrived in Singapore early on Wednesday.\n" +
                "The plane, which had 211 passengers and 18 crew members onboard, hit severe turbulence over the Indian Ocean and dropped more than 6,000 feet (1800m) in three minutes.";
        String wordToCount = "flight";
        return countWord(text, wordToCount);
    }

    public static int countWord(String text, String word) {
        String lowerCaseText = text.toLowerCase();
        String lowerCaseWord = word.toLowerCase();
        String[] words = lowerCaseText.split("\\s+");
        int count = 0;
        for (String w : words) {
            if (w.equals(lowerCaseWord)) {
                count++;
            }
        }
        return count;
    }

    @GetMapping("/findNumber")
    public int findNumber(){
        int[] numbers = {18, 0, -3, 66, 28, 9, -70, 120};
        int targetValue = 9;
        int result = findValue(numbers, targetValue);
        return result;
    }

    public static int findValue(int[] array, int target) {
        for (int value : array) {
            if (value == target) {
                return value;
            }
        }
        return -1;
    }

//    @GetMapping(value = "/product")
//    public String getProduct() {
//        String url = "http://INVENTORY-SERVICE/products/inventory";
//        int inventory =  restTemplate.getForObject(url, Integer.class);
//        return "Server 1, SKU= 123, name=Soap, inventory = " + inventory;
//    }
//
//
//    @GetMapping("/search")
//    public ProductResponse getProductsByTypeAndName(@RequestParam(value = "sku") final String sku) {
//        String url = "http://INVENTORY-SERVICE/products/price?sku=" + sku;
//        return restTemplate.getForObject(url, ProductResponse.class);
//    }

}

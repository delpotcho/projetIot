package org.eheio.projet.iot.controller;

import org.eheio.projet.iot.dto.response.ProductDto;
import org.eheio.projet.iot.dto.response.ResponseMessage;
import org.eheio.projet.iot.model.Produit;
import org.eheio.projet.iot.service.ProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private ModelMapper modelMapper;


    //test
//    @GetMapping("/date")
//    public ResponseEntity<ResponseMessage> getDateNow(){
//        ResponseMessage msg=  new ResponseMessage(LocalDateTime.now().toString(),HttpStatus.OK);
//
//        return  ResponseEntity.ok().body(msg);
//    }
    @PostMapping("/new")
    public ResponseEntity<ResponseMessage> addProduct(@RequestBody ProductDto productDto) {

        if (productDto != null) {
            Produit produit = modelMapper.map(productDto, Produit.class);
            System.out.println(produit.getEnvironment().getID());
            if(produit.getEnvironment().getID()==null){
                return ResponseEntity.badRequest().body(new ResponseMessage("Environment Not Found",HttpStatus.BAD_REQUEST));
            }
            produitService.addProduit(produit);
           return ResponseEntity.ok().body(new ResponseMessage("product added",HttpStatus.CREATED));
        } else {
            return ResponseEntity.badRequest().body(new ResponseMessage("somthing wrong",HttpStatus.BAD_REQUEST));
        }

    }

    @GetMapping("/")
    public List<ProductDto> getAllProduct() {
        List<Produit> products = produitService.getAllProduits();
        List<ProductDto> productsDto= products.stream().map((p) -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
        return productsDto;
    }

    @GetMapping("product/{productId}")
    public ProductDto getProductById(@PathVariable("productId") UUID productId) {
        Produit produit = produitService.getProduitById(productId);
        return modelMapper.map(produit, ProductDto.class);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<?> deleteProduct(@RequestParam("id") UUID productId) {
        Produit produit = produitService.getProduitById(productId);
        produitService.deleteProduit(produit);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<?> updateNode(@PathVariable("id") UUID productId) {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

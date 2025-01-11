package Parte2.springcom.example.Parte2.demo.services;

import Parte2.springcom.example.Parte2.demo.models.Product;
import Parte2.springcom.example.Parte2.demo.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    //La capa de Service es la capa de manipulación de esos datos que vienen de la capa Repository
    private ProductRepository repository= new ProductRepository();
    public List<Product> findAll(){

        return repository.findAll().stream().map(p->{
            Double priceImp=p.getPrice()*1.25d;
            p.setPrice(priceImp.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return null;
    }
}

package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  
    private int productprice;
    private String productcode;   
    private String productname;
    private String productbrand;
        
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductbrand() {
		return productbrand;
	}
	public void setProductbrand(String productbrand) {
		this.productbrand = productbrand;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id - " + id + ", productcode - " + productcode + ", productprice -" + productprice
				+ ", productname -" + productname + ", productbrand -" + productbrand + ", category -" + category.getName() + "]";
	}
    
    
    
    
}

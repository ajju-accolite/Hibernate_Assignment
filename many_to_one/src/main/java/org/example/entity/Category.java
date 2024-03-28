package org.example.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private int id;
    
    @Column(name = "categorycode")
    private String categorycode;
    
	@Column(name = "name")
    private String name;
    
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    
    private List<Product>products;
	
    public String getCategorycode() {
		return categorycode;
	}
	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	 @Override
	    public String toString() {
	        StringBuilder output = new StringBuilder("Person [" +
	                "id - " + id +
	                ", Category Code -" + categorycode +
	                ", Name - " + name +
	                ", Product List - ");

	        for(Product p : products){
	        	output.append(p.getProductname()).append(", ");
	        }

	        output.append("]");

	        return output.toString();
	    }   
}
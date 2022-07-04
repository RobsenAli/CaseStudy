package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ProductFormBean {

    @NotEmpty(message="product name must not be empty")
    private String productName;
    @NotNull(message="product id must not be empty")
    private Integer productId;
    @NotEmpty(message="product category must not be empty")
    private String category;
    @NotEmpty(message="product description must not be empty")
    private String description;
    @NotEmpty(message="product imgUrl must not be empty")
    private String imageUrl;
    @NotNull(message="product price must not be empty")
    private Integer price;

}
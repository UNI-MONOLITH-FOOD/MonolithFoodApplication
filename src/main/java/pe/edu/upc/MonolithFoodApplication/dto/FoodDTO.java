package pe.edu.upc.MonolithFoodApplication.dto;

public class FoodDTO {
    private Long id;
    private String name;
    private String category;
    private String nutrient;

    public FoodDTO() {
    }

   
    public FoodDTO(Long id, String name, String category, String nutrient) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.nutrient = nutrient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNutrient() {
        return nutrient;
    }

    public void setNutrient(String nutrient) {
        this.nutrient = nutrient;
    }
}

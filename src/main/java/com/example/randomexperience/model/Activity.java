package com.example.randomexperience.model;


import com.example.randomexperience.model.enums.Category;
import com.example.randomexperience.model.enums.LocationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;

    private Double cost;

    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Activity() {}

    public Activity(String name,
                    String description,
                    Double cost,
                    Integer durationMinutes,
                    LocationType locationType,
                    Category category) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.durationMinutes = durationMinutes;
        this.locationType = locationType;
        this.category = category;
    }


    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getCost() { return cost; }
    public void setCost(Double cost) { this.cost = cost; }

    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }

    public LocationType getLocationType() { return locationType; }
    public void setLocationType(LocationType locationType) { this.locationType = locationType; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}

package org.example.backendstudy.domain.item;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.backendstudy.domain.item.grade.Grade;
import org.example.backendstudy.domain.item.types.Category;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String itemName; // 상품명
    private Long itemPrice; // 상품 가격
    private int itemCount; // 상품 재고 수량
    private String itemExplain; // 상품 설명

    @Enumerated(EnumType.STRING)
    private Category itemCategory; // 상품 카테고리

    @OneToMany(
            mappedBy = "item",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Grade> itemGradeList = new ArrayList<>();

    // add()
    public void addGrade(Grade grade) {
        grade.connectItem(this);
        itemGradeList.add(grade);
    }

    @Builder
    public Item(
            Long itemId, String itemName, Long itemPrice,
            int itemCount, String itemExplain, Category itemCategory
    ) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        this.itemExplain = itemExplain;
        this.itemCategory = itemCategory;
    }
}

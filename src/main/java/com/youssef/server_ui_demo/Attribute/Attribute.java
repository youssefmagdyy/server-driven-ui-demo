package com.youssef.server_ui_demo.Attribute;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "attributes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private AttributeType type;

    @Column(name = "attr_value")
    private String value;

}

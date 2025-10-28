package com.youssef.server_ui_demo.Attribute;

import org.springframework.stereotype.Service;

@Service
public class AttributeService {

    private final AttributeRepo attributeRepo;

    public AttributeService(AttributeRepo attributeRepo) {
        this.attributeRepo = attributeRepo;

        Attribute attr = new Attribute();
        attr.setName("bannerTextAttr");
        attr.setType(AttributeType.STRING);
        attr.setValue("Featured products of the day");
        attributeRepo.save(attr);

        Attribute featuredQueryAttr = new Attribute();
        featuredQueryAttr.setName("featuredProductsSQL");
        featuredQueryAttr.setType(AttributeType.SQL);
        featuredQueryAttr.setValue("SELECT * FROM Products WHERE featured = TRUE");
        attributeRepo.save(featuredQueryAttr);

        Attribute queryAttr = new Attribute();
        queryAttr.setName("productsSQL");
        queryAttr.setType(AttributeType.SQL);
        queryAttr.setValue("SELECT * FROM Products");
        attributeRepo.save(queryAttr);

    }
}

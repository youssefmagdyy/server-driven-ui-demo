package com.youssef.server_ui_demo.Attribute;

import org.springframework.stereotype.Service;

@Service
public class AttributeService {

    private final AttributeRepo attributeRepo;

    public AttributeService(AttributeRepo attributeRepo) {
        this.attributeRepo = attributeRepo;
        Attribute attr = new Attribute(); // no-args
        attr.setName("bannerTextAttr");
        attr.setType(AttributeType.STRING);
        attr.setValue("Featured products of the day");
        attributeRepo.save(attr);

    }
}

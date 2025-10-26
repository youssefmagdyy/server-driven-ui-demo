package com.youssef.server_ui_demo.Attribute;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttributeRepo extends JpaRepository<Attribute,Integer> {

    public Optional<Attribute> findByName(String name);
}

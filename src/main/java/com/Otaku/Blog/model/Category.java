package com.Otaku.Blog.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
public enum Category {
    Tshirt,Sweatshirt
}

package com.androidrobo;

import com.google.inject.AbstractModule;

public class BaseModule extends AbstractModule {
 
    @Override
    protected void configure() {
        //binding will be placed here.....
    	bind(IProductRepo.class).to(ProductRepo.class);
    }
 
}
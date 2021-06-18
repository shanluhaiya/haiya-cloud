package com.haiya.service.impl;

import com.haiya.service.ProductService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@DubboService(protocol = "rest")
@Path("/product")
public class ProductServiceImpl implements ProductService {
    @Override
    @Path("info/{id}")
    @GET
    public String info(@PathParam("id") String id) {
        return "Product id = " + id;
    }
}

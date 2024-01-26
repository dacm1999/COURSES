package com.dacm.springboot.demo.firstAppSpringBoot.rest;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

public class MyInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        System.out.println("Agregando información personalizada...");
        builder.withDetail("autor", "Tu Nombre")
                .withDetail("version", "1.0.0");
    }
}

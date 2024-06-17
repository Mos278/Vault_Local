package com.poc.vault.Controller

import com.poc.vault.DatasourceConfig
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test")
class testvault(var datasourceConfig: DatasourceConfig) {

    @GetMapping()
    fun test(): ResponseEntity<String>{
        var response = datasourceConfig.url + " " + datasourceConfig.password + " " + datasourceConfig.username
        return ResponseEntity.ok().body(response)
    }
}
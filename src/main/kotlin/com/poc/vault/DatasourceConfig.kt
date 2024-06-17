package com.poc.vault

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "vault")
class DatasourceConfig() {
    var url : String? = null
    var password : String? = null
    var username : String? = null


}
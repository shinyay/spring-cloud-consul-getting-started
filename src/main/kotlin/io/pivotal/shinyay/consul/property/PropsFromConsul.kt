package io.pivotal.shinyay.consul.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Configuration

@RefreshScope
@Configuration
@ConfigurationProperties("my")
class PropsFromConsul {
    lateinit var prop: String
}
package io.pivotal.shinyay.consul.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.net.URI

@RestController
class DiscoveryClientController(val discoveryClient: DiscoveryClient) {

    val restTemplate = RestTemplate()

    @GetMapping("/discoveryClient")
    fun discoveryCheck(): String? {
        val service: URI = discoveryClient.getInstances("myApp")
                .stream()
                .findFirst()
                .map { si -> si.uri }
                .map { s -> s.resolve("/ping") }
                .get()
        return restTemplate.getForEntity(service, String::class.java).body
    }

    @GetMapping("/hello")
    fun hello():String = "Hello"
}
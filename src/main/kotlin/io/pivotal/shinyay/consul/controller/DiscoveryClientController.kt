package io.pivotal.shinyay.consul.controller

import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.net.URI

@RestController
class DiscoveryClientController(val discoveryClient: DiscoveryClient) {

    val restTemplate = RestTemplate()

    @GetMapping("/discoveryClient")
    fun discoveryCheck(): String? {
        val service: URI = discoveryClient.getInstances("my-app")
                .stream()
                .findFirst()
                .map { si -> si.uri }
                .map { s -> s.resolve("/hello") }
                .get()
        return restTemplate.getForEntity(service, String::class.java).body
    }

    @GetMapping("/hello")
    fun hello():String = "Hello"

    @GetMapping("/my-health-check")
    fun healthCheck(): ResponseEntity<URI> = ResponseEntity(HttpStatus.OK)
}